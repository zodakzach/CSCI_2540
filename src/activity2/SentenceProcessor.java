package activity2;

import java.util.Scanner;

public class SentenceProcessor {
	
	public static void main(String[] args) 
	{
		System.out.println("Enter a Sentence: ");
		Scanner keyboard = new Scanner(System.in);
		String userSentence;
		int length;
		char lastCharacter;
		userSentence = keyboard.nextLine();
		length = userSentence.length();
		
		lastCharacter = userSentence.charAt(length -1);
		
		switch(lastCharacter)
		{
		case '?':
			if(length % 2 == 0)
				System.out.println("Thats an even question.");
			else
				System.out.println("Thats an odd question.");
				break;
		case '!':
			System.out.println("Wow!");
			break;
		case ',':
			System.out.println("More to come!");
			break;
		default:
			System.out.print("You always say,  \"" + userSentence + "\"");
			break;
		}
		
	}

}
