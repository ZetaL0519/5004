package distance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
This is a JUnit class for testing Point3D class.
 */
public class TestPoint3D {
  private Point3D Point1;
  private Point3D Point2;
  private Point3D Point3;

  /**
   * Construct and initialize two Point3D objects.
   */

  @Before
  public void setUp() {
    Point1 = new Point3D();
    Point2 = new Point3D(2, 3, 5);
    Point3 = new Point3D(-1, -1, 0);
  }

  /**
   * Test all the getter methods.
   */
  @Test
  public void testGet() {
    Assert.assertEquals(2, Point2.getX());
    Assert.assertEquals(3, Point2.getY());
    Assert.assertEquals(5, Point2.getZ());
    Assert.assertEquals(0, Point1.getX());
    Assert.assertEquals(0, Point1.getY());
    Assert.assertEquals(0, Point1.getZ());
    Assert.assertEquals(-1, Point3.getX());
    Assert.assertEquals(-1, Point3.getY());
    Assert.assertEquals(0, Point3.getZ());
  }

  /**
   * Test DistanceTo method.
   */
  @Test
  public void testDistanceTo() {
    Assert.assertEquals(Math.sqrt(38) ,Point2.distanceTo(Point1), 0.001);
    Assert.assertEquals(Math.sqrt(2) ,Point3.distanceTo(Point1), 0.001);
    Assert.assertEquals(Math.sqrt(50) ,Point3.distanceTo(Point2), 0.001);
  }

  /**
   * Test Equal method.
   */
  @Test
  public void TestEqual() {
    Assert.assertNotEquals(Point2, Point1);
    Assert.assertNotEquals(Point3, Point1);
    Assert.assertEquals(Point2, new Point3D(2, 3, 5));
  }
}
