package Shape;

import java.util.Objects;

/**
 * This is Abstract shape class
 */
public abstract class AbstractShape implements IShape {
  protected String name;
  protected Position position;
  protected Color color;

  /**
   * This is the constructor for AbstractShape.
   * @param name String name.
   * @param position Position object.
   * @param color Color object.
   * @throws IllegalArgumentException if name is null.
   */
  protected AbstractShape(String name, Position position, Color color)
          throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = name;
    this.position = position;
    this.color = color;
  }

  /**
   * Get Shape object position.
   * @return Position object.
   */
  @Override
  public Position getPosition() {
    return this.position;
  }

  /**
   * Get Shape Name.
   * @return String name.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Get Shape Color
   * @return Color object.
   */
  @Override
  public Color getColor() {
    return color;
  }

  /**
   * Move shape object to new position.
   * @param newPosition new Position.
   * @return IShape object
   */
  @Override
  public IShape move(Position newPosition) {
    return null;
  }

  /**
   * Change color to a shape object.
   * @param newColor new Color
   * @return IShape object
   */
  @Override
  public IShape changeColor(Color newColor) {
    return null;
  }

  /**
   * Change size to a shape object.
   * @param newSize1 newSize1
   * @param newSize2 newSize2
   * @return IShape object
   */
  @Override
  public IShape changeSize(double newSize1, double newSize2) {
    return null;
  }

  /**
   * Equal method to compare shape objects.
   * @param o IShape object.
   * @return boolean whether two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return name.equals(that.name) && position.equals(that.position) && color.equals(that.color);
  }

  /**
   * HashCode of IShape object.
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, position, color);
  }
}
