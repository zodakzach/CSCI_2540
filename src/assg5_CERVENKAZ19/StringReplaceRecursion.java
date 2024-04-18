package assg5_CERVENKAZ19;

/**
 * @author zachary cervenka
 * Recursive methods that go through strings recursively and replaces a specific character 
 * with a new given character
 */

import java.util.*;

public class StringReplaceRecursion {
	/**
	 * Recursive replace method that replaces the first occurrence of a character in a string
	 * @param str, oldChar, newChar
	 */
	public static String replace(String str, char oldChar, char newChar) {
		if(str.charAt(0) == oldChar) {
			return newChar + str.substring(1);
		}
		else {
			return str.charAt(0) + replace(str.substring(1), oldChar, newChar);
		}
	}
	
	/**
	 * Recursive replaceAll method that replaces all occurrences of a character in a string
	 * @param str, oldChar, newChar
	 */
	public static String replaceAll(String str, char oldChar, char newChar) {
		if(str.length() == 1) {
			return str;
		}
		if(str.charAt(0) == oldChar) {
			return newChar + replaceAll(str.substring(1), oldChar, newChar);
		}
		else {
			return str.charAt(0) + replaceAll(str.substring(1), oldChar, newChar);
		}
	}
	
	public static void main(String[] args) {
		int userInput = 0;
		//while loop that keeps the menu running until option 3 is chosen
		while(userInput != 3) {
			System.out.println("1. Test replace method\n2. Test replaceAll method\n3. Exit");
			Scanner kyb = new Scanner(System.in);
			Scanner kyb1 = new Scanner(System.in);
			userInput = kyb.nextInt();
			String s1;
			String oldCh;
			String newCh;
			
			//switch statement for the menu options
			switch(userInput) {
			case 1: 
				System.out.println("Enter a string.");
				s1 = kyb1.nextLine();
				System.out.println("Enter a old Character");
				oldCh = kyb1.next();
				System.out.println("Enter a new Character");
				newCh = kyb1.next();
				System.out.println(replace(s1,oldCh.charAt(0), newCh.charAt(0)) + "\n");
				break;
			case 2:
				System.out.println("Enter a string.");
				s1 = kyb1.nextLine();
				System.out.println("Enter a old Character");
				oldCh = kyb1.next();
				System.out.println("Enter a new Character");
				newCh = kyb1.next();
				System.out.println(replaceAll(s1,oldCh.charAt(0), newCh.charAt(0)) + "\n");
				break;
			case 3:
				System.out.println("End of Program");
				kyb.close();
				kyb1.close();
				System.exit(0);
				break;
			}
		}
	}
}
