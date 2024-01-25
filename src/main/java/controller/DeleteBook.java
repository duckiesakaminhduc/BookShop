package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.BookDAOImpl;

@WebServlet(urlPatterns = "/delete_book")
public class DeleteBook extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		System.out.println("1");

		int bookId = Integer.parseInt(req.getParameter("bookId"));
		boolean re = new BookDAOImpl(new DBConnect().getConn()).deleteBook(bookId);
		HttpSession session = req.getSession();

		if (re) {
			session.setAttribute("delete", "Delete successfully..");
			resp.sendRedirect("admin/all_book.jsp");
		} else {
			session.setAttribute("noo", "Wrong!!!");
			resp.sendRedirect("admin/all_book.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
