package shapes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {
  Circle circle;
  Circle otherCircle;

  @Before
  public void setUp() {
    circle = new Circle(2);
    otherCircle = new Circle(2, 1, 2, Color.BLUE);
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
    Circle badCircle = new Circle(-1);
  }

  @Test
  public void testToString() {
    assertEquals("Circle with radius:2.0 x:0 y:0 color:RED", circle.toString());
    assertEquals("Circle with radius:2.0 x:1 y:2 color:BLUE", otherCircle.toString());
  }
}