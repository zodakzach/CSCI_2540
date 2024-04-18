package Activity7;

public class Student {
	private String iD, name, standing, major;
	
	public Student(String iD, String name, String standing, String major) {
		this.iD = iD;
		this.name = name;
		this.standing = standing;
		this.major = major;
	}
	
	public String toString() {
		return iD + ", " + name + ", " + standing + ", " + major;
	}

}
