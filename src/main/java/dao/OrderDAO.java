package dao;

import java.util.List;

import model.Cart;
import model.Order;

public interface OrderDAO {
	default List<Order> saveOrder(String username, String email, String address, String phone, List<Cart> carts,
			String price, String payment, String date) {
		return null;
	}

	default List<Order> getOrderByUserName(String username) {
		return null;
	}

	default List<Order> getAllOrder() {
		return null;
	}
}
