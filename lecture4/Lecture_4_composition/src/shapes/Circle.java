package shapes;

import java.util.Objects;

public class Circle extends AbstractShape {
  private double radius;
  private Color color;

  public Circle(double radius) throws IllegalArgumentException {
    super(0,0);
    if(radius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative");
    }
    this.radius = radius;
    this.color = Color.BLUE;
  }
  // overloaded constructor
  public Circle(double radius, Color color,
                int x, int y) throws IllegalArgumentException {
    super(x, y);
    if(radius < 0) {
      throw new IllegalArgumentException("Radius cannot be negative");
    }
    this.radius = radius;
    this.color = color;
  }


  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  public double getPerimeter() {
    return 2 * Math.PI * this.radius;
  }

  @Override
  public String toString() {
    return "Circle with radius: " + this.radius
            + " color:" + color.toString()
            + " at x:" + this.getX() + " y:" + this.getY();
  }

  @Override
  public boolean equals(Object other) {
    if(this == other) {
      return true;
    }
    if(this.getClass() == other.getClass()) {
      Circle o = (Circle) other;
      if((Double.compare(this.radius, o.radius) == 0)
              && (this.getX() == o.getX())
              && (this.color.equals(o.color))
              && (this.getY() == o.getY())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(radius, color, this.getX(), this.getY());
  }
}

