package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import connectDB.DBConnect;
import model.BooksAdd;
import model.Cart;
import model.Order;

public class OrderDAOImpl implements OrderDAO {

	Connection conn;

	public OrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Order> saveOrder(String username, String email, String address, String phone, List<Cart> carts,
			String price, String payment, String date) {
		List<Order> orderList = new ArrayList<>();

		try {
			String sql = "insert into [order](username,email,address,phone,bookname,author,price,payment,date)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for (Cart cartItem : carts) {
				ps.setString(1, username);
				ps.setString(2, email);
				ps.setString(3, address);
				ps.setString(4, phone);
				ps.setString(5, cartItem.getBookName());
				ps.setString(6, cartItem.getAuthor());
				ps.setString(7, cartItem.getPrice());
				ps.setString(8, payment);
				ps.setString(9, date);
				ps.executeUpdate();
				Order o = new Order(username, email, address, phone, date, sql, price, payment, date);
				orderList.add(o);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return orderList;
	}

//	================================ get order by username=======================
	@Override
	public List<Order> getOrderByUserName(String username) {
		List<Order> orderList = new ArrayList<>();
		try {
			String sql = "select * from [order] where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setUsername(rs.getString(2));
				o.setEmail(rs.getString(3));
				o.setAddress(rs.getString(4));
				o.setPhone(rs.getString(5));
				o.setBookname(rs.getString(6));
				o.setAuthor(rs.getString(7));
				o.setPrice(rs.getString(8));
				o.setPayment(rs.getString(9));
				o.setDate(rs.getString(10));
				orderList.add(o);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orderList;
	}

//	======================= get all order ===========================
	@Override
	public List<Order> getAllOrder() {
		List<Order> orderList = new ArrayList<>();
		try {
			String sql = "select * from [order]";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setUsername(rs.getString(2));
				o.setEmail(rs.getString(3));
				o.setAddress(rs.getString(4));
				o.setPhone(rs.getString(5));
				o.setBookname(rs.getString(6));
				o.setAuthor(rs.getString(7));
				o.setPrice(rs.getString(8));
				o.setPayment(rs.getString(9));
				o.setDate(rs.getString(10));
				orderList.add(o);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orderList;
	}

}
