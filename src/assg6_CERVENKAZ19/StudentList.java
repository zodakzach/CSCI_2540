package assg6_CERVENKAZ19;

/**
 * @author zachary cervenka
 * StudentList class that allows you to create an array list and load a file into in and manage the list.
 */

import java.util.*;
import java.io.*;
import java.nio.file.StandardOpenOption;

public class StudentList implements StudentListInterface {
	
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private Scanner s = null;
	
	/**
	 * @param fileName
	 * this method should have a file name as the parameter. The method 
	 * loads the data containing all the students from a given file. 
	 */
	public void loadData(String fileName) {
		try {
		s = new Scanner(new File(fileName));
		}
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		while (s.hasNextLine()){
			String split = s.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(split, ",");
			while(tokenizer.hasMoreTokens()) {
				String tempId = tokenizer.nextToken();
				String tempName = tokenizer.nextToken() ;
				String tempStanding = tokenizer.nextToken();
				String tempMajor = tokenizer.nextToken();
				studentList.add(new Student(tempId, tempName, tempStanding, tempMajor));
			}
		}
		s.close();
	}
	
	/**
	 * his method displays the complete information of all the students 
	 * on the roster. It does not have any parameter and returns nothing.  
	 */
	public void displayRoster() {
		for(int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).toString() + "\n");
		}
	}
	
	/**
	 * @param id
	 * @return student
	 * this method should have an id (of String type) as the 
	 * parameter. It should return the Student object if found, or null if not found.
	 */
	public Student searchForStudent(String id) {
		if(id == null) {
			return null;
		}
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getId().equals(id)) {
				return studentList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * @param id, name, standing, major
	 * @return true/false
	 * this method is used to add a new Student. It should have four parameters that represent the id, name, standing, and major. If the id is already in the student roster, 
	 * then a message should be printed informing the user that the student already exists. 
	 * This method returns a boolean value. If the student is added, it returns true; otherwise it returns false
	 */
	public boolean addStudent(String id, String name, String standing, String major) {
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getId().equals(id)) {
				System.out.println("Student already exists.");
				return false;
			}
		}
		studentList.add(new Student(id, name, standing, major));
		return true;
	}
	
	/**
	 * @param id
	 * @return true/false
	 * this method should have an id (of String type) as the parameter. 
	 * It should remove the Student from the roster if the id is found. Otherwise it should 
	 * print a message. This method returns a boolean value. If the student is removed, it 
	 * returns true; otherwise it returns false.
	 */
	public boolean removeStudent(String id) {
		if (id == null) {
			return false;
		}
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getId().equals(id)) {
				studentList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param major
	 * @return list of students with given major
	 * this method should have a major as the parameter. It 
	 * should return an ArrayList object with all the students with the given major. If 
	 * there is no student with the given major, the size of the ArrayList will be zero.
	 */
	public ArrayList<Student> getStudentsByMajor(String major) {
		ArrayList<Student> studentsMajor = new ArrayList<Student>();
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getMajor().equals(major)) {
				studentsMajor.add(studentList.get(i));
			}
		}
		return studentsMajor;
	}
	
	/**
	 * this method has no parameter and returns nothing. It should sort all the 
	 * students by their id. 
	 */
	public void Sort() {
		Collections.sort(studentList);
	}
	
	/**
	 * his method has no parameter. It should write the student roster back to the 
	 * file if the data has been changed (the same file is used for both reading and writing). 
	 */
	public void Save() {
		PrintWriter output = null;
		File newFile = new File("assg6_data.txt");
		try {
			output = new PrintWriter(newFile);
			for(int i = 0; i < studentList.size(); i++) {
				output.println(studentList.get(i).toString());
			}	
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		output.close();	
	}
}
