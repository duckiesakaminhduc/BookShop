package model;

/**
 * @author voduc
 *
 */
public class Cart {
	private int bookId;
	private String userName, bookName, author, price;

	public Cart(int bookId, String userName, String bookName, String author, String price) {
		super();
		this.bookId = bookId;
		this.userName = userName;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public Cart() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	@Override
	public String toString() {
		return "Cart [cartId=" + ", bookId=" + bookId + ", userId=" + userName + ", bookName=" + bookName + ", author="
				+ author + ", price=" + price + ", total_price=" + "]";
	}

}
