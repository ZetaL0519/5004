package View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Model.IShapeModel;
import Model.SnapShot;
import Shape.IShape;

/**
 * This is the WebView class.
 */
public class WebView implements IView{
  private IShapeModel model;
  private List<SnapShot> snapShotList;
  private int width;
  private int height;
  Appendable output;

  /**
   * Constructor for WebView.
   * @param model shape model
   * @param width canvas width
   * @param height canvas height
   */
  public WebView(IShapeModel model, int width, int height) {
    this.model = model;
    this.width = width;
    this.height = height;
    this.snapShotList = model.getSnapshotList();
    output = new StringBuilder();
  }

  /**
   * Display snapshot in web svg.
   */
  public void display() {
    try {
      output.append("<!DOCTYPE html>\n" +
              "<html>\n" +
              "<body>\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (SnapShot snapShot: snapShotList) {
      try {
        drawSVG(snapShot);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      output.append("</body>\n" +
              "</html>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Draw images for one single snapshot.
   * @param snapShot Snapshot object
   * @throws IOException
   * If appendable cannot work, throw exception.
   */
  public void drawSVG(SnapShot snapShot) throws IOException {
    if (snapShot == null) {
      return;
    }

    output.append("<svg width=\"" + this.width + "\" height=\""
            + this.height + "\" version=\"1.1\""
            + "style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n");
    output.append("<g>");

    String description = snapShot.getDescription();
    String SnapID = snapShot.getSnapShotID();
    List<IShape> shapeList = snapShot.getShapeList();
    for (IShape shape: shapeList) {
      String shapeType;
      String initialization;

      switch (shape.getType()) {
        case("Rectangle"):
          shapeType = "rect";
          initialization = "<%s id=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" "
                  + "height=\"%.2f\" fill=\"rgb(%f,%f,%f)\" visibility=\"visible\" /> \n";
          initialization = String.format(initialization,
                  shapeType, shape.getName(), shape.getPosition().getX(),
                  shape.getPosition().getY() + 200, shape.getSize()[0],
                  shape.getSize()[1],
                  shape.getColor().getR(), shape.getColor().getG(),
                  shape.getColor().getB());

          break;
        case ("Oval"):
          shapeType = "ellipse";
          initialization = "<%s id=\"%s\" cx=\"%.2f\" cy=\"%.2f\" rx=\"%.2f\" ry=\"%.2f\" "
                  + "fill=\"rgb(%f,%f,%f)\" visibility=\"visible\"/> \n";
          initialization = String.format(initialization,
                  shapeType, shape.getName(), shape.getPosition().getX(),
                  shape.getPosition().getY() + 200, shape.getSize()[0] / 2,
                  shape.getSize()[1] / 2,
                  shape.getColor().getR(), shape.getColor().getG(),
                  shape.getColor().getB());

          break;
        default:
          throw new IllegalStateException("No such shape");
      }
      output.append(initialization);
    }
    output.append("<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" +  SnapID + "</text>\n" );
    output.append("<text x=\"10\" y=\"70\" font-size=\"20\">" + "Description: " +description + "</text>\n");
    output.append("</g>");
    output.append("</svg>\n" + "<p></p>\n");
  }

  /**
   * Save text to HTML file.
   * @param filePath filepath and name
   */
  public void saveSVG(String filePath) {
    try {
      FileWriter writer = new FileWriter(filePath);
      writer.write(this.output.toString());
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Get the output in text form.
   * @return String form of text
   */
  public String getOutput() {
    return this.output.toString();
  }
}
