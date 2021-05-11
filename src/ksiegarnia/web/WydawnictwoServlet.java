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

import ksiegarnia.dao.WydawnictwaDAO;
import ksiegarnia.model.Wydawnictwa;

/**
 * Servlet implementation class WydawnictwoServlet
 */
@WebServlet("/Wyd")
public class WydawnictwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WydawnictwaDAO wydawnictwoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WydawnictwoServlet() {
        super();
        wydawnictwoDAO = new WydawnictwaDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("action");
		String action = request.getServletPath();
		System.out.println(acao);
		response.getWriter().append(action);
		try {
			switch (acao) 
			{
			case "newWyd":
			showNewForm(request, response); break;
			case "insertWyd":
			insertWydawnictwo(request, response); break;
			case "deleteWyd":
			deleteWydawnictwa(request, response); break;
			case "editWyd":
			showEditFormWydawnictwa(request, response); break;
			case "updateWyd":
			updateWydawnictwo(request, response); break;
			case "listWyd":
			listWydawnictwa(request, response); break;
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
	
	private void listWydawnictwa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		List<Wydawnictwa> listWydawnictwa = wydawnictwoDAO.selectAllWydawnictwa();
		request.setAttribute("listWydawnictwa", listWydawnictwa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Z_Wydawnictwa.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void insertWydawnictwo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
		{
			
			String nazwa = request.getParameter("nazwa");
			Wydawnictwa vWydawnictwo = new Wydawnictwa(nazwa);
			
			wydawnictwoDAO.insertWydawnictwo(vWydawnictwo);
			response.sendRedirect("Wyd?action=listWyd");
			
		}
	
	
	private void updateWydawnictwo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String nazwa = request.getParameter("nazwa");
		
		
		Wydawnictwa vWydawnictwo = new Wydawnictwa(id,nazwa);
		
			wydawnictwoDAO.updateWydawnictwo(vWydawnictwo);
			response.sendRedirect("Wyd?action=listWyd");
		
	}
	
	
	
	private void deleteWydawnictwa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		wydawnictwoDAO.deleteWydawnictwa(id);
		response.sendRedirect("Wyd?action=listWyd");
	}
	
	private void showEditFormWydawnictwa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Wydawnictwa wydawnictwa = wydawnictwoDAO.selectWydawnictwo(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Wydawnictwa_Form.jsp");
		request.setAttribute("wydawnictwa", wydawnictwa);
		dispatcher.forward(request, response);
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Wydawnictwa_Form.jsp");
		dispatcher.forward(request, response);
	}

}
