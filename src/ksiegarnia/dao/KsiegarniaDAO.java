package ksiegarnia.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KsiegarniaDAO {

	private final String url = "jdbc:postgresql://localhost:5432/s44350?currentSchema=\"ksiegarnia\"";
	private final String user = "s44350";
	private final String password = "7s5wJc2m(";
	
	Connection connection = null;
	
	public Connection DBSQLConnection() {
	 try {
		 Class.forName("org.postgresql.Driver");
		 connection = DriverManager.getConnection(url, user, password);
		if(connection.isValid(5)) System.out.println("Connection is working");
		 }
	 catch (SQLException e) {
		 e.printStackTrace();
		 }
	 catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 }
	 return connection;
	}
 
	private void DBSQLConnectionClose(){
	 if(connection==null) return;
	 try{
		connection.close();
		if(!connection.isValid(5)) System.out.println("Connection closed");
		 }
	 catch(SQLException e){
		e.printStackTrace();}
		}
 
	public KsiegarniaDAO() {
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
	public static void main(String[] args)
	{
		 KsiegarniaDAO dao = new KsiegarniaDAO();
		 dao.DBSQLConnection();
		 dao.DBSQLConnectionClose();
	}
}
