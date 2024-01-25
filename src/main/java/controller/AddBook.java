package controller;

import java.awt.print.Book;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import connectDB.DBConnect;
import dao.BookDAOImpl;
import model.BooksAdd;

@WebServlet(urlPatterns = "/add_book")
@MultipartConfig
public class AddBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String bookName = req.getParameter("bookName");
		String authorName = req.getParameter("authorName");
		String price = req.getParameter("price");
		String bookCategory = req.getParameter("bookCategory");
		String bookStatus = req.getParameter("bookStatus");
		 
		Part filePart = req.getPart("bfile");
		String fileImage = filePart.getSubmittedFileName();

		BooksAdd b = new BooksAdd();
		b.setBookName(bookName);
		b.setAuthor(authorName);
		b.setPrice(price);
		b.setBookCategory(bookCategory);
		b.setStatus(bookStatus);
		b.setPhoto(fileImage);

		boolean re = new BookDAOImpl(new DBConnect().getConn()).addBook(b);
		HttpSession session = req.getSession();

		if (re) {
			session.setAttribute("yess", "Add new book successfully..");
			resp.sendRedirect("admin/all_book.jsp");
		} else {
			session.setAttribute("noo", "Wrong!!!");
			resp.sendRedirect("admin/all_book.jsp");
		}

	}
}
