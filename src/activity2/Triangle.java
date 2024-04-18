package activity2;
import java.util.Scanner;

public class Triangle {
	
	public static void main(String[] args) 
	{
		System.out.println("Enter size of triangle: ");
		int size;
		Scanner keyboard = new Scanner(System.in);
		size = keyboard.nextInt();
		printTriangle(size);
	}
	
	public static void printLine(int size) 
	{
		for(int i = 0; i < size; i++) 
		{
			System.out.print('*');
		}
	}
	
	public static void printTriangle(int size)
	{
		for(int i = 0; i < size; i++) 
		{
			if(i > 0)
			{
			printLine(i);
			System.out.println();
			}
		}
		for(int i = size; i > 0; i--) 
		{
			printLine(i);
			System.out.println();
		}
	}
}
