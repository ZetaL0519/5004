import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Model.IShapeModel;
import Model.ShapeModel;
import View.GraphicView;
import Controller.AnimationBuilderImp;
import Controller.AnimationReader;
import View.WebView;

/**
 * This is a test main class without running command line.
 */
public class Main {
  /**
   * Driver method.
   * @param args argument passed in
   */
  public static void main(String[] args) {

    File file = new File("C:\\Users\\lisiy\\Desktop\\neu\\5004\\homework9\\buildings.txt");
    IShapeModel m = new ShapeModel();
    try {
      m = AnimationReader.ParseFile(new BufferedReader(
              new FileReader(file)), new AnimationBuilderImp());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    GraphicView gui = new GraphicView(m, 1000, 1000);
    gui.display();

    WebView view = new WebView(m, 1000, 1000);
    view.display();
    view.saveSVG("demo.html");
  }
}
