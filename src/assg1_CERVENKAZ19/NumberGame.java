package assg1_CERVENKAZ19;

/*Author: Zachary Cervenka
 * Random number game that asks the user to guess a number between 0 and 99 
 * until its correct and then lets them know how many attempts it took
 */

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
	
	public static void main (String[] args) 
	{
		//generates random number
		int secret;
		int attempts = 0;
		Random generator = new Random();
		secret = generator.nextInt(100);
		
		//asks user for first attempt at guessing
		System.out.println("Guess a number between 0 and 99.");
		Scanner keyboard = new Scanner(System.in);
		int userGuess;
		userGuess = keyboard.nextInt();
		attempts++;
		
		//while the guess is incorrect this loop will continue to happen
		while(userGuess != secret) 
		{
			//if users guess is greater than the secret then it will tell them 
			if(userGuess > secret)
			{
				System.out.println("The correct number is lower. Try again.");
				userGuess = keyboard.nextInt();
				attempts++;
			}
			//if users guess is less than secret then it will tell them
			else if(userGuess < secret) 
			{
				System.out.println("The correct number is higher. Try again.");
				userGuess = keyboard.nextInt();
				attempts++;
			}
		}
		//if they guess the correct number the while loop exits and it tells them how many attempts
		System.out.println("Correct! It took you " + attempts + " tries.");
	}
}
