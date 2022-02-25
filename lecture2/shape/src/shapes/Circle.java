package shapes;

public class Circle {
  private double radius;
  private double a;
  private double b;

  public Circle(double radius){
    this.radius = radius;
    this.a = a;
    this.b = b;
  }

  public double getArea(){
    return Math.PI * Math.pow(this.radius, 2);
  }

  public double getPerimeter(){
    return Math.PI * 2 * this.radius;
  }

  @Override
  public String toString(){
    return "Circle with radius" + this.radius;
  }
}


