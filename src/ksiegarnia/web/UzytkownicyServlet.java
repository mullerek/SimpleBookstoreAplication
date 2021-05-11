package ksiegarnia.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ksiegarnia.dao.UzytkownicyDAO;
import ksiegarnia.model.Ksiazki;
import ksiegarnia.model.Uzytkownicy;

/**
 * Servlet implementation class UzytkownicyServlet
 */
@WebServlet("/User")
public class UzytkownicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UzytkownicyDAO uzytkownicyDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UzytkownicyServlet() {
    	super();
    	uzytkownicyDAO = new UzytkownicyDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acao = request.getParameter("action");
		String action = request.getServletPath();
		System.out.println(acao);
		response.getWriter().append(action);
		try {
			switch (acao) 
			{
			case "newUser":
			showNewFormUzytkownik(request, response); break;
			case "insertUser":
			insertUzytkownik(request, response); break;
			case "deleteUser":
			deleteKsiazka(request, response); break;
			case "editUser":
			showEditFormUzytkownik(request, response); break;
			case "updateUser":
			updateUser(request, response); break;
			default:
			listUser(request, response); break;
			}
		}
		catch (SQLException ex) { throw new ServletException(ex); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Uzytkownicy> listUzytkownicy = uzytkownicyDAO.selectAllUzytkownikow();
		request.setAttribute("listUzytkownicy", listUzytkownicy);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertUzytkownik(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
		{
			String login = request.getParameter("login");
			String haslo = request.getParameter("haslo");
			
			String imie = request.getParameter("imie");
			String nazwisko = request.getParameter("nazwisko");
			String miejscowosc = request.getParameter("miejscowosc");
			String ulica = request.getParameter("ulica");
			String kod_pocztowy = request.getParameter("kod_pocztowy");
			String email = request.getParameter("email");
			
			
			
			Uzytkownicy vUzytkownik1 = new Uzytkownicy(login,haslo);
			Uzytkownicy vUzytkownik2 = new Uzytkownicy(imie,nazwisko,miejscowosc,ulica,kod_pocztowy,email);
			
			
			uzytkownicyDAO.insertUzytkownicy(vUzytkownik2);
			
			uzytkownicyDAO.insertNamePassword(vUzytkownik1);
			
			
			response.sendRedirect("index.jsp");
			
		}
	
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException 
	{
		int id1 = Integer.parseInt(request.getParameter("id_log"));
		int id2 = Integer.parseInt(request.getParameter("id_dane"));
		String login = request.getParameter("login");
		String haslo = request.getParameter("haslo");
		
		String imie = request.getParameter("imie");
		String nazwisko = request.getParameter("nazwisko");
		String miejscowosc = request.getParameter("miejscowosc");
		String ulica = request.getParameter("ulica");
		String kod_pocztowy = request.getParameter("kod_pocztowy");
		String email = request.getParameter("email");
		
		Uzytkownicy vUzytkownik1 = new Uzytkownicy(id2,login,haslo);
		Uzytkownicy vUzytkownik2 = new Uzytkownicy(id1,imie,nazwisko,miejscowosc,ulica,kod_pocztowy,email);
		
		uzytkownicyDAO.updateUzytkownicy(vUzytkownik2);
		uzytkownicyDAO.updateNamePassword(vUzytkownik1);
		
		response.sendRedirect("list");
		
	}
	
	
	
	private void deleteKsiazka(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException 
	{
		int id1 = Integer.parseInt(request.getParameter("id_log"));
		int id2 = Integer.parseInt(request.getParameter("id_dane"));
		
		uzytkownicyDAO.deleteNamePassword(id1);
		uzytkownicyDAO.deleteUzytkownicy(id2);
		response.sendRedirect("list");
	}
	
	private void showEditFormUzytkownik(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		
		int id2 = Integer.parseInt(request.getParameter("id_dane"));
		
		
		Uzytkownicy uzyt2 = uzytkownicyDAO.selectUzytkownicy(id2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", uzyt2);
		dispatcher.forward(request, response);
	}
	
	private void showNewFormUzytkownik(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

}
