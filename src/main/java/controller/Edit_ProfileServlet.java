package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

@WebServlet(urlPatterns = "/edit_profile")
public class Edit_ProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		User u = new User(username, email, password, phone);
		UserDAOImpl userDAOImpl = new UserDAOImpl(new DBConnect().getConn());
		boolean re = userDAOImpl.editProfile(u);
		
		if(re) {
			session.setAttribute("edit_v", "Update Profile Successfully..");
			resp.sendRedirect("setting.jsp");
		}
		System.out.println(re);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
