package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import connectDB.DBConnect;
import dao.UserDAOImpl;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDAOImpl daoImpl = new UserDAOImpl(new DBConnect().getConn());

		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + " " + password);

		HttpSession session = req.getSession();

		if (username.equals("admin") && password.equals("admin123")) {
			resp.sendRedirect("admin/home.jsp");
		} else {
//			resp.sendRedirect("login.jsp");
			if (daoImpl.userLogin(username, password)) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				resp.sendRedirect("index.jsp");
			} else {
				resp.sendRedirect("login.jsp");
				session.setAttribute("login_fail", "Incorrect username or password !!!");
			}
		}

//		if (daoImpl.userLogin(username, password)) {
//			resp.sendRedirect("index.jsp");
//		} else {
//			resp.sendRedirect("login.jsp");
//		}

	}
}
