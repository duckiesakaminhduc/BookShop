package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import connectDB.DBConnect;
import model.BooksAdd;
import model.User;

public class BookDAOImpl implements BookDAO {

	Connection conn;

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addBook(BooksAdd book) {
		boolean f = false;
		PreparedStatement ps = null;
		try {
			String sql = "insert into [book](bookName,author,price,bookCategory,status,photo)" + "Values (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPrice());
			ps.setString(4, book.getBookCategory());
			ps.setString(5, book.getStatus());
			ps.setString(6, book.getPhoto());
			int re = ps.executeUpdate();

			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

		return f;
	}

	// get all book
	@Override
	public List<BooksAdd> getAllBook() {
		List<BooksAdd> bookList = new ArrayList<>();
		Statement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from [book]";
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				BooksAdd bookItem = new BooksAdd(rs.getInt("bookId"), rs.getString("bookName"), rs.getString("author"),
						rs.getString("price"), rs.getString("bookCategory"), rs.getString("status"),
						rs.getString("photo"), "admin");
				bookList.add(bookItem);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return bookList;
	}

	// ---------------------------------------------------------
	@Override
	public BooksAdd getBookById(int id) {
		BooksAdd booksAdd = new BooksAdd();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from book where bookId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				booksAdd.setBookId(rs.getInt("bookId"));
				booksAdd.setBookName(rs.getString("bookName"));
				booksAdd.setAuthor(rs.getString("author"));
				booksAdd.setPrice(rs.getString("price"));
				booksAdd.setBookCategory(rs.getString("bookCategory"));
				booksAdd.setStatus(rs.getString("status"));
				booksAdd.setPhoto(rs.getString("photo"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

		return booksAdd;
	}

//================================= update book ======================================
	@Override
	public Boolean updateBook(BooksAdd booksAdd) {
		boolean f = false;
		PreparedStatement ps = null;
		try {
			String sql = "update book "
					+ "set bookName=?, author=?, price=?,bookCategory=?,status=?,photo=? where bookId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, booksAdd.getBookName());
			ps.setString(2, booksAdd.getAuthor());
			ps.setString(3, booksAdd.getPrice());
			ps.setString(4, booksAdd.getBookCategory());
			ps.setString(5, booksAdd.getStatus());
			ps.setString(6, booksAdd.getPhoto());
			ps.setInt(7, booksAdd.getBookId());
			int re = ps.executeUpdate();
			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

		return f;
	}

//------------------------------------------------------------------
//	delete book
	@Override
	public Boolean deleteBook(int bookId) {
		boolean f = false;
		PreparedStatement ps = null;
		try {
			String sql = "Delete from book where bookId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			int re = ps.executeUpdate();
			if (re == 1) {
				f = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return f;
	}

//	=========================================================================
	@Override
	public List<BooksAdd> getNewBook() {

		List<BooksAdd> newBookList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from [book] where status = 'New book'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail("admin");
				newBookList.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return newBookList;
	}

	@Override
	public List<BooksAdd> getOldBook() {
		List<BooksAdd> oldBookList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from [book] where status = 'Old book'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail("admin");
				oldBookList.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return oldBookList;
	}

//==================================== search book ===================================
	@Override
	public List<BooksAdd> searchBook(String ch) {
		List<BooksAdd> listBookSearch = new ArrayList<>();
		try {
			String sql = "select * from book where bookName like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, '%' + ch + '%');
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setPhoto(rs.getString(7));
				listBookSearch.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listBookSearch;
	}

//============================ get recent book ===================================
	@Override
	public List<BooksAdd> getRecentBook() {
		List<BooksAdd> recentBookList = new ArrayList<>();
		try {
			String sql = "select * from [book] order by [status]";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail("admin");
				recentBookList.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recentBookList;
	}

//=================================get top 4 ==========================
	@Override
	public List<BooksAdd> getTop4(int start, int limit) {
		List<BooksAdd> bookList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM book order by bookId " + " OFFSET (?) ROWS FETCH " + "NEXT (?) ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail("admin");
				bookList.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bookList;
	}
	// ====================get book count ==============

	@Override
	public int getBookCount(List<BooksAdd> listBook) {
		List<BooksAdd> bookCount = new BookDAOImpl(new DBConnect().getConn()).getAllBook();
		return bookCount.size();
	}

//	=======================get only top 4======================================
	@Override
	public List<BooksAdd> getOnlyTop4() {
		List<BooksAdd> bookList = new ArrayList<>();
		try {
			String sql = "SELECT top 4 * FROM book order by bookId";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail("admin");
				bookList.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return bookList;
	}

//============================ sort by price ==================================
	@Override
	public List<BooksAdd> sortByPrice() {
		List<BooksAdd> bookList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM book order by price ASC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BooksAdd b = new BooksAdd();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setEmail("admin");
				bookList.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return bookList;
	}

}
