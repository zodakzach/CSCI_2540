package assg6_CERVENKAZ19;

/**
 * @author zachary cervenka
 * Student class that allows you to create a student with a given id, name, standing, and major 
 * implements comparable
 */

public class Student implements Comparable<Student> {
	private String iD, name, standing, major;
	
	/**
	 * @param id, name, standing, major
	 * 4 param constructor that sets the id, name, standing, and major to the given params
	 */
	public Student(String iD, String name, String standing, String major) {
		this.iD = iD;
		this.name = name;
		this.standing = standing;
		this.major = major;
	}
	
	/**
	 * @returns "id, name, standing, major"
	 * toString method that returns student info
	 */
	public String toString() {
		return iD + "," + name + "," + standing + "," + major;
	}
	
	/**
	 * @returns id
	 * getId method that gets the id of the student
	 */
	public String getId() {
		return iD;
	}
	
	/**
	 * @returns name
	 * getName method that gets the name of the student
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @returns standing
	 * getStanding method that gets the standing of the student
	 */
	public String getStanding() {
		return standing;
	}
	
	/**
	 * @returns major
	 * getMajor method that gets the major of the student
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * @param newMajor
	 * setMajor method that sets the major to the new major given
	 */
	public void setMajor(String newMajor) {
		major = newMajor;
	}
	
	/**
	 * @param Object A
	 * @return true/false
	 * equals method that compares two students ids to see if they are equal
	 * if equal then return true else return false
	 */
	public boolean equals(Object A) {
		if (A == null) {
			return false;
		}
		if(A instanceof Student) {
			Student temp = (Student)A;
			return this.iD.equals(temp.getId());
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param student
	 * @return compareTo of two students
	 * compareTo method that uses the compareTo method to compare students
	 */
	public int compareTo(Student student) {
		return iD.compareTo(student.getId());
	}

}
