package ksiegarnia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksiegarnia.model.Kategorie;
import ksiegarnia.model.Wydawnictwa;

public class WydawnictwaDAO {

	private static final String SELECT_ALL_WYDAWNICTWO = "select * from ksiegarnia.wydawnictwa";
	private static final String SELECT_WYDAWNICTWO_BY_ID = "select id_wyd, nazwa from ksiegarnia.wydawnictwa where id_wyd =?";
	private static final String INSERT_WYDAWNICTWO_SQL = "INSERT INTO ksiegarnia.wydawnictwa" + "(nazwa) VALUES (?);";
	private static final String UPDATE_WYDAWNICTWO_SQL = "update ksiegarnia.wydawnictwa set nazwa=? where id_wyd = ?;";
	private static final String DELETE_WYDAWNICTWO_SQL = "delete from ksiegarnia.wydawnictwa where id_wyd = ?;";
	KsiegarniaDAO ksiegarnia = new KsiegarniaDAO();
	
	public WydawnictwaDAO() {
	}
	
	private void printSQLException(SQLException ex) {
		 for (Throwable e: ex) {
			 if (e instanceof SQLException) {
				 e.printStackTrace(System.err);
				 System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				 System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				 System.err.println("Message: " + e.getMessage());
				 Throwable t = ex.getCause();
				 while (t != null) {
					 System.out.println("Cause: " + t);
					 t = t.getCause();
					 }
				 }
			 }
		}

	public Wydawnictwa selectWydawnictwo(int id_wyd) {
		 Wydawnictwa wydawnictwo = null;
		
		 try(Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_WYDAWNICTWO_BY_ID);)
			 {
			 preparedStatement.setInt(1, id_wyd);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 String t_nazwa = rs.getString("nazwa");
				 wydawnictwo = new Wydawnictwa(id_wyd,t_nazwa);
				 }
			 }
		 catch (SQLException e) { printSQLException(e); }
		 return wydawnictwo;
	}
	
	public List <Wydawnictwa> selectAllWydawnictwa() {
	 List <Wydawnictwa> wydawnictwo = new ArrayList <> ();
	 try (Connection connection = ksiegarnia.DBSQLConnection();
	 PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_WYDAWNICTWO);)
	 {
		 System.out.println(preparedStatement);
		 ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			 int t_id = rs.getInt("id_wyd");
			 String t_nazwa = rs.getString("nazwa");
			 wydawnictwo.add(new Wydawnictwa(t_id, t_nazwa));
		 }
	 }
	 catch (SQLException e) { printSQLException(e);}
	 return wydawnictwo;
	}

	public boolean deleteWydawnictwa(int id_wyd) throws SQLException {
		 boolean rowDeleted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_WYDAWNICTWO_SQL);)
		 {
			 statement.setInt(1, id_wyd);
			 rowDeleted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowDeleted;
	}
	
	public boolean updateWydawnictwo(Wydawnictwa wydawnictwo) throws SQLException 
	{	 
		boolean rowUpdated=false;
			 try (Connection connection = ksiegarnia.DBSQLConnection();
				 PreparedStatement statement = connection.prepareStatement(UPDATE_WYDAWNICTWO_SQL);)
			 {
				 statement.setInt(2, wydawnictwo.getId_wyd());
				 statement.setString(1, wydawnictwo.getNazwa());
				 rowUpdated = statement.executeUpdate() > 0;
			 }
			 catch (SQLException e) { printSQLException(e);}
			 return rowUpdated;
		}
	
	public boolean insertWydawnictwo(Wydawnictwa wydawnictwo) throws SQLException
	{
		boolean rowInserted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(INSERT_WYDAWNICTWO_SQL);)
		 {
			 statement.setString(1, wydawnictwo.getNazwa());
			 rowInserted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowInserted;
	}
}
