package assg6_CERVENKAZ19;

/**
 * @author zachary cervenka
 * StudentListInterface that describes the methods that will be in studentList
 */


import java.util.*;

public interface StudentListInterface {
	/**
	 * @param fileName
	 * this method should have a file name as the parameter. The method 
	 * loads the data containing all the students from a given file. 
	 */
	public void loadData(String fileName);
	
	/**
	 * his method displays the complete information of all the students 
	 * on the roster. It does not have any parameter and returns nothing.  
	 */
	public void displayRoster();
	
	/**
	 * @param id
	 * @return student
	 * this method should have an id (of String type) as the 
	 * parameter. It should return the Student object if found, or null if not found.
	 */
	public Student searchForStudent(String id);
	
	/**
	 * @param id, name, standing, major
	 * @return true/false
	 * this method is used to add a new Student. It should have four parameters that represent the id, name, standing, and major. If the id is already in the student roster, 
	 * then a message should be printed informing the user that the student already exists. 
	 * This method returns a boolean value. If the student is added, it returns true; otherwise it returns false
	 */
	public boolean addStudent(String id, String name, String standing, String major);
	
	/**
	 * @param id
	 * @return true/false
	 * this method should have an id (of String type) as the parameter. 
	 * It should remove the Student from the roster if the id is found. Otherwise it should 
	 * print a message. This method returns a boolean value. If the student is removed, it 
	 * returns true; otherwise it returns false.
	 */
	public boolean removeStudent(String id);
	
	/**
	 * @param major
	 * @return list of students with given major
	 * this method should have a major as the parameter. It 
	 * should return an ArrayList object with all the students with the given major. If 
	 * there is no student with the given major, the size of the ArrayList will be zero.
	 */
	public ArrayList<Student> getStudentsByMajor(String major);
	
	/**
	 * this method has no parameter and returns nothing. It should sort all the 
	 * students by their id. 
	 */
	public void Sort();
	
	/**
	 * his method has no parameter. It should write the student roster back to the 
	 * file if the data has been changed (the same file is used for both reading and writing). 
	 */
	public void Save();
}
