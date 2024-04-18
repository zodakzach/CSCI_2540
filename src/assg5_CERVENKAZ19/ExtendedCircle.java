package assg5_CERVENKAZ19;

/*Author: Zachary Cervenka
 * ExtendedCircle class that allows you to create a circle and give it a radius and center point 
 * Also allows you to scale and shift these circles and various computational methods for the circle
 */

public class ExtendedCircle {
	private double radius;
	private Point center = new Point();
	
	/*
	 * default constructor with no parameters
	 */
	public ExtendedCircle() {
		radius = 1;
		center.setX(0);
		center.setY(0);
	}
	
	/*
	 * constructor with one parameter
	 * @param radius
	 */
	public ExtendedCircle(double radius) {
		this.radius = radius;
		center.setX(0);
		center.setY(0);
	}
	
	/*
	 * constructor with 2 parameters
	 * @param radius
	 * @param center
	 */
	public ExtendedCircle(double radius, Point point) {
		this.radius = radius;
		center.setX(point.getX());
		center.setY(point.getY());
	}
	
	/*
	 * getRadius method that returns the radius
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	
	/*
	 * getCenter method that returns the center
	 * @return center
	 */
	public Point getCenter() {
		return center;
	}
	
	/*
	 * setRadius method that changes the value of the radius to the given value
	 * @param newRadius
	 */
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
	
	/*
	 * setCenter method that changes the value of the center to the new point
	 * @param newCenter
	 */
	public void setCenter(Point newCenter) {
		center = newCenter;
	}
	
	/*
	 * compArea method that uses the formula PIr^2 to calculate area of circle
	 * @return area
	 */
	public double compArea() {
		return (Math.PI * (radius * radius));
	}
	
	/*
	 * compCircumference method that uses the formula 2PIr to calculate the circumference
	 * @return circumference
	 */
	public double compCircumference() {
		return (2 * Math.PI * radius);
	}
	
	/*
	 * toString method that returns the radius and center as a string
	 * @return "Radius: Center:"
	 */
	public String toString() {
		return "Radius: " + radius + "\n" + "Center: " + center.toString();
	}
	
	/*
	 * positionToCircle method that returns a 1 if point is in circle
	 * a 0 if point is on circle
	 * a -1 if point is outside circle
	 * @param point
	 * @return 1, 0, -1
	 */
	public int positionToCircle(Point point) {
		if(point.distance(center) < radius) {
			return -1;
		}
		else if(point.distance(center) == radius) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	/*
	 * shift method that creates a new circle that is shifted from the original circle by a given x and y
	 * @param xShift
	 * @param yShift
	 * @return newCircle
	 */
	public ExtendedCircle shift(int xShift, int yShift) {
		Point newCenter = new Point(center.getX() + xShift, center.getY() + yShift);
		ExtendedCircle newCircle = new ExtendedCircle(radius, newCenter);
		return newCircle;
	}
	
	/*
	 * scale method that creates new circle that is the original circle scaled by a given value
	 * @param radius
	 * @return newCircle
	 */
	public ExtendedCircle scale(double radius) {
		double newRadius = this.radius * radius;
		ExtendedCircle newCircle = new ExtendedCircle(newRadius);
		return newCircle;
	}
	
	/*
	 * overlap method that determines if two circles are overlapping
	 * @param circle
	 * @return false/true
	 */
	public boolean overlap(ExtendedCircle circle) {
		if(center.distance(circle.getCenter()) < (radius + circle.getRadius())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * equals method that determines if two circles are equal
	 * @param obj
	 * @return true/false
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof ExtendedCircle){ 
			ExtendedCircle temp = (ExtendedCircle)obj;
			return((this.center.getX() == temp.center.getX()) && (this.radius == temp.radius) && (this.center.getY() == temp.center.getY()));
		}
		else {
			return false;
		}
	}
}
