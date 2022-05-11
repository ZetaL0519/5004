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
   * Get the shape type of Shape object
   * @return
   */
  String getType();

  /**
   * Get the size array of shape object.
   * @return size array
   */
  double[] getSize();

  /**
   * Move the position of IShape object.
   * @param newPosition new Position.
   * @return new IShape object.
   */
  IShape move(Position newPosition);

  /**
   * Change color of IShape object.
   * @param newR
   * @return new IShape object.
   */
  IShape changeColor(int newR, int newG, int newB);

  /**
   * Change size of IShape object.
   * @param newSize1 newSize1
   * @param newSize2 newSize2
   * @return new IShape object.
   */
  IShape changeSize(double newSize1, double newSize2);
}
