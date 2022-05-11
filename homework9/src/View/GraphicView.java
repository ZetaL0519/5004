package View;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import Model.IShapeModel;
import Model.SnapShot;

import javax.swing.*;

/**
 * This is GraphicView class.
 */
public class GraphicView extends JFrame implements IView {
  private IShapeModel model;
  private DrawingPanel drawingPanel;
  private JPanel MenuBar;
  private JPanel TopBar;
  private JLabel SnapLabel;
  private String[] SnapIDList;
  private List<SnapShot> snapShotList;
  private int index;

  /**
   * Constructor for Graphics View.
   * @param m IShapeModel
   * @param width width of the canvas
   * @param height height of the canvas
   */
  public GraphicView(IShapeModel m, int width, int height) {
    super();

    // Initialize all the parameters.
    snapShotList = m.getSnapshotList();
    SnapIDList = new String[snapShotList.size()];
    this.index = 0;
    this.model = m;

    // Pass SnapShotID to SnapID List
    for (int i = 0; i < snapShotList.size(); i ++) {
      SnapIDList[i] = snapShotList.get(i).getSnapShotID();
    }

    // Set canvas size and bg
    this.setSize(width, height);
    this.setLayout(new BorderLayout());
    this.setBackground(Color.orange);

    // Set up the main drawing panel
    drawingPanel = new DrawingPanel();
    drawingPanel.paintShapes(snapShotList.get(0).getShapeList());
    this.setPreferredSize(new Dimension(width, height - 200));
    this.add(drawingPanel, BorderLayout.CENTER);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Add Buttons to Menu Bar
    JButton Prev = new JButton("<< Prev <<");
    Prev.setActionCommand("Prev");

    JButton Select = new JButton("^^ Select ^^");
    Select.setActionCommand("Select");

    JButton Next = new JButton(">> Next >>");
    Next.setActionCommand("Next");

    JButton Quit = new JButton("XX Quit XX");
    Quit.setActionCommand("Quit");
    Quit.addActionListener(e -> System.exit(0));

    this.MenuBar = new JPanel(new FlowLayout());
    this.MenuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    this.MenuBar.setBackground(Color.ORANGE);
    this.MenuBar.add(Prev);
    this.MenuBar.add(Select);
    this.MenuBar.add(Next);
    this.MenuBar.add(Quit);

    this.add(this.MenuBar, BorderLayout.SOUTH);

    // Create top bar
    this.TopBar = new JPanel(new BorderLayout());
    this.TopBar.setBackground(Color.PINK);
    this.SnapLabel = new JLabel("<html><body>" + snapShotList.get(index).getSnapShotID() + "<br/>" +
            snapShotList.get(index).getDescription() + "<body></html>");
    this.TopBar.add(SnapLabel, BorderLayout.LINE_START);
    this.add(this.TopBar, BorderLayout.NORTH);

    Select.addActionListener(e -> {
      String s = (String)JOptionPane.showInputDialog(null, "Choose", "Choose", JOptionPane.PLAIN_MESSAGE,
              null, SnapIDList, SnapIDList[0]);

      index = Arrays.asList(SnapIDList).indexOf(s);

      drawingPanel.paintShapes(snapShotList.get(index).getShapeList());
      SnapLabel.setText("<html><body>" + snapShotList.get(index).getSnapShotID() + "<br/>" +
              snapShotList.get(index).getDescription() + "<body></html>");
    });

    Prev.addActionListener(e -> {
      if (index == 0) {
        JOptionPane.showMessageDialog(new JFrame(), "There is no previous picture.");
      } else {
        index -= 1;
        drawingPanel.paintShapes(snapShotList.get(index).getShapeList());
        SnapLabel.setText("<html><body>" + snapShotList.get(index).getSnapShotID() + "<br/>" +
                snapShotList.get(index).getDescription() + "<body></html>");
      }
    });


    Next.addActionListener(e -> {
      if (index == SnapIDList.length - 1) {
        JOptionPane.showMessageDialog(new JFrame(), "There is no next picture.");
      } else {
        index += 1;
        drawingPanel.paintShapes(snapShotList.get(index).getShapeList());
        SnapLabel.setText("<html><body>" + snapShotList.get(index).getSnapShotID() + "<br/>" +
                snapShotList.get(index).getDescription() + "<body></html>");
      }
    });

    this.pack();
  }

  /**
   * This is for displaying the graphic view.
   */
  public void display() {
        try {
          this.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
  }
}
