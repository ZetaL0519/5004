package Shape;

/**
 * This is the class representing Rectangle.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;

  /**
   * This is the constructor for Rectangle.
   *
   * @param name String name
   * @param position Position object
   * @param color Color object
   * @param width double width
   * @param height double height
   * @throws IllegalArgumentException if width or height negative.
   */
  public Rectangle(String name, Position position, Color color,
                      double width, double height) throws IllegalArgumentException {
    super(name, position, color);
    if (width < 0 || height < 0 ) {
      throw new IllegalArgumentException("Invalid Side");
    }
    this.width = width;
    this.height = height;
  }

  /**
   * Getter method for height.
   * @return height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Getter method for width.
   * @return width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Move Rectangle to a new position.
   * @param newPosition new Position object.
   * @return new Rectangle object.
   */
  @Override
  public IShape move(Position newPosition) {
    return new Rectangle(this.name, newPosition, this.color,
            this.width, this.height);
  }

  /**
   * Change Rectangle color.
   * @param newColor new Color
   * @return new Rectangle object.
   */
  @Override
  public IShape changeColor(Color newColor) {
    return new Rectangle(this.name, this.position, newColor,
            this.width, this.height);
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
    return new Rectangle(this.name, this.position, this.color,
            newSize1, newSize2);
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: rectangle" + "\n"
            + "Min corner: " + this.getPosition().toString()
            + ", " + "Width: " + String.format("%.1f", this.getWidth())
            + ", " + "Height: " + String.format("%.1f", this.getHeight())
            + ", " + "Color: " + this.color.toString();
  }
}
