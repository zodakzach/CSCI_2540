package Activity5;

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		super("Can't input negative number");
	}
	
	public NegativeNumberException(String message) {
		super(message);
	}

}
