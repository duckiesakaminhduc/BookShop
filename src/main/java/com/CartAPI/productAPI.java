package com.CartAPI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import connectDB.DBConnect;
import dao.CartDAOImpl;

@WebServlet(urlPatterns = "/remove_cart")
public class productAPI extends HttpServlet {
	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter p = resp.getWriter();

		String username = req.getParameter("username");
		int bookId = Integer.parseInt(req.getParameter("bookid"));

		System.out.println(username + " " + bookId);
		CartDAOImpl c = new CartDAOImpl(new DBConnect().getConn());
		boolean re = c.removeCart(username, bookId);
		System.out.println(re);
		HttpSession session = req.getSession();

		if (re) {
			session.setAttribute("removev", "Remove successfully..");
		}

//		boolean re = true;
//		String userName = "minh";
//		int bookId = 1;


		deleteBook d = new deleteBook();
		d.setStatus(re);
		d.setUsername(username);
		d.setBookId(bookId);

		String json = gson.toJson(d);
		p.print(json);
		p.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
