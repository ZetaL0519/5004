package shapes;

public class Square extends AbstractShape implements IShape {
  private double length;

  public Square(double length) {
    super(0,0);
    this.length = length;
  }

  @Override
  public double getArea() {
    return this.length * this.length;
  }

  @Override
  public double getPerimeter() {
    return this.length * 4;
  }

  @Override
  public String toString() {
    return "Square with length:" + this.length + " x:" + this.getX()
            + " y:" + this.getY();
  }

  public static void main(String [] args) {
    IShape shape;
    shape = new Square(2);
    System.out.println("Shape area = " + shape.getArea());
    System.out.println(shape.toString());

    shape = new Circle(2);
    System.out.println("Shape area = " + shape.getArea());

  }
}
