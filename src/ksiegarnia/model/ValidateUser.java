package ksiegarnia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ksiegarnia.dao.KsiegarniaDAO;

public class ValidateUser {
	
	
	public static boolean checkUser(String login,String haslo) 
    {
		KsiegarniaDAO ksiegarnia = new KsiegarniaDAO();
        boolean st =false;
        try(Connection connection = ksiegarnia.DBSQLConnection();
		 PreparedStatement ps =
		connection.prepareStatement("select * from ksiegarnia.uzytkownicy where login=? and haslo=?");)
			//connection.ps("select * from register where email=? and pass=?"));)
        {  
           
            ps.setString(1, login);
            ps.setString(2, haslo);
            System.out.println(ps);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st; 
    }
     

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
