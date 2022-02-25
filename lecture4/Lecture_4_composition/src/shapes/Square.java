package shapes;

public class Square extends AbstractShape implements IShape {
  private double length;

  public Square(double length) {
    super(0,0);
    this.length = length;
  }

  @Override
  public double getPerimeter() {
    return 4 * this.length;
  }

  @Override
  public double getArea() {
    return this.length * this.length;
  }
  public static void main(String [] args) {
    IShape shape = new Circle(2);
    System.out.println(shape.getArea());
    shape = new Square(2);
    System.out.println(shape.getArea());
  }
}
