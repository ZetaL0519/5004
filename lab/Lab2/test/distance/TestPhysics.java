package distance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Junit class for testing Physics class.
 */
public class TestPhysics {
  private Point3D Point1;
  private Point3D Point2;
  private double time;

  /**
   * Construct and initialize two Point3D objects and initialize them.
   */

  @Before
  public void Setup() {
    Point1 = new Point3D(3, 4, 5);
    Point2 = new Point3D(4, 5, 6);
    time = 1;
  }

  /**
   * Test badVelocity in which time is not positive.
   */
  @Test
  public void testBadVelocity() {
    try {
      double t = 0;
      Physics.velocity(Point1, Point2, t);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadVelocity caught") + e.getMessage());
    }
    try {
      double t = -0.7;
      Physics.velocity(Point1, Point2, t);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadVelocity caught") + e.getMessage());
    }
  }

  /**
   * Test velocity method of Physics class.
   */
  @Test
  public void testVelocity() {
    Assert.assertEquals(Math.sqrt(3), Physics.velocity(Point1, Point2, time), 0.01);
  }
}