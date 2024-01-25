package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.BookDAOImpl;
import dao.CartDAOImpl;
import dao.UserDAOImpl;
import model.BooksAdd;
import model.Cart;
import model.User;

@WebServlet(urlPatterns = "/add_cart")
@MultipartConfig
public class CartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//		boolean re = new CartDAOImpl(new DBConnect().getConn()).addCart(c);
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		System.out.println(bookId);

		String userName = req.getParameter("username");
		UserDAOImpl userDAOImpl = new UserDAOImpl(new DBConnect().getConn());
		List<User> userList = userDAOImpl.getUserByUserName(userName);
		User u = userList.get(0);
		BookDAOImpl bookDAOImpl = new BookDAOImpl(new DBConnect().getConn());
		CartDAOImpl cartDAOImpl = new CartDAOImpl(new DBConnect().getConn());
		BooksAdd b = bookDAOImpl.getBookById(bookId);
		Cart cart = new Cart(bookId, userName, b.getBookName(), b.getAuthor(), b.getPrice());
		boolean re = cartDAOImpl.addCart(cart);

		HttpSession session = req.getSession();
		if (re == true) {
			session.setAttribute("cartv", "Cart susccessfully..");
			resp.sendRedirect("index.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
