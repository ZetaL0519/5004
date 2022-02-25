package shapes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {
  Circle circle; // instance for all of our tests
  Circle otherCircle;

  @Before
  public void setUp() {
    circle = new Circle(2);
    otherCircle = new Circle(2, Color.RED,1,2);
  }

  @Test
  public void testGetArea() {
    assertEquals(Math.PI * 4, circle.getArea(), 0.001);
  }

  @Test
  public void testGetPerimeter() {
    assertEquals(Math.PI * 4, circle.getPerimeter(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeRadius() {
    Circle circle = new Circle(-2);
  }

  @Test
  public void testToString() {
    assertEquals("Circle with radius: 2.0 color:BLUE at x:0 y:0", circle.toString());
    assertEquals("Circle with radius: 2.0 color:RED at x:1 y:2", otherCircle.toString());
  }

  @Test
  public void testEquals() {
    Circle localCircle = new Circle(2);
    assertEquals("Circles are not equal", localCircle, circle);
  }
}
