package assg7_CERVENKAZ19;

/**
 * @author zachary cervenka
 * CalculatorDemo class that allows user to enter and infix expression and converts it to postfix and evaluates it
 */

import java.util.*;

public class CalculatorDemo {
	
	public static void main(String [] args) {
		//Asks user for infix expression
		System.out.print("Enter infix expression or enter Stop to end: ");
		Scanner kyb = new Scanner(System.in);
		
		String exp;
		exp = kyb.nextLine();

		//keeps program running until user enters Stop
		while(!exp.equals("Stop")) {
		//creates calculator object and calls convertPostfix() to create the postfix
		Calculator calc = new Calculator(exp);
		
		//tries to call getPostfix and evaluate
		try {
		System.out.println(calc.getPostfix());
		System.out.println(calc.evaluate());
		System.out.println();
		System.out.print("Enter infix expression or enter Stop to end: ");
		exp = kyb.nextLine();
		}
		//if the postfix was not  converted then getPostfix will throw an exception and it will be caught here 
		catch (IllegalStateException e) {
			System.out.println("Invalid infix expression");
			System.out.print("Enter infix expression or enter Stop to end: ");
			exp = kyb.nextLine();
		}
		}
		System.out.println("End of program");
	}
}
	
