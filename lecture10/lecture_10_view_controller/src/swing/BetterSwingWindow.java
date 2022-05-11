package swing;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BetterSwingWindow  extends JFrame { // swing typically works better with inheritance
  public static final int WIDTH = 300;
  public static final int HEIGHT = 200;

  public BetterSwingWindow() {
    super();
    super.setSize(WIDTH, HEIGHT);

    setTitle("CS5004 Window");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ignore the x button in window
    JButton endButton  = new JButton("Click here to end");
    endButton.addActionListener(new MyCloseListener());
    add(endButton);
  }
}
