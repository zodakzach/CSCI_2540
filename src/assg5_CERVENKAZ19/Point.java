package assg5_CERVENKAZ19;

/*Author: Zachary Cervenka
 * Point class that allows you to create a point and give it a x and y,
 * as well as the ability to compare two points distance between each other and if they are equal
 */

public class Point {
	
	private int x, y;
	
	//Point constructor with no parameters
	public Point() {
		x = 0;
		y = 0;
	}
	
	/*
	 * Point constructor with 2 parameters
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * getX method that returns the value of x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/*
	 * getY method that returns the value of y
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/*
	 * setX method that changes the value of x to the given value
	 * @param newX
	 */
	public void setX(int newX) {
		x = newX;
	}
	
	/*
	 * setY method that changes the value of y to the given value
	 * @param newY
	 */
	public void setY(int newY) {
		y = newY;
	}
	
	/*
	 * toString method that returns the values of x and y in the form of a string
	 * @return "(x,y)"
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	/*
	 * distance method that calculates the distance between two points
	 * @param point
	 * @return distance
	 */
	public double distance(Point point) {
		return Math.sqrt(((point.x - this.x)*(point.x - this.x))+((point.y - this.y)*(point.y - this.y)));
	}
	
	/*
	 * equals method that determines if two points are equal
	 * @param obj
	 * @return true/false
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Point){ 
			Point temp = (Point)obj;
			return ((this.x == temp.x) && (this.y == temp.y));
		}
		else {
			return false;
		}
	}

}



