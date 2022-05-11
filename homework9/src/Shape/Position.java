package Shape;

import java.text.DecimalFormat;

/**
 * This is the class representing Position.
 */
public class Position {
  private double x;
  private double y;

  /**
   * This is the constructor for position.
   * @param x int x
   * @param y int y
   */
  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * This is a getter method for X-coordinate.
   * @return x
   */
  public double getX() {
    return x;
  }

  /**
   * This is a getter method for Y-Coordinate.
   * @return y
   */
  public double getY() {
    return y;
  }

  /**
   * This is ToString method.
   * @return string form of position.
   */
  @Override
  public String toString() {
    String pattern = "##0.0";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String XFormat = decimalFormat.format(this.x);
    String YFormat = decimalFormat.format(this.y);
    return "(" + XFormat + "," + YFormat + ")";
  }
}
