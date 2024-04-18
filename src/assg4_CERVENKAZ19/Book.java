package assg4_CERVENKAZ19;
/**
 *@author Zachary Cervenka
 * Book class that allows you to create a book with id,title,isbn,author,category
 */

public class Book {
	private String bookId, title, isbn, author;
	private char category;
	
	/**
	 * @param bookId, title, isbn, author, category 
	 * 5 parameter constructor that creates a book with id, title, isbn, author, category
	 */
	public Book(String bookId, String title, String isbn, String author, char category) {
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.category = category;
	}
	
	/**
	 * @return bookId
	 * get method that returns bookid
	 */
	public String getBookId() {
		return bookId;
	}
	
	/**
	 * @return title
	 * get method that returns title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return isbn
	 * get method that returns isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * @return author
	 * get method that returns author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @return category
	 * get method that returns category
	 */
	public char getCategory() {
		return category;
	}
	
	/**
	 * @return "bookId, title, isbn, author, category"
	 * toString method that returns all the info as a string
	 */
	public String toString() {
		if (category == 'F') {
			return bookId + ", " + title + ", " + isbn + ", " + author + ", " + "Fiction";
		}
		else {
			return bookId + ", " + title + ", " + isbn + ", " + author + ", " + "Non-Fiction";
		}
	}
	
	/**
	 * @param array of books, numOfBooks, bookId
	 * @return index of book found 
	 * @throws BookNotFoundException
	 * bookSearch method that goes through the array and compares the ids 
	 */
	public static int bookSearch(Book [] books, int numOfBooks, String bookId) throws BookNotFoundException {
		for(int i = 0; i < numOfBooks; i++) {
			if (books[i].bookId.equals(bookId)) {
				return i;
			}
		}
		throw new BookNotFoundException();
	}

}
