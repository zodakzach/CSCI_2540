package assg4_CERVENKAZ19;
/**
 * @author zachary cervenka
 * Exception class for the BookIdAlreadyExistException
 */

public class BookIdAlreadyExistException extends Exception {
	
	/**
	 * defualt constructor that calls super and prints out the message
	 */
	public BookIdAlreadyExistException() {
		super("Book Id already exists.");
	}
	
	/**
	 * @param mssg
	 * one parameter constructor that calls super and prints the given mssg
	 */
	public BookIdAlreadyExistException(String mssg) {
		super(mssg);
	}

}
