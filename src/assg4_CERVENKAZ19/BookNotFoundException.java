package assg4_CERVENKAZ19;
/**
 * @author zachary cervenka
 * Exception class for the BookNotFoundException
 */
public class BookNotFoundException extends Exception {
	
	/**
	 *defualt constructor that calls super and prints out the message
	 */
	public BookNotFoundException() {
		super("Book not found.");
	}
	
	/**
	 * @param mssg
	 *one parameter constructor that calls super and prints the given mssg
	 */
	public BookNotFoundException(String mssg) {
		super(mssg);
	}

}
