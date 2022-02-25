package distance;

import java.util.Objects;

/**
 * This class represents a 3D Point class with coordinate (x, y, z).
 */
public class Point3D {
  private int x;
  private int y;
  private int z;

  /**
   * This is the default constructor with coordinate x, y, z equals to 0.
   */
  public Point3D() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  /**
   * This constructor takes in parameter x, y, z as coordinates.
   *  @param x Coordinate x.
   *  @param y Coordinate y.
   *  @param z Coordinate z.
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * This is a getter method to get x-coordinate.
   *  @return x Coordinate x.
   */
  public int getX() {
    return x;
  }

  /**
   * This is a getter method to get y-coordinate.
   *  @return y Coordinate y.
   */
  public int getY() {
    return y;
  }

  /**
   * This is a getter method to get z-coordinate.
   *  @return z Coordinate z.
   */
  public int getZ() {
    return z;
  }

  /**
   * This method calculates the distance between two Point3D objects.
   *   @param other another Point3D object.
   *   @return distance between other and this object.
   */
  public double distanceTo(Point3D other) {
    double distanceX = Math.pow(other.x - this.x, 2);
    double distanceY = Math.pow(other.y - this.y, 2);
    double distanceZ = Math.pow(other.z - this.z, 2);
    return Math.sqrt(distanceX + distanceY + distanceZ);
  }

  /**
   * This method is an override method for equals.
   *  @param o another Point3D object.
   *  @return boolean for whether they are equal or not.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point3D point3D = (Point3D) o;
    return x == point3D.x && y == point3D.y && z == point3D.z;
  }

  /**
   * This method is for returning hashcode for x, y, z.
   *    @return Objects.hash(x, y, z)
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }
}
