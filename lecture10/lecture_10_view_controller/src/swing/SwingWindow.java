package swing;

import javax.swing.JFrame;
import javax.swing.JButton;

public class SwingWindow {
  public static final int WIDTH = 300;
  public static final int HEIGHT = 200;

  public static void main(String [] args ) {
    JFrame myWindow = new JFrame();
    myWindow.setSize(WIDTH, HEIGHT);

    myWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ignore the x button in window

    JButton endButton = new JButton("Click here to end");
    MyCloseListener listener = new MyCloseListener(); // listen for events
    endButton.addActionListener(listener);  // callback when button is clicked
    myWindow.add(endButton);
    myWindow.setVisible(true); // show the window
  }
}
