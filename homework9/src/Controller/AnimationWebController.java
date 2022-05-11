package Controller;

import Model.IShapeModel;
import View.WebView;

/**
 * This is the animation web controller class.
 */
public class AnimationWebController implements IAnimationController{
  private IShapeModel model;
  private WebView webView;
  private String output;

  /**
   * Constructor for web controller.
   * @param output output file for web html
   * @param model shape model
   */
  public AnimationWebController(String output, IShapeModel model) {
    this.output = output;
    this.model = model;
  }

  /**
   * Display web page and save to SVG.
   * @param width canvas width
   * @param height canvas height
   */
  public void display(int width, int height) {
      webView = new WebView(model, width, height);
      webView.display();
      webView.saveSVG(this.output);
  }
}
