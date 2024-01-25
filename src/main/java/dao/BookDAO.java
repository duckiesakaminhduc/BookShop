package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.security.KeyStoreUtil;

import model.BooksAdd;

public interface BookDAO {
	default boolean addBook(BooksAdd book) {
		return false;
	}

	default List<BooksAdd> getAllBook() {
		return null;
	}

	default BooksAdd getBookById(int id) {
		return null;
	}

	default Boolean updateBook(BooksAdd booksAdd) {
		return false;
	}

	default Boolean deleteBook(int bookId) {
		return false;
	}

	default List<BooksAdd> getNewBook() {
		return null;
	}

	default List<BooksAdd> getOldBook() {
		return null;
	}

	default List<BooksAdd> getRecentBook() {
		return null;
	}

	default List<BooksAdd> searchBook(String ch) {
		return null;
	}

	default List<BooksAdd> getTop4(int start, int limit) {
		return null;
	}

	default List<BooksAdd> getOnlyTop4() {
		return null;
	}

	default int getBookCount(List<BooksAdd> listBook) {
		return listBook.size();
	}

	default List<BooksAdd> sortByPrice() {
		return null;
	}

}
