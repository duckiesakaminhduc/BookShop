package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.BooksAdd;
import model.Cart;

public class CartDAOImpl implements CartDAO {

	Connection conn;

	public CartDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addCart(Cart cart) {
		boolean f = false;
		try {
			String sql = "Insert into cart(bookId,userName,bookName,author,price) " + "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cart.getBookId());
			ps.setString(2, cart.getUserName());
			ps.setString(3, cart.getBookName());
			ps.setString(4, cart.getAuthor());
			ps.setString(5, cart.getPrice());
			int re = ps.executeUpdate();

			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return f;
	}

//	================================get oder by username=================================
	@Override
	public List<Cart> getOrderByUsername(String username) {
		List<Cart> cartList = new ArrayList<>();
		try {
			String sql = "Select * from cart where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setBookId(rs.getInt(2));
				c.setUserName(rs.getString(3));
				c.setBookName(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getString(6));
				cartList.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cartList;
	}

//	============================REMOVE CART=====================================
	@Override
	public boolean removeCart(String userName, int bookId) {
		boolean f = false;
		try {

			String sql = "Delete from cart where userName = ? and bookId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, bookId);
			int re = ps.executeUpdate();
			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return f;
	}

//=======================get cart by username ====================
	@Override
	public List<Cart> getCartByUsername(String username) {
		List<Cart> listCart = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from [cart] where userName = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setBookId(rs.getInt(2));
				c.setUserName(rs.getString(3));
				c.setBookName(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getString(6));
				listCart.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
				}
			}
		}
		return listCart;
	}

}
