package Activity7;
import java.util.*;
import java.io.*;

public class StudentList implements StudentListInterface {
	
	private ArrayList<String> studentList = new ArrayList<String>();
	private Scanner s = null;
	
	public void loadData(String fileName) {
		try {
		s = new Scanner(new File(fileName));
		}
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		while (s.hasNextLine()){
			studentList.add(s.nextLine());
		}
		s.close();
	}
	
	public void displayRoster() {
		for(int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i) + "\n");
			
		}
	}
	
	

}
