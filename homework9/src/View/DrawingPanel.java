package View;

import Shape.IShape;
import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * This is the Drawing Panel class.
 */
public class DrawingPanel extends JPanel {
  private List<IShape> shapeList;

  /**
   * This is the paint shape method that paint the shape list.
   * @param shapeList List of IShape objects
   */
  public void paintShapes(List<IShape> shapeList) {
    this.shapeList = shapeList;
    this.repaint();
  }

  /**
   * Constructor for Drawing Panel.
   */
  public DrawingPanel() {
    super();
    this.setBackground(Color.WHITE);
  }

  /**
   * Teach the graphics how to draw oval and rectangle.
   * @param g Graphics object
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    if (this.shapeList == null) {
      return;
    }

    for (IShape shape: this.shapeList) {
      g2d.setColor(new Color((int) shape.getColor().getR(), (int) shape.getColor().getG()
              , (int) shape.getColor().getB()));
      switch (shape.getType()) {
        case ("Rectangle"):
          g2d.fillRect((int) shape.getPosition().getX(),
                  (int) shape.getPosition().getY(), (int) shape.getSize()[0], (int) shape.getSize()[1]);
          break;
        case ("Oval"):
          g2d.fillOval((int) shape.getPosition().getX(),
                  (int) shape.getPosition().getY(), (int) shape.getSize()[0], (int) shape.getSize()[1]);
          break;

        default:
          break;
      }
    }
  }
}
