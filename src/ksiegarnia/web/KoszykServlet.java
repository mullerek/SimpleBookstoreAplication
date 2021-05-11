package ksiegarnia.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ksiegarnia.dao.KsiazkiDAO;
import ksiegarnia.model.Ksiazki;

/**
 * Servlet implementation class KoszykServlet
 */
@WebServlet("/cart")
public class KoszykServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public KoszykServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");

		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			} else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
	}

	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL="/koszyk.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextURL);
		rd.forward(request, response);
	}

	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        ArrayList<Ksiazki> tk = (ArrayList<Ksiazki>) session.getAttribute("cart");

        int index = isExisting(Integer.parseInt(request.getParameter("id")),tk);
        double total =  (double) session.getAttribute("total");
        total -=tk.get(index).getIlosc_w_koszyku()*tk.get(index).getCena();
        total = (Math.ceil(total*100))/100;

        tk.remove(index);
        System.out.println(total);
        session.setAttribute("cart", tk);
        session.setAttribute("total", total);
        response.sendRedirect("cart");
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KsiazkiDAO dao=new KsiazkiDAO();
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("ilosc"));

		if (session.getAttribute("cart") == null) {
			ArrayList<Ksiazki>cart = new ArrayList<Ksiazki>();	
			cart.add(dao.selectKsiazki(Integer.parseInt(request.getParameter("id"))));
			cart.get(0).setIlosc_w_koszyku(Integer.parseInt(request.getParameter("ilosc")));
			double total=0;
			total+=Integer.parseInt(request.getParameter("ilosc"))*cart.get(0).getCena();
			session.setAttribute("cart", cart);
			session.setAttribute("total", total);
		} else {
			ArrayList<Ksiazki>cart = (ArrayList<Ksiazki>) session.getAttribute("cart");
			double total = (double) session.getAttribute("total");
			int index = isExisting(Integer.parseInt(request.getParameter("id")), cart);

			if (index == -1) {
				cart.add(dao.selectKsiazki(Integer.parseInt(request.getParameter("id"))));
				int quantity = Integer.parseInt(request.getParameter("ilosc"));
				cart.get(cart.size()-1).setIlosc_w_koszyku(quantity);
				total+=Integer.parseInt(request.getParameter("ilosc"))*cart.get(cart.size()-1).getCena();
			} else {
				int quantity = cart.get(index).getIlosc_w_koszyku() + Integer.parseInt(request.getParameter("ilosc"));
				cart.get(index).setIlosc_w_koszyku(quantity);
				total+=Integer.parseInt(request.getParameter("ilosc"))*cart.get(index).getCena();
			}
			session.setAttribute("cart", cart);
			session.setAttribute("total", total);
		}
		double total = (Math.ceil((double) session.getAttribute("total")*100))/100;
		session.setAttribute("total", total);
		System.out.println(session.getAttribute("total"));
		response.sendRedirect("cart");
	}
	
	private int isExisting(int id, ArrayList<Ksiazki> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getId_ksiazki()==id) {
				return i;
			}
		}
		return -1;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
