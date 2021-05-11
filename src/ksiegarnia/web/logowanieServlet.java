package ksiegarnia.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ksiegarnia.dao.UzytkownicyDAO;
import ksiegarnia.model.Uzytkownicy;
import ksiegarnia.model.ValidateUser;

/**
 * Servlet implementation class logowanieServlet
 */
@WebServlet("/login")
public class logowanieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UzytkownicyDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logowanieServlet() {
        super();
        dao = new UzytkownicyDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
        
        String login = request.getParameter("login");
        String haslo = request.getParameter("password");
        String error = "";
        if(ValidateUser.checkUser(login, haslo))
        {
        	String wartosc = "Wyloguj";
        	String zakryj = "none";
        	String zakryj2 = "none";
        	String zakryj3 = "inline";
        	if(login.equals("admin"))
            {
            	zakryj2="";
            }
        	error="";
        	Uzytkownicy user = new Uzytkownicy();
        	user = dao.selectUzytkownicy(dao.selectIdUzytkownika(login).getIdklienta());
            HttpSession session = request.getSession();
            session.setAttribute("zakryj",zakryj);
            session.setAttribute("zakryj2",zakryj2);
            session.setAttribute("zakryj3",zakryj3);
            session.setAttribute("logowanie",wartosc);
			session.setAttribute("username",login);
			session.setAttribute("error", error);
			session.setAttribute("user", user);
            response.sendRedirect("menu.jsp");
            
        }
        else
        {
        	String wartosc = "Zaloguj";
        	String href = "zaloguj.jsp";
        	 error = "Podano niewlasciwy login lub haslo";
        	HttpSession session = request.getSession();
        	session.setAttribute("loguj",href);
        	session.setAttribute("logowanie",wartosc);
        	session.setAttribute("error", error);
			response.sendRedirect("zaloguj.jsp");
        }
    } 
}


