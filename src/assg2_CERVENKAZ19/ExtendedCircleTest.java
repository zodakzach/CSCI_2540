package assg2_CERVENKAZ19;

/*Author: Zachary Cervenka
 * Code that tests all methods and constructors in the ExtendedCircle and Point classes.
 */

public class ExtendedCircleTest {
	public static void main(String[] args) {
		//creating two points to test the two constructors in the Point Class
		Point point1 = new Point();
		Point point2 = new Point(3,6);
		
		System.out.println("Testing the default constructor and toString method in Point:");
		System.out.print("point1 coordinates are: ");
		//prints out the coordinates using the toString method in the Point class.
		System.out.println(point1.toString());
		
		//prints out the coordinates using the getX and getY methods in the Point class
		System.out.println("\nTesting the getX and getY methods in Point");
		System.out.println("point2 x = " + point2.getX());
		System.out.println("point2 y = " + point2.getY());
		
		//Prints out the distance between points 1 and 2 using the distance method in the Point class
		System.out.println("\nTesting the distance method in Point");
		System.out.println("The distance between point1 and point2: " + point1.distance(point2));
		
		//Points 1 and 2 are not equal at this moment and so this should demonstrate that by using the equals method in the Point class
		System.out.println("\nTesting the equals methods false case in Point");
		System.out.println("point1 == point2: " + point1.equals(point2));
		
		//Setting point 1 equal to point 2 using the setX and setY methods in the Point class
		point1.setX(3);
		point1.setY(6);
		
		System.out.println("\nTesting the setX and setY methods in Point");
		System.out.println("setting point1 x = 3 and y = 6");
		
		//confirming that point 1 and 2 are now equal and that the equals methods true case works.
		System.out.println("\nTesting the equals methods true case in Point");
		System.out.println("point1 == point2: " + point1.equals(point2));
		
		//creating 3 circles to test all 3 constructors in the ExtendedCircle class
		ExtendedCircle circle1 = new ExtendedCircle();
		ExtendedCircle circle2 = new ExtendedCircle(5.0);
		ExtendedCircle circle3 = new ExtendedCircle(5.0, point1);
		
		System.out.println("\nTesting the defualt constructor and toString method in ExtendedCircle");
		System.out.println("circle1:");
		//printing out the circles radius and center using the toString method in ExtendedCircle
		System.out.println(circle1.toString());
		
		System.out.println("\nTesting the 1 parameter constructor in ExtendedCircle");
		System.out.println("circle2:" + "\n" + "Radius: " + circle2.getRadius());
		System.out.println("Center: " + circle2.getCenter());
		
		System.out.println("\nTesting the 2 parameter constructor in ExtendedCircle");
		System.out.println("circle3:");
		System.out.println(circle3.toString());
		
		System.out.println("\nTesting the compArea and compCircumference methods in ExtendedCircle");
		System.out.println("The area of circle1: " + circle1.compArea());
		System.out.println("The area of circle2: " + circle2.compArea());
		System.out.println("The circumference of circle3: " + circle3.compCircumference());
		
		//setting the radius and center for circle1 using setRadius and setCenter methods in ExtendedCircle
		circle1.setRadius(5.0);
		circle1.setCenter(point2);
		
		System.out.println("\nTesting the setRadius and setCenter methods in ExtendedCircle");
		System.out.println("circle1: ");
		System.out.println(circle1.toString());
		
		System.out.println("\nTesting the equals methods true and false case in ExtendedCircle");
		System.out.println("circle1 == circle3: " + circle1.equals(circle3)); //should be true
		System.out.println("circle1 == circle2: " + circle1.equals(circle2)); // should be false
		
		//creating a fourth circle to test the shift method in ExtendedCircle
		ExtendedCircle circle4 = circle1.shift(9, 12);
		
		System.out.println("\nTesting the shift method for ExtendedCircle");
		//prints out circle1 radius and center to show that it has not changed 
		System.out.println("circle1:\n" + circle1.toString());
		//prints out circle4 radius and center to show it was shifted by 9 on the x and 12 on the y
		System.out.println("\ncircle4:\n" + circle4.toString());
		
		System.out.println("\nTesting the overlap methods true and false case in ExtendedCircle");
		System.out.println("circle4 overlap circle1: " + circle4.overlap(circle1)); //should be false
		System.out.println("circle1 overlap circle2: " + circle1.overlap(circle2)); //should be true
		
		//creating a fifth circle to test the scale method in ExtendedCircle
		ExtendedCircle circle5 = circle2.scale(.5);
		System.out.println("\nTesting the scale method for ExtendedCircle");
		//prints out circle2 radius and center to show that it has not changed 
		System.out.println("circle2:\n" + circle2.toString());
		//prints out circle5 radius and center to show that it was scaled by 0.5 correctly
		System.out.println("\ncircle5:\n" + circle5.toString());
		
		System.out.println("\nTesting the 3 cases for the positionToCircle method in ExtendedCircle");
		System.out.println("1 = inside circle     0 = on circle     -1 = outside circle");
		System.out.println("\ncircle2 center points position to circle1: " + circle1.positionToCircle(circle2.getCenter()));
		System.out.println("circle5 center points position to circle2: " + circle2.positionToCircle(circle5.getCenter()));
		
		//creating a third point on circle2 to show the 0 case for the positionToCircle method in ExtendedCircle
		Point point3 = new Point(5,0);
		
		System.out.println("point3 position to circle2: " + circle2.positionToCircle(point3));	
	}
}
