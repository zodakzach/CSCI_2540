package assg1_CERVENKAZ19;

/* Author: Zachary Cervenka
 * A program that counts the number of families whose
 * income is lower than 10% of the maximum income that was given.
 */

import java.util.Scanner;

public class CountFamilies {
	
	public static void main(String[] args) 
	{
		int numOfFamilies;
		int maxIncome = 0;
		int lowIncomeFamilies = 0;
		
		//Asks user for number of families and creates array of that size
		System.out.println("Enter number of families.");
		Scanner keyboard = new Scanner(System.in);
		numOfFamilies = keyboard.nextInt();
		int[] incomes = new int[numOfFamilies];

		//loop that asks user for incomes and stores them into array
		for(int i = 0; i < numOfFamilies; i++) 
		{
			System.out.print("Enter an income: ");
			incomes[i] = keyboard.nextInt();
		}
		
		//if there is only one family then the max income is that family
		if(numOfFamilies < 2) 
		{
			maxIncome = incomes[0];
		}
		
		//loop that finds max income in array if there is more than one family
		for(int i = 0; i < numOfFamilies -1; i++)
		{
			if(incomes[i] > incomes[i+1]) 
			{
				maxIncome = incomes[i];
			}
			else if(maxIncome < incomes[i+1])
			{
				maxIncome = incomes[i+1];
			}
		}
		System.out.println("The maximum income is: " + maxIncome);
		System.out.println("The incomes of families making less than 10% of the maximum are:");

		//loop that finds the families that make 10% or less than that of the max income family.
		for(int i = 0; i < numOfFamilies; i++)
		{
			if(incomes[i] <= (maxIncome/10)) 
			{ 
				System.out.println(incomes[i]);
				lowIncomeFamilies++;
			}
		}
		System.out.println("For a total of " + lowIncomeFamilies + " families.");
	}
}
