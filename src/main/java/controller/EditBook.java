package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;

import connectDB.DBConnect;
import dao.BookDAOImpl;
import model.BooksAdd;

@WebServlet(urlPatterns = "/edit_book")
@MultipartConfig
public class EditBook extends HttpServlet {
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
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		BooksAdd b = new BooksAdd(bookId, bookName, authorName, price, bookCategory, bookStatus, fileImage, "admin");
//		System.out.println(b);

//		BooksAdd b = new BooksAdd(bookId, bookName, authorName, price, bookCategory, bookStatus, fileImage,"");

		BookDAOImpl bookDAOImpl = new BookDAOImpl(new DBConnect().getConn());
		boolean re = bookDAOImpl.updateBook(b);
		HttpSession session = req.getSession();
		
		if(re) {
			session.setAttribute("yess", "Update successfully..");
			resp.sendRedirect("admin/all_book.jsp");
		}else {
			session.setAttribute("noo", "Wrong!!!");
			resp.sendRedirect("admin/all_book.jsp");
		} 
		
	}
}
