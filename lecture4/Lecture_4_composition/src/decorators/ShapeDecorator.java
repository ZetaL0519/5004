package decorators;
import shapes.Circle;
import shapes.IShape;
public class ShapeDecorator implements IShape {
  private IShape target;

  public ShapeDecorator(IShape target) {
    this.target = target;
  }

  protected IShape getTarget() {return this.target; }

  @Override
  public double getPerimeter() {
    return 0;
  }

  @Override
  public double getArea() {
    return 0;
  }

  @Override
  public String toString() {
    return target.toString();
  }
  public static void main(String [] args) {
    IShape shape =  new AsteriskDecorator(
                    new Circle(2));
    System.out.println(shape);
  }
}

class AsteriskDecorator extends ShapeDecorator {
  public AsteriskDecorator(IShape target){
    super(target);
  }
  @Override
  public String toString() {
    return "*****" + this.getTarget().toString() + "*****";
  }
}

class PlusDecorator extends ShapeDecorator {
  public PlusDecorator(IShape target){
    super(target);
  }
  @Override
  public String toString() {
    return "+++" + this.getTarget().toString() + "+++";
  }
}