package assg7_CERVENKAZ19;

/**
 * @author zachary cervenka
 * calculator class that allows user to create a calculator object and give it a infix expression to convert and evaluate
 */

import java.util.*;

public class Calculator {
	private String infix;
	private String postfix = "";
	private boolean convertPostFix;
	
	/**
	 * one param constructor that sets the infix expression and calls convertPostfix() 
	 * @param exp
	 */
	public Calculator(String exp) {
		infix = exp;
		convertPostfix();
	}
	
	/**
	 * toString method that returns the infix expression
	 * @return infix
	 */
	public String toString() {
		return infix;
	}
	
	/**
	 * converts the infix expression to postfix and returns true
	 * if infix expression cannot be converted it returns false
	 * @return true/false
	 */
	private boolean convertPostfix() {
		Stack<Character> aStack = new Stack<Character>();

		for(int i = 0; i < infix.length(); i++) {
			if(infix.charAt(i) != '+'&& infix.charAt(i) != '-' && infix.charAt(i) != '*' && infix.charAt(i) != '/' && infix.charAt(i) != '(' && infix.charAt(i) != ')' && infix.charAt(i) != ' ') {
				postfix += infix.charAt(i);
			}
			else {
				switch(infix.charAt(i)) {
					case '(':
						aStack.push(infix.charAt(i));
						break;
					case ')':
						try {
							while(aStack.peek() != '(') {
								postfix = postfix + " " + aStack.pop();	
							}
							aStack.pop();
						}
						catch(EmptyStackException e) {
							convertPostFix = false;
							return false;
						}
						break;
					case '+':
						while(!aStack.isEmpty() && aStack.peek() != '(' && precedence((infix.charAt(i))) <= precedence(aStack.peek())) {
							postfix = postfix + " " + aStack.pop();
						}
						postfix = postfix + " ";
						aStack.push(infix.charAt(i));
						break;
					case '*':
						while(!aStack.isEmpty() && aStack.peek() != '(' && precedence((infix.charAt(i))) <= precedence(aStack.peek())) {
							postfix = postfix + " " + aStack.pop();
						}
						postfix = postfix + " ";
						aStack.push(infix.charAt(i));
						break;
					case '-':
						while(!aStack.isEmpty() && aStack.peek() != '(' && precedence((infix.charAt(i))) <= precedence(aStack.peek())) {
							postfix = postfix + " " + aStack.pop();
						}
						postfix = postfix + " ";
						aStack.push(infix.charAt(i));
						break;
					case '/':
						while(!aStack.isEmpty() && aStack.peek() != '(' && precedence((infix.charAt(i))) <= precedence(aStack.peek())) {
							postfix = postfix + " " + aStack.pop();
						}
						postfix = postfix + " ";
						aStack.push(infix.charAt(i));
						break;
				}
			}
		}
		while(!aStack.isEmpty()) {
			if(aStack.peek() == '(') {
				convertPostFix = false;
				return false;
			}
			postfix = postfix + " " + aStack.pop();
		}
		convertPostFix = true;
		return true;
	}
	
	/**
	 * getPostfix method that return postfix if it was successfully converted from infix
	 * @return postfix
	 */
	public String getPostfix() throws IllegalStateException {
		if (convertPostFix == false) {
			throw new IllegalStateException();
		}
		else {
			return postfix;
		}
	}
	
	/**
	 * Assumes postfix expression is correctly formated and evaluates the postfix expression
	 * @return result of the expression
	 */
	public int evaluate() throws IllegalStateException {
		if (convertPostFix == false) {
			throw new IllegalStateException();
		}
		else {
			Stack<Integer> bStack = new Stack<Integer>();

			StringTokenizer s = new StringTokenizer(postfix, " ");
			
									
			while(s.hasMoreTokens()) {
				String ch = s.nextToken();

				if(!ch.equals("+") && !ch.equals("*") && !ch.equals("/") && !ch.equals("-")) {
					try {
						bStack.push(Integer.valueOf(ch));
					}
					catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					switch(ch) {
					case "+":
						bStack.push(bStack.pop() + bStack.pop());
						break;
					case "-":
						bStack.push(-bStack.pop() + bStack.pop());
						break;
					case "*":
						bStack.push(bStack.pop() * bStack.pop());
						break;
					case "/":
						Integer a = bStack.pop();
						bStack.push(bStack.pop() / a);
						break;
					}
				}
			}
			return bStack.pop();
		}
	}
	
	/**
	 * Determines the precedence levels of operators
	 * @param ch
	 * @return precedence level of operators
	 */
	private int precedence(char ch) {
		switch(ch) {
		case '*':
			return 2;
		case '+':
			return 1;
		case '-':
			return 1;
		case '/':
			return 2;
		}
		return 0;
	}

}
