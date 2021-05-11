package ksiegarnia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksiegarnia.model.Kategorie;

public class KategorieDAO {

	private static final String SELECT_ALL_KATEGORIE = "select * from ksiegarnia.kategorie";
	private static final String SELECT_KATEGORIE_BY_ID = "select id_kat, nazwa from ksiegarnia.kategorie where id_kat =?";
	private static final String INSERT_KATEGORIE_SQL = "INSERT INTO ksiegarnia.kategorie" + "(nazwa,id_kat) VALUES (?,?) ;";
	private static final String UPDATE_KATEGORIE_SQL = "update ksiegarnia.kategorie set nazwa=? where id_kat = ?;";
	private static final String DELETE_KATEGORIE_SQL = "delete from ksiegarnia.kategorie where id_kat = ?;";
	KsiegarniaDAO ksiegarnia = new KsiegarniaDAO();
	
	public KategorieDAO() {
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

	public Kategorie selectKategorie(int id_kat) {
		 Kategorie kategoria = null;
		
		 try(Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_KATEGORIE_BY_ID);)
			 {
			 preparedStatement.setInt(1, id_kat);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 String t_nazwa = rs.getString("nazwa");
				 kategoria = new Kategorie(id_kat,t_nazwa);
				 }
			 }
		 catch (SQLException e) { printSQLException(e); }
		 return kategoria;
	}
	
	public List <Kategorie> selectAllKategorie() {
	 List <Kategorie> kategorie = new ArrayList <> ();
	 try (Connection connection = ksiegarnia.DBSQLConnection();
	 PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_KATEGORIE);)
	 {
		 System.out.println(preparedStatement);
		 ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			 int t_id = rs.getInt("id_kat");
			 String t_nazwa = rs.getString("nazwa");
			 kategorie.add(new Kategorie(t_id, t_nazwa));
		 }
	 }
	 catch (SQLException e) { printSQLException(e);}
	 return kategorie;
	}

	public boolean deleteKategoria(int id_kat) throws SQLException {
		 boolean rowDeleted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_KATEGORIE_SQL);)
		 {
			 statement.setInt(1, id_kat);
			 rowDeleted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowDeleted;
	}
	
	public boolean updateKategorie(Kategorie kategoria) throws SQLException 
	{	 
		boolean rowUpdated=false;
			 try (Connection connection = ksiegarnia.DBSQLConnection();
				 PreparedStatement statement = connection.prepareStatement(UPDATE_KATEGORIE_SQL);)
			 {
				 statement.setInt(2, kategoria.getId_kat());
				 statement.setString(1, kategoria.getNazwa());
				 rowUpdated = statement.executeUpdate() > 0;
			 }
			 catch (SQLException e) { printSQLException(e);}
			 return rowUpdated;
		}
	
	public boolean insertKategorie(Kategorie kategoria) throws SQLException
	{
		boolean rowInserted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(INSERT_KATEGORIE_SQL);)
		 {
			 
			 statement.setString(1, kategoria.getNazwa());
			 statement.setInt(2, kategoria.getId_kat());
			 rowInserted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowInserted;
	}
}

