package ksiegarnia.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ksiegarnia.model.Ksiazki;
import ksiegarnia.model.Uzytkownicy;

/**
 * Servlet implementation class ZrealizujZamowienieServlet
 */
@WebServlet("/zamowienie")
public class ZrealizujZamowienieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZrealizujZamowienieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
request.setCharacterEncoding("UTF-8");

		HttpSession session2 = request.getSession();
		
		String dostawa = request.getParameter("scales");
		String platnosc = request.getParameter("platnosc");
		
		String to = "pawel.muller1998@gmail.com";
		 
	      // Sender's email ID needs to be mentioned
	      String from = "vallennous@gmail.com";
	      String pass = "rockstone321";
	 
	      // Assuming you are sending email from localhost
	      String host = "localhost";
	      
	      String zakupy = "";
	      
	      ArrayList<Ksiazki> tk = new ArrayList<Ksiazki>();
	      
	      tk = (ArrayList<Ksiazki>) session2.getAttribute("cart");
	 
	      for(int i=0; i<tk.size(); i++)
	      {
	    	  zakupy += "<b>Tytul:</b> " + tk.get(i).getTytul() + " <b>Ilosc:</b> " +tk.get(i).getIlosc_w_koszyku() + "     ";
	      }
	      
	      Uzytkownicy user = new Uzytkownicy();
	      
	      user = (Uzytkownicy) session2.getAttribute("user");
	      
	      String users = "<b>Imie:</b> " + user.getImie() + "   <b>Nazwisko:</b> " + user.getNazwisko() + "   <b>Adres:</b> " + user.getUlica() + ", " + user.getMiejscowosc() + " " +user.getKod_pocztowy();
	      
	       
	      // Get system properties
	      Properties props = System.getProperties();
	 
	      // Setup mail server
	      props.put("mail.smtp.host", "smtp.gmail.com");
	        // below mentioned mail.smtp.port is optional 
	        props.put("mail.smtp.port", "587");		
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	 
	      // Get the default Session object.
	        Session session = Session.getInstance(props,new javax.mail.Authenticator()
	        {
	            protected PasswordAuthentication getPasswordAuthentication()
	            {
	  	 	         return new PasswordAuthentication(from,pass); 
	            }
	        });
	      
	      // Set response content type
	      response.setContentType("text/html");
	      

	      try {
	         // Create a default MimeMessage object.
	    	  MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	            message.setSubject("Zamówienie");
	           // message.setText(zakupy);
	            message.setContent(
	            		"<h3>Dane zamowienia</h3>"+
	            		"<p>" + zakupy +"</p>"+
	            		"<p>" + users +"</p>"+
	            		"<p><b>Forma dostawy: </b>" + dostawa +"</p>"+
	            		"<p><b>Forma platnosci: </b>" + platnosc +"</p>",
	            		"text/html");

	            /* Transport class is used to deliver the message to the recipients */
	           
	            Transport.send(message);
	            String nextURL="/zamowienie";
	    		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextURL);
	         
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	      

	   
		response.getWriter().append("Served at: ").append(request.getContextPath());
		session2.removeAttribute("total");
		session2.removeAttribute("cart");
		String nextURL="/podsumowanie.jsp";
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextURL);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
