package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.CartDAOImpl;
import model.Cart;

@WebServlet(urlPatterns = "/remove_cart1")
public class Cart_RemoveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//		HttpSession session = req.getSession();
//		String username = (String) session.getAttribute("username");
		String userName = req.getParameter("userName");
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		System.out.println(userName + " " + bookId);
		CartDAOImpl c = new CartDAOImpl(new DBConnect().getConn());
		boolean re = c.removeCart(userName,bookId);
		System.out.println(re);
		resp.sendRedirect("cart.jsp");
		
		HttpSession session = req.getSession();

		if (re) {
			session.setAttribute("removev", "Remove successfully..");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
