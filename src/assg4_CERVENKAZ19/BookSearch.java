package assg4_CERVENKAZ19;
/**
 * @author zachary cervenka
 * BookSearch program that reads the catalog txts and stores books into 
 * an array and allows them to search for a book using the bookId
 */

import java.util.*;
import java.io.*;

public class BookSearch extends Book {
	
	/**
	 * default constructor that calls super
	 */
	public BookSearch() {
		super("f","f","f","f",'f');
	}

	public static void main(String [] args) {
		String catalog = "assg4_catalog.txt";
		String id = null, title = null, isbn = null, author = null;
		String category = null;
		Scanner inputStream = null;
		int numOfBooks = 0;
		Book[] books;
		String userInput = null;
		
		//Allocates memory for array, array can only hold 10 books
		books = new Book [10];
		
		try {
			inputStream = new Scanner(new File(catalog));
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: file not found.");
			System.exit(1);
		}
		
		//while loop that reads the catalog txt and stores the books into array
		while(inputStream.hasNextLine()) {
			id = inputStream.next();
			title = inputStream.next();
			isbn = inputStream.next();
			author = inputStream.next();
			category = inputStream.next();
			
			try {
				for(int i = 0; i < numOfBooks; i++) {
						if (books[i].getBookId().equals(id)) {
							throw new BookIdAlreadyExistException();
						}
					}
				books[numOfBooks] = new Book(id,title,isbn,author, category.charAt(0));
				numOfBooks++;
				}
			catch(BookIdAlreadyExistException e) {
				System.out.println("Book ID " + id + " already exists.\n");
			}	
		}
		inputStream.close();
		
		//for loop that prints out the books in the array
		for(int i = 0; i < numOfBooks; i++) {
			System.out.println(books[i].toString());
		}
		System.out.println("\nNumber of Books: " + numOfBooks);
		
		//Asks user to input a bookId to search for a book 
		System.out.print("\nEnter bookId to search for book or \"STOP\" to end: ");
		Scanner kyb = new Scanner(System.in);
		userInput = kyb.next();
		
		//while loop that allows the user to keep searching for books until they input "STOP"
		while(!userInput.equals("STOP")) {
			try {
				//bookSearch throws BookNotFoundexception so it is done in a try  statement
				System.out.println(books[bookSearch(books, numOfBooks, userInput)].toString());
				System.out.print("\nEnter bookId to search for book or \"STOP\" to end: ");
				userInput = kyb.next();
			}
			catch(BookNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.print("\nEnter bookId to search for book or \"STOP\" to end: ");
				userInput = kyb.next();
			}
		}
		System.out.println("\nProgram Ended");
	}
}
