package Activity9;
import java.util.*;

public class StackPractice {
	
	public static String strRevStack(String s) {
		Stack<String> aStack = new Stack<String>();
		String [] split = s.split("");
		String backwards = null;
		String [] popped;
		popped = new String [s.length()];

		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			aStack.push(split[i]);
		}
		
		while(!aStack.empty()) {
			popped[count] = aStack.pop();
			count++;
		}
		StringBuilder sb = new StringBuilder();
		for(Object obj : popped) {
			sb.append(obj.toString()).append("");
		}
		backwards = sb.substring(0, sb.length());
		
		return backwards;
	}
	
	public static String strRevRecursive(String s) {
		if (s.isEmpty()) {
			return s;
		}
		else {
			return strRevRecursive(s.substring(1)) + s.charAt(0);
		}
	}
	
	public static String strRevIterative(String s) {
		char [] sArray;
		int j = 0;
		String backwards = null;
		
		sArray = new char [s.length()];
		
		for (int i = s.length() -1; i >= 0; i--) {
			sArray[j] = s.charAt(i);
			j++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(Object obj : sArray) {
			sb.append(obj.toString()).append("");
		}
		backwards = sb.substring(0, sb.length());
		
		return backwards;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		Scanner kyb = new Scanner(System.in);
		String s = kyb.nextLine();
		System.out.println("\nTesting strRevStack: " + strRevStack(s));
		System.out.println("Testing strRevIterative: " + strRevIterative(s));
		System.out.println("Testing strRevRecursive: " + strRevRecursive(s));
	}
}
