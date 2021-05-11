package ksiegarnia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksiegarnia.model.Ksiazki;

public class KsiazkiDAO {

	private static final String SELECT_ALL_KSIAZKI = "select * from ksiegarnia.ksiazki";
	private static final String SELECT_KSIAZKI_BY_ID = "select id_ksiazki, tytul, autor, cena, ilosc, id_kat, id_wyd from ksiegarnia.ksiazki where id_ksiazki =?";
	private static final String SELECT_KSIAZKI_BY_IDKAT = "select id_ksiazki, tytul, autor, cena, ilosc, id_kat, id_wyd from ksiegarnia.ksiazki where id_kat =?";
	private static final String SELECT_KSIAZKI_BY_SZUKAJ = "select id_ksiazki, tytul, autor, cena, ilosc, id_kat, id_wyd from ksiegarnia.ksiazki where UPPER(tytul) LIKE UPPER(?)";
	private static final String INSERT_KSIAZKI_SQL = "INSERT INTO ksiegarnia.ksiazki" + "(tytul, autor, cena, ilosc, id_kat, id_wyd) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String DELETE_KSIAZKI_SQL = "delete from ksiegarnia.ksiazki where id_ksiazki = ?;";
	private final String UPDATE_KSIAZKI_SQL = "update ksiegarnia.ksiazki set tytul=?, autor=?, cena=?, ilosc=?, id_kat=?, id_wyd=? where id_ksiazki = ?;";
	KsiegarniaDAO ksiegarnia = new KsiegarniaDAO();
	
	public KsiazkiDAO() {
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

	public Ksiazki selectKsiazki(int id_uzytkownika) {
		Ksiazki ksiazki = null;
		
		 try(Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_KSIAZKI_BY_ID);)
			 {
			 preparedStatement.setInt(1, id_uzytkownika);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 String t_tytul = rs.getString("tytul");
				 String t_autor = rs.getString("autor");
				 Double t_cena = rs.getDouble("cena");
				 int t_ilosc = rs.getInt("ilosc");
				 int t_id_kat = rs.getInt("id_kat");
				 int t_id_wyd = rs.getInt("id_wyd");

				 ksiazki = new Ksiazki(id_uzytkownika,t_tytul,t_autor,t_cena,t_ilosc,t_id_kat,t_id_wyd);
				 }
			 }
		 catch (SQLException e) { printSQLException(e); }
		 return ksiazki;
	}
	
	public ArrayList <Ksiazki> selectKsiazkiByIdkat(int idkat) {
		ArrayList <Ksiazki> ksiazki = new ArrayList <> ();
		 try (Connection connection = ksiegarnia.DBSQLConnection();
		 PreparedStatement preparedStatement =
		 connection.prepareStatement(SELECT_KSIAZKI_BY_IDKAT);)
		 {
			 preparedStatement.setInt(1, idkat);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 int id_ksiazki = rs.getInt("id_ksiazki");
				 String t_tytul = rs.getString("tytul");
				 String t_autor = rs.getString("autor");
				 Double t_cena = rs.getDouble("cena");
				 int t_ilosc = rs.getInt("ilosc");
				 int t_id_wyd = rs.getInt("id_wyd");
				 ksiazki.add(new Ksiazki(id_ksiazki, t_tytul, t_autor, t_cena, t_ilosc, idkat, t_id_wyd));
			 }
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return ksiazki;
	}
	
	public ArrayList <Ksiazki> selectKsiazkiBySzukaj(String nazwa) {
		ArrayList <Ksiazki> ksiazki = new ArrayList <> ();

		 try (Connection connection = ksiegarnia.DBSQLConnection();
		 PreparedStatement preparedStatement =
		 connection.prepareStatement(SELECT_KSIAZKI_BY_SZUKAJ);)
		 {
			 preparedStatement.setString(1, nazwa);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 int id_ksiazki = rs.getInt("id_ksiazki");
				 String t_tytul = rs.getString("tytul");
				 String t_autor = rs.getString("autor");
				 Double t_cena = rs.getDouble("cena");
				 int t_ilosc = rs.getInt("ilosc");
				 int t_id_kat = rs.getInt("id_kat");
				 int t_id_wyd = rs.getInt("id_wyd");
				 ksiazki.add(new Ksiazki(id_ksiazki, t_tytul, t_autor, t_cena, t_ilosc, t_id_kat, t_id_wyd));
			 }
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return ksiazki;
	}
	
	public List <Ksiazki> selectAllKsiazki() {
	 List <Ksiazki> ksiazki = new ArrayList <> ();
	 try (Connection connection = ksiegarnia.DBSQLConnection();
	 PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_KSIAZKI);)
	 {
		 System.out.println(preparedStatement);
		 ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			 int id_ksiazki = rs.getInt("id_ksiazki");
			 String t_tytul = rs.getString("tytul");
			 String t_autor = rs.getString("autor");
			 Double t_cena = rs.getDouble("cena");
			 int t_ilosc = rs.getInt("ilosc");
			 int t_id_kat = rs.getInt("id_kat");
			 int t_id_wyd = rs.getInt("id_wyd");
			 ksiazki.add(new Ksiazki(id_ksiazki, t_tytul, t_autor, t_cena, t_ilosc, t_id_kat, t_id_wyd));
		 }
	 }
	 catch (SQLException e) { printSQLException(e);}
	 return ksiazki;
	}

	public boolean deleteKsiazki(int id_ksiazki) throws SQLException {
		 boolean rowDeleted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_KSIAZKI_SQL);)
		 {
			 statement.setInt(1, id_ksiazki);
			 rowDeleted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowDeleted;
	}
	
	public boolean insertKsiazki(Ksiazki ksiazka) throws SQLException
	{
		boolean rowInserted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(INSERT_KSIAZKI_SQL);)
		 {
			 statement.setString(1, ksiazka.getTytul());
			 statement.setString(2, ksiazka.getAutor());
			 statement.setDouble(3, ksiazka.getCena());
			 statement.setInt(4, ksiazka.getIlosc());
			 statement.setInt(5, ksiazka.getId_kat());
			 statement.setInt(6, ksiazka.getId_wyd());
			 rowInserted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowInserted;	 
	}

	public boolean updateKsiazki(Ksiazki ksiazka) throws SQLException 
	{	 
		boolean rowUpdated=false;
			 try (Connection connection = ksiegarnia.DBSQLConnection();
				 PreparedStatement statement = connection.prepareStatement(UPDATE_KSIAZKI_SQL);)
			 {
				 statement.setString(1, ksiazka.getTytul());
				 statement.setString(2, ksiazka.getAutor());
				 statement.setDouble(3, ksiazka.getCena());
				 statement.setInt(4, ksiazka.getIlosc());
				 statement.setInt(5, ksiazka.getId_kat());
				 statement.setInt(6, ksiazka.getId_wyd());
				 statement.setInt(7, ksiazka.getId_ksiazki());
				 rowUpdated = statement.executeUpdate() > 0;
			 }
			 catch (SQLException e) { printSQLException(e);}
			 return rowUpdated;
		}	
}
