package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.DBConnect;
import model.User;

public class UserDAOImpl implements UserDAO {

	Connection conn;

	// constructor dung de thiel lap ket noi, truyenn vao 1 conn <=>
	// DBConnect.getConn();
	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegister(User user) {
		boolean f = false;
		try {
			String sql = "insert into [user](username,email,password,phone) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			int re = ps.executeUpdate();
			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return f;
	}

	@Override
	public boolean userLogin(String username, String password) {
		boolean f = false;
		try {
			List<User> userList = new ArrayList<>();
			String sql = "select * from [user]";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				userList.add(new User(rs.getString("username"), rs.getString("email"), rs.getString("password"),
						rs.getString("phone")));
			}

			for (User u : userList) {
				if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
					f = true;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return f;
	}

	@Override
	public List<User> getUserByUserName(String username) {
		List<User> userList = new ArrayList<>();
		try {
			String sql = "select * from [user]" + "where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString("username"), rs.getString("email"), rs.getString("password"),
						rs.getString("phone"));
				userList.add(u);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userList;
	}

//=============================EDIT PROFILE========================================
	@Override
	public boolean editProfile(User user) {
		boolean f = false;
		try {
			String sql = "update [user]" + "set email=?, password =?, phone=? where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUserName());
			int re = ps.executeUpdate();
			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return f;
	}
}
