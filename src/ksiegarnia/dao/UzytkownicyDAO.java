package ksiegarnia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksiegarnia.model.Ksiazki;
import ksiegarnia.model.Uzytkownicy;

public class UzytkownicyDAO {

	private static final String SELECT_ALL_UZYTKOWNICY = "select * from ksiegarnia.dane_uzytkownika";
	private static final String SELECT_UZYTKOWNICY_BY_ID = "select id_uzytkownika, imie, nazwisko, miejscowosc, ulica, kod_pocztowy, e_mail from ksiegarnia.dane_uzytkownika where id_uzytkownika =?";
	private static final String INSERT_UZYTKOWNICY_SQL = "INSERT INTO ksiegarnia.dane_uzytkownika" + "(imie, nazwisko, miejscowosc, ulica, kod_pocztowy,e_mail) VALUES (?, ?, ?, ?, ?, ?);";
	private static final String DELETE_UZYTKOWNICY_SQL = "delete from ksiegarnia.dane_uzytkownika where id_uzytkownika = ?;";
	private final String UPDATE_UZYTKOWNICY_SQL = "update ksiegarnia.dane_uzytkownika set imie=?, nazwisko=?, miejscowosc=?, ulica=?, kod_pocztowy=?,e_mail=? where id_uzytkownika = ?;";
	
	private static final String SELECT_ALL_NAMEPASSWORD = "select * from ksiegarnia.uzytkownicy";
	private static final String SELECT_NAMEPASSWORD_BY_ID = "select login,haslo from ksiegarnia.uzytkownicy where id_uzytkownika =?";
	private static final String INSERT_NAMEPASSWORD_SQL = "INSERT INTO ksiegarnia.uzytkownicy" + "(login, haslo) VALUES (?, ?);";
	private static final String DELETE_NAMEPASSWORD_SQL = "delete from ksiegarnia.uzytkownicy where id_uzytkownika = ?;";
	private final String UPDATE_NAMEPASSWORD_SQL = "update ksiegarnia.uzytkownicy set login=?, haslo=? where id_uzytkownika = ?;";
	private static final String SELECT_IDUZYTKOWNIKA = "select id_uzytkownika, haslo from ksiegarnia.uzytkownicy where login =?";

	KsiegarniaDAO ksiegarnia = new KsiegarniaDAO();
	
	public UzytkownicyDAO() {
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

	public Uzytkownicy selectUzytkownicy(int id_uzytkownika) {
		Uzytkownicy uzytkownik = null;
		
		 try(Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_UZYTKOWNICY_BY_ID);)
			 {
			 preparedStatement.setInt(1, id_uzytkownika);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 String t_imie = rs.getString("imie");
				 String t_nazwisko = rs.getString("nazwisko");
				 String t_miejscowosc = rs.getString("miejscowosc");
				 String t_ulica = rs.getString("ulica");
				 String t_kod_pocztowy = rs.getString("kod_pocztowy");
				 String t_e_mail = rs.getString("e_mail");

				 uzytkownik = new Uzytkownicy(id_uzytkownika,t_imie,t_nazwisko,t_miejscowosc,t_ulica,t_kod_pocztowy,t_e_mail);
				 }
			 }
		 catch (SQLException e) { printSQLException(e); }
		 return uzytkownik;
	}
	
	public List <Uzytkownicy> selectAllUzytkownikow() {
	 List <Uzytkownicy> uzytkownicy = new ArrayList <> ();
	 try (Connection connection = ksiegarnia.DBSQLConnection();
	 PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_UZYTKOWNICY);)
	 {
		 System.out.println(preparedStatement);
		 ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			 int id_uzytkownika = rs.getInt("id_uzytkownika");
			 String t_imie = rs.getString("imie");
			 String t_nazwisko = rs.getString("nazwisko");
			 String t_miejscowosc = rs.getString("miejscowosc");
			 String t_ulica = rs.getString("ulica");
			 String t_kod_pocztowy = rs.getString("kod_pocztowy");
			 String t_e_mail = rs.getString("e_mail");
			 uzytkownicy.add(new Uzytkownicy(id_uzytkownika,t_imie,t_nazwisko,t_miejscowosc,t_ulica,t_kod_pocztowy,t_e_mail));
		 }
	 }
	 catch (SQLException e) { printSQLException(e);}
	 return uzytkownicy;
	}

	public boolean deleteUzytkownicy(int id_uzytkownika) throws SQLException {
		 boolean rowDeleted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_UZYTKOWNICY_SQL);)
		 {
			 statement.setInt(1, id_uzytkownika);
			 rowDeleted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowDeleted;
	}
	
	public boolean insertUzytkownicy(Uzytkownicy uzytkownik) throws SQLException
	{
		boolean rowInserted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(INSERT_UZYTKOWNICY_SQL);)
		 {
			 statement.setString(1, uzytkownik.getImie());
			 statement.setString(2, uzytkownik.getNazwisko());
			 statement.setString(3, uzytkownik.getMiejscowosc());
			 statement.setString(4, uzytkownik.getUlica());
			 statement.setString(5, uzytkownik.getKod_pocztowy());
			 statement.setString(6, uzytkownik.getEmail());
			 rowInserted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowInserted;
	}
	
	public boolean updateUzytkownicy(Uzytkownicy uzytkownik) throws SQLException 
	{	 
		boolean rowUpdated=false;
			 try (Connection connection = ksiegarnia.DBSQLConnection();
				 PreparedStatement statement = connection.prepareStatement(UPDATE_UZYTKOWNICY_SQL);)
			 {
				 statement.setString(1, uzytkownik.getImie());
				 statement.setString(2, uzytkownik.getNazwisko());
				 statement.setString(3, uzytkownik.getMiejscowosc());
				 statement.setString(4, uzytkownik.getUlica());
				 statement.setString(5, uzytkownik.getKod_pocztowy());
				 statement.setString(6, uzytkownik.getEmail());
				 rowUpdated = statement.executeUpdate() > 0;
			 }
			 catch (SQLException e) { printSQLException(e);}
			 return rowUpdated;
	}	
		
	public Uzytkownicy selectNamePassword(int id_uzytkownika) {
		Uzytkownicy uzytkownik = null;
		
		 try(Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_NAMEPASSWORD_BY_ID);)
			 {
			 preparedStatement.setInt(1, id_uzytkownika);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 String t_login = rs.getString("login");
				 String t_haslo = rs.getString("haslo");

				 uzytkownik = new Uzytkownicy(id_uzytkownika,t_login, t_haslo);
				 }
			 }
		 catch (SQLException e) { printSQLException(e); }
		 return uzytkownik;
	}
	
	public List <Uzytkownicy> selectAllNamePassword() {
	 List <Uzytkownicy> uzytkownicy = new ArrayList <> ();
	 try (Connection connection = ksiegarnia.DBSQLConnection();
	 PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_NAMEPASSWORD);)
	 {
		 System.out.println(preparedStatement);
		 ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			 int id_uzytkownika = rs.getInt("id_uzytkownika");
			 String t_login = rs.getString("login");
			 String t_haslo = rs.getString("haslo");
			 uzytkownicy.add(new Uzytkownicy(id_uzytkownika,t_login, t_haslo));
		 }
	 }
	 catch (SQLException e) { printSQLException(e);}
	 return uzytkownicy;
	}

	public boolean deleteNamePassword(int id_uzytkownika) throws SQLException {
		 boolean rowDeleted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_NAMEPASSWORD_SQL);)
		 {
			 statement.setInt(1, id_uzytkownika);
			 rowDeleted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowDeleted;
	}
	
	public boolean insertNamePassword(Uzytkownicy uzytkownik) throws SQLException
	{
		boolean rowInserted=false;
		 try (Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement statement = connection.prepareStatement(INSERT_NAMEPASSWORD_SQL);)
		 {
			 statement.setString(1, uzytkownik.getLogin());
			 statement.setString(2, uzytkownik.getHaslo());

			 rowInserted = statement.executeUpdate() > 0;
		 }
		 catch (SQLException e) { printSQLException(e);}
		 return rowInserted;
	}
	
	public boolean updateNamePassword(Uzytkownicy uzytkownik) throws SQLException 
	{	 
		boolean rowUpdated=false;
			 try (Connection connection = ksiegarnia.DBSQLConnection();
				 PreparedStatement statement = connection.prepareStatement(UPDATE_NAMEPASSWORD_SQL);)
			 {
				 statement.setString(1, uzytkownik.getLogin());
				 statement.setString(2, uzytkownik.getHaslo());
				 rowUpdated = statement.executeUpdate() > 0;
			 }
			 catch (SQLException e) { printSQLException(e);}
			 return rowUpdated;
	}
	
	public Uzytkownicy selectIdUzytkownika(String login) {
		Uzytkownicy uzytkownik = null;
		
		 try(Connection connection = ksiegarnia.DBSQLConnection();
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_IDUZYTKOWNIKA);)
			 {
			 preparedStatement.setString(1, login);
			 System.out.println(preparedStatement);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 int id_uzytkownika = rs.getInt("id_uzytkownika");
				 String t_haslo = rs.getString("haslo");

				 uzytkownik = new Uzytkownicy(id_uzytkownika,login, t_haslo);
				 }
			 }
		 catch (SQLException e) { printSQLException(e); }
		 return uzytkownik;
	}
}
