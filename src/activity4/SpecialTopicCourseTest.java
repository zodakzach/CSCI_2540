package activity4;

public class SpecialTopicCourseTest {
	public static void main(String[] args) {
		SpecialTopicCourse c1 = new SpecialTopicCourse("CSCI 2540", "Java Programming", "Object Oriented Coding");
		SpecialTopicCourse c2 = new SpecialTopicCourse("CSCI 4602", "Automata", "Finite State Machines", 4);
		Course c3 = new SpecialTopicCourse("CSCI 2540", "Java Programming", "Java Language coding", 3);
		
		c1.setTopic("Java Language coding");
		System.out.println(c1.getTopic());
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		
		System.out.print("c1 == c2: ");
		System.out.println(c1.equals(c2));
		System.out.print("c1 == c3: ");
		System.out.println(c1.equals(c3));	
	}

}
