package controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.DBConnect;
import dao.CartDAOImpl;
import dao.OrderDAOImpl;
import model.Cart;
import model.Order;

@WebServlet(urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String payment = req.getParameter("payment");
		String phone = req.getParameter("phone");
		String date = req.getParameter("date");

//		System.out.println(name+" " + email + " " + address + " " + payment +" " + phone + " " + date);

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		CartDAOImpl cartDAOImpl = new CartDAOImpl(new DBConnect().getConn());
		List<Cart> cartList = cartDAOImpl.getOrderByUsername(username);

		OrderDAOImpl orderDaoImpl = new OrderDAOImpl(new DBConnect().getConn());
		List<Order> orderList = orderDaoImpl.saveOrder(name, email, address, phone, cartList, phone, payment, date);
		System.out.println(orderList);

//		===================Email=======================================		
		final String user_mail = "voducminh39@gmail.com";
		final String password_mail = "pqwp prxw nrzd sgof";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		javax.mail.Session s = javax.mail.Session.getInstance(props, new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(user_mail, password_mail);
			}
		});

		String toemail = req.getParameter("email");
		String subject = "List book you bought:";
		String content = "List of books you have just purchased: " + req.getParameter("listProduct");

		try {
			Message msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(username));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
			msg.setSubject(subject);
			msg.setText(content);
			Transport.send(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//		===============================================================
		session.setAttribute("order_suc", "Order successfully..");
		resp.sendRedirect("cart.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
