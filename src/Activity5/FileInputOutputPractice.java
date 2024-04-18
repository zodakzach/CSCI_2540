package Activity5;
import java.util.*;
import java.io.*;

public class FileInputOutputPractice {
	
	public static void main(String[] args) {
		String fileName1 = "activity5_input1.txt";
		String fileName2 = "activity5_input2.txt";
		String fileName3 = "activity5_output.txt";
		Scanner inputStream1 = null;
		Scanner inputStream2 = null;
		String line;
		PrintWriter outputStream = null;
		
		try {
			inputStream1 = new Scanner(new File(fileName1));
			inputStream2 = new Scanner(new File(fileName2));
			outputStream = new PrintWriter(fileName3);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file");
			System.exit(1);
		}
		
		while(inputStream1.hasNextLine()) {
			line = inputStream1.nextLine();
			outputStream.println(line);
		}
		
		inputStream1.close();
		
		while(inputStream2.hasNextLine()) {
			line = inputStream2.nextLine();
			outputStream.println(line);
		}
		
		inputStream2.close(); 	
		outputStream.close();
		
		System.out.println("Output was written to file: " + fileName3);
	}

}
