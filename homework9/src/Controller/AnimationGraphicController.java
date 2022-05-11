package Controller;

import Model.IShapeModel;
import View.GraphicView;

/**
 * This is animation graphic controller.
 */
public class AnimationGraphicController implements IAnimationController {
  private IShapeModel model;
  private GraphicView graphicView;

  /**
   * Constructor for graphic controller.
   * @param model shape model
   */
  public AnimationGraphicController(IShapeModel model) {
    this.model = model;
  }

  /**
   * display graphic view.
   * @param width canvas width
   * @param height canvas height
   */
  @Override
  public void display(int width, int height) {
    graphicView = new GraphicView(model, width, height);
    graphicView.display();
  }
}
