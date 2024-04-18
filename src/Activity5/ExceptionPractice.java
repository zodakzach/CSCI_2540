package Activity5;
import java.util.Scanner;

public class ExceptionPractice {
	
	public static void main(String[] args) {
		System.out.print("Enter an integer: ");
		Scanner kyb = new Scanner(System.in);
		int input = kyb.nextInt();
		System.out.println("sqrRoot = " + sqrRoot(input));
		
	}
	
	public static double sqrRoot(int input) {
		try {
			if(input < 0) {
				throw new NegativeNumberException();
			}
			return Math.sqrt(input);
			
		}
		catch(NegativeNumberException e) {
			System.out.println(e.getMessage());
			System.exit(1);
			return 1;
		}
	}

}
