package assg5_CERVENKAZ19;

/**
 * @author zachary cervenka
 * j unit test program for the Point class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPoint {
	private Point a, b, c;

	@Before
	public void setUp() throws Exception {
		a = new Point();
		b = new Point(2,2);
		c = new Point();
	}

	@Test
	public void defualtConstructorTest() {
		assertEquals("Point a x coordinates: ", 0, a.getX());
		assertEquals("Point a y coordinates: ", 0, a.getY());

	}
	
	@Test
	public void twoParamConstructorTest() {
		assertEquals("Point b x coordinate: ", 2, b.getX());
		assertEquals("Point b y coordinate: ", 2, b.getY());
	}
	
	@Test
	public void getXTest() {
		assertEquals("Point b x coordinate: ", 2, b.getX());

	}
	
	@Test
	public void getYTest() {
		assertEquals("Point b y coordinate: ", 2, b.getY());
	}
	
	@Test
	public void setXTest() {
		b.setX(3);
		assertEquals("Setting Point b x coordinate: ", 3, b.getX());

	}
	
	@Test
	public void setYTest() {
		b.setY(3);
		assertEquals("Setting Point b x coordinate: ", 3, b.getY());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Testing toString method: ", "(3, 3)", b.toString());

	}
	
	@Test
	public void distanceTest() {
		assertEquals("Testing distance method: ", 4.24, b.distance(a), 1);

	}
	
	@Test
	public void equalsTest() {
		assertTrue(a.equals(c));
		assertFalse(a.equals(b));
	}

}
