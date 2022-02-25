package shapes;

public class Circle {
  private double radius;
  private int x;
  private int y;
  private Color color;

  public Circle(double radius) throws IllegalArgumentException {
    if(radius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative!");
    }
    this.radius = radius;
    this.x = 0;
    this.y = 0;
    this.color = Color.RED;
  }

  public Circle(double radius, int x, int y, Color color){ // overload
    if(radius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative!");
    }
    this.radius = radius;
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  public double getPerimeter() {
    return Math.PI * 2 * this.radius;
  }

  @Override
  public String toString() {
    return "Circle with radius:" + this.radius + " x:" + this.x
            + " y:" + this.y + " color:" + this.color.toString();
  }
}
