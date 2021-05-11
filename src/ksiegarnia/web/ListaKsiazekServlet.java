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
 * Servlet implementation class ListaKsiazekServlet
 */
@WebServlet("/ListaKsiazekServlet")
public class ListaKsiazekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaKsiazekServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		KsiazkiDAO dao=new KsiazkiDAO();
		HttpSession sesja=request.getSession();
		
		if(request.getParameterMap().containsKey("idkat"))
		{
			int idkategorii = Integer.parseInt(request.getParameter("idkat"));
			ArrayList<Ksiazki> tk2 = dao.selectKsiazkiByIdkat(idkategorii);
			sesja.setAttribute("tk", tk2);
			sesja.setAttribute("idkat", idkategorii);
		}
		else
		{
			ArrayList<Ksiazki> tk = (ArrayList<Ksiazki>) dao.selectAllKsiazki();
			sesja.setAttribute("tk", tk);
		}
		sesja.setAttribute("error", " ");
		sesja.setAttribute("display", " ");
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
