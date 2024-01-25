package model;

public class Order {
	private String username, email, address, phone, bookname, author, price, payment, date;

	public Order(String username, String email, String address, String phone, String bookname, String author,
			String price, String payment, String date) {
		super();
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.payment = payment;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [username=" + username + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", bookname=" + bookname + ", author=" + author + ", price=" + price + ", payment=" + payment
				+ ", date=" + date + "]";
	}

	public Order() {
	}

}
