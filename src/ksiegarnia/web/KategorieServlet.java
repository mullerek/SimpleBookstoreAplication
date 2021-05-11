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

import ksiegarnia.dao.KategorieDAO;
import ksiegarnia.model.Kategorie;
import ksiegarnia.model.Wydawnictwa;

/**
 * Servlet implementation class KategorieSerwlet
 */
@WebServlet("/Kat")
public class KategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private KategorieDAO kategorieDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KategorieServlet() {
        super();
        kategorieDAO = new KategorieDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("action2");
		String action2 = request.getServletPath();
		System.out.println(acao);
		response.getWriter().append(action2);
		try {
			switch (acao) 
			{
			case "newKat":
			showNewForm(request, response); break;
			case "insertKat":
			insertKategorie(request, response); break;
			case "deleteKat":
			deleteKategorie(request, response); break;
			case "editKat":
			showEditFormKategorie(request, response); break;
			case "updateKat":
			updateKateogrie(request, response); break;
			case "listKat":
			listKategorie(request, response); break;
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
	
	private void listKategorie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Kategorie> listWydawnictwa = kategorieDAO.selectAllKategorie();
		request.setAttribute("listKategorie", listWydawnictwa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Z_Kategorie.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertKategorie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
		{
			
			String nazwa = request.getParameter("nazwa");
			Kategorie vKategorie = new Kategorie(nazwa);
			
			kategorieDAO.insertKategorie(vKategorie);
			response.sendRedirect("Kat?action2=listKat");
			
		}
	
	
	private void updateKateogrie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String nazwa = request.getParameter("nazwa");				
		Kategorie vKategorie = new Kategorie(id,nazwa);
		
			kategorieDAO.updateKategorie(vKategorie);
			response.sendRedirect("Kat?action2=listKat");
		
	}
	
	
	
	private void deleteKategorie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		kategorieDAO.deleteKategoria(id);
		response.sendRedirect("Kat?action2=listKat");
	}
	
	private void showEditFormKategorie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Kategorie kategorie = kategorieDAO.selectKategorie(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Kategorie_Form.jsp");
		request.setAttribute("kategorie", kategorie);
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Kategorie_Form.jsp");
		dispatcher.forward(request, response);
	}

}
