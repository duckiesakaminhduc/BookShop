package dao;

import java.util.List;

import model.BooksAdd;
import model.Cart;

public interface CartDAO {
	default boolean addCart(Cart cart) {
		return false;
	}

	default List<Cart> getOrderByUsername(String username) {
		return null;
	}
	
	default boolean removeCart(String userName, int id) {
		return false;
	}
	
	default List<Cart> getCartByUsername(String username) {
		return null;
	}
	
	
}

