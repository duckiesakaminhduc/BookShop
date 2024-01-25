package dao;

import java.sql.Connection;
import java.util.List;

import model.User;

public interface UserDAO {
	default boolean userRegister(User user) {
		return false;
	}

	default boolean userLogin(String username, String password) {
		return false;
	}

	default List<User> getUserByUserName(String username) {
		return null;
	}

	default boolean editProfile(User user) {
		return false;
	}
}
