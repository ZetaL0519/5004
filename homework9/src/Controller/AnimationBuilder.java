package Controller;

/**
 * This is the Animation Builder class for creating shape and moving shapes.
 * @param <Doc>
 */
public interface AnimationBuilder<Doc> {

  /**
   * Build up the model.
   * @return ShapeModel
   */
  Doc build();

  /**
   * Create shape with the parameters from the file commands.
   * @param name Shape name
   * @param type Shape type
   * @param x Shape x-coordinate
   * @param y Shape y-coordinate
   * @param width shape width
   * @param height shape height
   * @param r Color R value
   * @param g Color G value
   * @param b Color B value
   * @return this
   */
  AnimationBuilder<Doc> createShape(String name, String type, int x, int y, int width, int height, int r, int g, int b);

  /**
   * Move Shape with the parameters from the file commands.
   * @param name Shape name
   * @param newX new x-coordinate
   * @param newY new y-coordinate
   * @return this
   */
  AnimationBuilder<Doc> MoveShape(String name, int newX, int newY);

  /**
   * Remove shape with the name given.
   * @param name shape name
   * @return this
   */
  AnimationBuilder<Doc> RemoveShape(String name);

  /**
   * Resize shape with the parameters given.
   * @param name shape name
   * @param newW new width
   * @param newH new height
   * @return this
   */
  AnimationBuilder<Doc> ResizeShape(String name, int newW, int newH);

  /**
   * Change the color of the shape.
   * @param name shape name
   * @param newR shape Color R value
   * @param newG shape Color G value
   * @param newB shape Color B value
   * @return this
   */
  AnimationBuilder<Doc> ColorShape(String name, int newR, int newG, int newB);

  /**
   * SnapShot the current state.
   * @param Description snapshot description
   * @return this
   */
  AnimationBuilder<Doc> SnapShot(String Description);
}
