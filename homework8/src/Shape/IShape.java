package Shape;

/**
 * This is an IShape interface.
 */
public interface IShape {

  /**
   * Get Shape object position.
   * @return Position object.
   */
  Position getPosition();

  /**
   * Get name of IShape object.
   * @return
   */
  String getName();

  /**
   * Get color of IShape object.
   * @return
   */
  Color getColor();

  /**
   * Move the position of IShape object.
   * @param newPosition new Position.
   * @return new IShape object.
   */
  IShape move(Position newPosition);


  /**
   * Change color of IShape object.
   * @param newColor new Color.
   * @return new IShape object.
   */
  IShape changeColor(Color newColor);

  /**
   * Change size of IShape object.
   * @param newSize1 newSize1
   * @param newSize2 newSize2
   * @return new IShape object.
   */
  IShape changeSize(double newSize1, double newSize2);
}
