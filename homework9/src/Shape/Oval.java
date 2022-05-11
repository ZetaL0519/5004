package Shape;

/**
 * This is a class representing Oval.
 */
public class Oval extends AbstractShape {
  private double XRadius;
  private double YRadius;

  /**
   * This is the constructor for Oval.
   *
   * @param name     String name.
   * @param position Position object.
   * @param color    Color object.
   * @throws IllegalArgumentException if name is null.
   */
  public Oval(String name, Position position, Color color
          , double XRadius, double YRadius) throws IllegalArgumentException {
    super(name, position, color);
    this.XRadius = XRadius;
    this.YRadius = YRadius;
  }

  /**
   * Getter method for Shape type.
   * @return typename
   */
  @Override
  public String getType() {
    return "Oval";
  }

  /**
   * Getter method for size array.
   * @return a double array
   */
  @Override
  public double[] getSize() {
    return new double[]{this.XRadius, this.YRadius};
  }

  /**
   * Move the position of Oval object.
   *
   * @param newPosition new Position.
   * @return new Oval object.
   */
  @Override
  public IShape move(Position newPosition) {
    return new Oval(name, newPosition, color, XRadius, YRadius);
  }

  /**
   * Change color for the oval object.
   * @param newR new Color R value
   * @param newG new Color G value
   * @param newB new Color B value
   * @return new Oval object
   */
  @Override
  public IShape changeColor(int newR, int newG, int newB) {
    return new Oval(name, position, new Color(newR, newG, newB), XRadius, YRadius);
  }

  /**
   * Change size of IShape object.
   *
   * @param newSize1 newSize1
   * @param newSize2 newSize2
   * @return new IShape object.
   */
  @Override
  public IShape changeSize(double newSize1, double newSize2) {
    return new Oval(name, position, color, newSize1, newSize2);
  }

  /**
   * ToString method
   * @return Oval Information method.
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: oval" + "\n"
            + "Center: " + this.getPosition().toString()
            + ", " + "X radius: " + String.format("%.1f", this.getSize()[0])
            + ", " + "Y radius: " + String.format("%.1f", this.getSize()[1])
            + ", " + "Color: " + this.color.toString();
  }
}
