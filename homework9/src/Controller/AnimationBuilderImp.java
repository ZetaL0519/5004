package Controller;

import Model.IShapeModel;
import Model.ShapeModel;

/**
 * This is the implementation calss for AnimationBuilder.
 */
public class AnimationBuilderImp implements AnimationBuilder<IShapeModel> {
  private IShapeModel model = new ShapeModel();

  /**
   * build model function.
   * @return shape model
   */
  public IShapeModel build() {
    return model;
  }

  /**
   * createShape method.
   * @param name Shape name
   * @param type Shape type
   * @param x Shape x-coordinate
   * @param y Shape y-coordinate
   * @param width shape width
   * @param height shape height
   * @param r Color R value
   * @param g Color G value
   * @param b Color B value
   * @return shape model
   */
  @Override
  public AnimationBuilder<IShapeModel> createShape(String name, String type,
                                                   int x, int y, int width, int height, int r, int g, int b) {
    this.model.CreateShape(name, type, x, y, width, height, r, g, b);
    return this;
  }

  /**
   * Move shape method.
   * @param name Shape name
   * @param newX new x-coordinate
   * @param newY new y-coordinate
   * @return model
   */
  @Override
  public AnimationBuilder<IShapeModel> MoveShape(String name, int newX, int newY) {
    this.model.ChangePos(name, newX, newY);
    return this;
  }

  /**
   * Remove Shape method.
   * @param name shape name
   * @return model
   */
  @Override
  public AnimationBuilder<IShapeModel> RemoveShape(String name) {
    this.model.removeShape(name);
    return this;
  }

  /**
   * Resize shape method.
   * @param name shape name
   * @param newW new width
   * @param newH new height
   * @return model
   */
  @Override
  public AnimationBuilder<IShapeModel> ResizeShape(String name, int newW, int newH) {
    this.model.Resize(name, newW, newH);
    return this;
  }

  /**
   * Change shape color method.
   * @param name shape name
   * @param newR shape Color R value
   * @param newG shape Color G value
   * @param newB shape Color B value
   * @return model
   */
  @Override
  public AnimationBuilder<IShapeModel> ColorShape(String name, int newR, int newG, int newB) {
    this.model.ChangeColor(name, newR, newG, newB);
    return this;
  }

  /**
   * SnapShot method
   * @param Description snapshot description
   * @return model
   */
  @Override
  public AnimationBuilder<IShapeModel> SnapShot(String Description) {
    if (Description == null) {
      Description = "";
    }
    this.model.SnapShot(Description);
    return this;
  }
}
