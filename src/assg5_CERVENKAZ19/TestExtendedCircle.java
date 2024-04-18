package assg5_CERVENKAZ19;

/**
 * @author zacharyc ervenka
 * j unit test program for the ExtendedCircle class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestExtendedCircle {
	private ExtendedCircle a, b, c, d, e, f;
	private Point one, two, three;

	@Before
	public void setUp() {
		a = new ExtendedCircle();
		b = new ExtendedCircle(5.0);
		c = new ExtendedCircle(2.0, one);
		d = new ExtendedCircle();
		e = new ExtendedCircle(1.0, three);
		f = new ExtendedCircle();
		one = new Point();
		two = new Point(1,0);
		three = new Point (4,0);
	}

	@Test
	public void testDefualtConstructor() {
		assertEquals("Circle a center: ", a.getCenter() , a.getCenter());
		assertEquals("Circle a radius: ", 1, a.getRadius(),1);
	}
	
	@Test
	public void testOneParamConstructor() {
		assertEquals("Circle b radius: ", 5, b.getRadius(), 1);
	}
	
	@Test
	public void testTwoParamConstructor() {
		assertEquals("Circle c center: ", one, c.getCenter());
		assertEquals("Circle c radius: ", 2, c.getRadius(), 1);
	}
	
	@Test
	public void testGetRadius() {
		assertEquals("Circle a radius: ", 1, a.getRadius(), 1);
	}
	
	@Test
	public void testGetCenter() {
		assertEquals("Circle c center: ", one, c.getCenter());
	}
	
	@Test
	public void testSetRadius() {
		a.setRadius(3);
		assertEquals("Setting Circle a radius to 3: ", 3, a.getRadius(), 1);
	}
	
	@Test
	public void testSetCenter() {
		b.setCenter(one);
		assertEquals("Setting Circle b center to (0,0): ", one, b.getCenter());
	}
	
	@Test
	public void testCompArea() {
		assertEquals("Circle a area: ", Math.PI * 1, a.compArea(), 1);
	}
	
	@Test
	public void testCompCircumference() {
		assertEquals("circle a circumference: ", 2*Math.PI*1, a.compCircumference(),1);
	}
	
	@Test
	public void testToString() {
		assertEquals("Circle a: ", "Radius: 1.0\nCenter: (0,0)", a.toString());
	}
	
	@Test
	public void testPositionToCircle() {
		assertEquals("Testing in circle: ", 1, a.positionToCircle(one));
		assertEquals("Testing on circle: ", 0, a.positionToCircle(two));
		assertEquals("Testing outside circle: ", -1, a.positionToCircle(three));
	}
	
	@Test
	public void testShift() {
		f.shift(5, 5);
		assertEquals("Circle f center: ", "(5,5)", f.getCenter());
	}
	
	@Test
	public void testScale() {
		c.scale(2);
		assertEquals("circle c radius: ", 4, c.getRadius(),1);
	}
	
	@Test
	public void testOverlap() {
		assertTrue(a.overlap(b));
		assertFalse(a.overlap(e));
	}
	
	@Test
	public void testEquals() {
		assertTrue(a.equals(d));
		assertFalse(a.equals(b));
	}

}
