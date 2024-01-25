package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.BookDAOImpl;
import model.BooksAdd;
@WebServlet(urlPatterns = "/loadonly4")
public class LoadOnlyTop4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		
		

		List<BooksAdd> listBook4 = new BookDAOImpl(new DBConnect().getConn()).getOnlyTop4();

		for (BooksAdd bookItem : listBook4) {
			out.println("<div id='bookItem' class=\"col-md-3 text-center mb-1 \">\r\n"
					+ "					<div class=\"card\">\r\n"
					+ "						<div class=\"card-body\">\r\n"
					+ "							<div class=\"text-center\">\r\n"
					+ "								<img src=\"image/" + bookItem.getPhoto()
					+ "\" style=\"width: 150px;\"\r\n"
					+ "									class=\"img-thumbnail\" alt=\"...\">\r\n"
					+ "							</div>\r\n" + "							<h5 class=\"card-title\">"
					+ bookItem.getBookName() + "</h5>\r\n"
					+ "							<p class=\"card-text\">Some quick example text to build on the\r\n"
					+ "								card title and make up the bulk of the card's content.</p>\r\n"
					+ "							<p>\r\n" + "								<span>Price :</span>"
					+ bookItem.getPrice() + "</p>\r\n" + "\r\n"
					+ "							<a href=\"view_book.jsp?bookId=" + bookItem.getBookId() + "\"\r\n"
					+ "								class=\"btn btn-danger\">View</a>\r\n"
					+ "							<!--  test add ajax button -->\r\n"
					+ "							<button class='add btn btn-success'>Add Cart</button>\r\n"
					+ "							<input type='hidden' class='bookId'\r\n"
					+ "								value=" + bookItem.getBookId() + "> <input type='hidden'\r\n"
					+ "								class='username' value=" + username + ">\r\n"
					+ "							<!--  test add ajax button -->\r\n" + "\r\n"
					+ "						</div>\r\n" + "					</div>\r\n" + "				</div>");
		}
		
		System.out.println("vao serlvet");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
