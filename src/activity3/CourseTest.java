package activity3;

public class CourseTest {
	
	public static void main(String[] args) {
		Course course1 = new Course("CSCI 2540", "Java Programming");
		Course course2 = new Course("CSCI 4602", "Automata", 4);
		
		System.out.println(course1.toString());
		System.out.println(course2.toString());
		
		course1.setTitle("Data Abstraction and Object-Oriented Data Structures");
		course1.setCredit(4);
		
		System.out.println(course1.getTitle());
		System.out.println(course1.getCredit());
		
		course1.printInfo();
		course2.printInfo();
	}
}
