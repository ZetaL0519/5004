public class Circle {
  private double radius;
  final double PI = 3.1415; // constant variable
  private String color; // Simple color representation

  /**
   * Circle constructor that makes our instances
   *
   * @param radius
   * @param color
   */
  public Circle(double radius, String color) {
    this.radius = radius;
    this.color = color;
  }

  /**
   * getArea returns the area of the circle
   *
   * @return
   */
  public double getArea() {
    return PI * Math.pow(this.radius, 2);
  }

  public double getCircleference() {
    return 0;
  }

  public String getColor() {
    return "";
  }
}
