package distance;

/**
 * This class is a "Utility Service" class which provides a single class method.
 */
public class Physics {
  /**
   * This class calculates a velocity given two Point3D objects and an elapsed time.
   *   @param one a Point3D object.
   *   @param two a Point3D object.
   *   @param elapsedTime (double)
   *   @return average velocity.
   *   @throws IllegalArgumentException if time is not positive.
   */
  public static double velocity(Point3D one, Point3D two, double elapsedTime)
          throws IllegalArgumentException {
    if (elapsedTime <= 0) {
      throw new IllegalArgumentException("Time given should be positive.");
    }
    double distance = one.distanceTo(two);
    double vel = distance / elapsedTime;
    return vel;
  }

  /**
   * This is a static main method for checking Point3D and velocity.
   * @param args message.
   */
  public static void main(String [] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1, 1, 1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 0);
      System.out.println("Prof. Keith is on the move! His Velocity =" + velocity);
      velocity = Physics.velocity(one, two, 0);
      System.out.println("Velocity =" + velocity);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Encountered an error: " + e.getMessage());
    }
  }
}