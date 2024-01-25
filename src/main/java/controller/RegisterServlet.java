package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.UserDAOImpl;
import model.User;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");

		System.out.println(username + " " + email + " " + phone + " " + password);
		User u = new User(username, email, phone, password);

		boolean re = new UserDAOImpl(new DBConnect().getConn()).userRegister(u);
		System.out.println(re);

		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);

		
		HttpSession session = req.getSession();

		if (re) {
			session.setAttribute("yess", "User register successfully..");
			resp.sendRedirect("admin/all_book.jsp");
		}

	}

}
