package ksiegarnia.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ksiegarnia.dao.KsiazkiDAO;
import ksiegarnia.model.Ksiazki;


/**
 * Servlet implementation class KsiazkiServlet
 */
@WebServlet("/Ksi")
public class KsiazkiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private KsiazkiDAO ksiazkiDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KsiazkiServlet() {
        super();
        
        ksiazkiDAO = new KsiazkiDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("action");
		String action = request.getServletPath();
		System.out.println(acao);
		response.getWriter().append(action);
		try {
			switch (acao) 
			{
			case "newKsi":
			showNewForm(request, response); break;
			case "insertKsi":
			insertKsiazka(request, response); break;
			case "deleteKsi":
			deleteKsiazka(request, response); break;
			case "editKsi":
			showEditFormKsiazka(request, response); break;
			case "updateKsi":
			updateUser(request, response); break;
			case "listKsi":
			listKsiazki(request, response); break;
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
	private void listKsiazki(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Ksiazki> listKsiazki = ksiazkiDAO.selectAllKsiazki();
		request.setAttribute("listKsiazki", listKsiazki);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Z_Ksiazki.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertKsiazka(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
			String tytul = request.getParameter("tytul");
			String autor = request.getParameter("autor");
			Double cena = Double.parseDouble(request.getParameter("cena"));
			int ilosc = Integer.parseInt(request.getParameter("ilosc"));
			int id_kat = Integer.parseInt(request.getParameter("id_kat"));
			int id_wyd = Integer.parseInt(request.getParameter("id_wyd"));
					
			Ksiazki vKsiazka = new Ksiazki(tytul, autor, cena, ilosc ,id_kat,id_wyd);
			
			ksiazkiDAO.insertKsiazki(vKsiazka);
			response.sendRedirect("Ksi?action=listKsi");
			
	}
	
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException 
	{
		int id = Integer.parseInt(request.getParameter("id_ksiazki"));
		String tytul = request.getParameter("tytul");
		String autor = request.getParameter("autor");
		Double cena = Double.parseDouble(request.getParameter("cena"));
		int ilosc = Integer.parseInt(request.getParameter("ilosc"));
		int id_kat = Integer.parseInt(request.getParameter("id_kat"));
		int id_wyd = Integer.parseInt(request.getParameter("id_wyd"));
		
		Ksiazki vKsiazka = new Ksiazki(id,tytul, autor, cena, ilosc ,id_kat,id_wyd);
		
		ksiazkiDAO.updateKsiazki(vKsiazka);
		response.sendRedirect("Ksi?action=listKsi");
		
	}
	
	
	private void deleteKsiazka(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		ksiazkiDAO.deleteKsiazki(id);
		response.sendRedirect("Ksi?action=listKsi");
	}
	
	private void showEditFormKsiazka(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Ksiazki ksiazka = ksiazkiDAO.selectKsiazki(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ksiazki_Form.jsp");
		request.setAttribute("ksiazki", ksiazka);
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ksiazki_Form.jsp");
		dispatcher.forward(request, response);
	}

}
