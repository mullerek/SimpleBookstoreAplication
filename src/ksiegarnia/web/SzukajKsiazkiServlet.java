package ksiegarnia.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ksiegarnia.dao.KsiazkiDAO;
import ksiegarnia.model.Ksiazki;

/**
 * Servlet implementation class SzukajKsiazkiServlet
 */
@WebServlet("/SzukajKsiazkiServlet")
public class SzukajKsiazkiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SzukajKsiazkiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		KsiazkiDAO dao=new KsiazkiDAO();
		HttpSession sesja=request.getSession();
		String error ="";	
		String display ="";	
		String nazwa = request.getParameter("nazwa")+"%";
		
		ArrayList<Ksiazki> tk = new ArrayList<Ksiazki>();
		tk.removeAll(tk);
		tk = dao.selectKsiazkiBySzukaj(nazwa);
		
		if(tk.isEmpty()==true)
		{
			error = "Brak Ksiazki";
			display="none";
		}else
		{
			error="";
					
		}
		sesja.setAttribute("error", error);
		sesja.setAttribute("display", display);
		sesja.setAttribute("tk", tk);
		String nextURL="/ksiazki.jsp";
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
