package swing;

import java.awt.*;

import javax.swing.*;

public class PaintExample extends JFrame {
  public static final int WIDTH = 400;
  public static final int HEIGHT = 400;

  public PaintExample() {
    this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("cs5004 paint on panel");
    this.setLayout(new GridLayout(2, 1));
    DrawPanel drawPanel = new DrawPanel();
    this.add(drawPanel);

    // Make a regular JPanel and add that too
    JPanel blackPanel = new JPanel();
    blackPanel.setBackground(Color.BLACK);
    this.add(blackPanel);
  }
  public static void main(String [] args) {
    PaintExample window = new PaintExample();
    window.setVisible(true);
  }
}

class DrawPanel extends JPanel {
  public void paintComponent(Graphics g ) {
    super.paintComponent(g);
    setBackground(Color.ORANGE);
    g.drawOval(PaintExample.WIDTH/4, PaintExample.HEIGHT/4,
                PaintExample.WIDTH/2, PaintExample.HEIGHT/6);
    g.setColor(Color.blue);
    g.fillOval(PaintExample.WIDTH/4, PaintExample.HEIGHT/4,
            PaintExample.WIDTH/2, PaintExample.HEIGHT/6);
  }
}
