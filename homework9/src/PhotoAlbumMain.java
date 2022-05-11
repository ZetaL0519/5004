import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import javax.swing.*;

import Controller.AnimationGraphicController;
import Controller.AnimationWebController;
import Controller.IAnimationController;
import Model.IShapeModel;
import Model.ShapeModel;
import Controller.AnimationBuilderImp;
import Controller.AnimationReader;

/**
 * This is the Main class for running the Photo album in view and web mode.
 */
public class PhotoAlbumMain {
  /**
   * This is the main method that takes in the command line.
   * @param args command line
   * @throws IllegalArgumentException if there exists illegal parameters.
   */
  public static void main(String[] args) throws IllegalArgumentException {
    IShapeModel model = new ShapeModel();
    String typeOfView = "";
    String output = "";
    Readable in = new StringReader("");
    int width = 1000;
    int height = 1000;

    for (int i = 0; i < args.length; i ++) {
      if (args[i].equals("-in")) {
        try {
          in = new FileReader(args[i + 1]);
        }
        catch (FileNotFoundException e) {
          popUpError("------ Error: File not found");
        }
        catch (IndexOutOfBoundsException e) {
          popUpError("------ Error: File not specified");
        }
      }

      if (args[i].equals("-v") || args[i].equals("-view")) {
        try {
          typeOfView = args[i + 1];
        }
        catch (IndexOutOfBoundsException e) {
          popUpError("------ Error: View not specified");
        }
      }

      if (args[i].equals("-out")) {
        try {
          output = args[i + 1];
        } catch (IndexOutOfBoundsException e) {
          popUpError("------ Error: Output file not defined.");
        }
      }

      try {
        width = Integer.parseInt(args[i]);
        height = Integer.parseInt(args[i]);
      } catch (Exception ignored) {}
    }

    try {
      model = AnimationReader.ParseFile(in, new AnimationBuilderImp());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(new JFrame(), "Cannot read the file");
      System.exit(0);
    }

    switch (typeOfView) {
      case "web":
        IAnimationController webController = new AnimationWebController(output, model);
        webController.display(width, height);
        break;
      case "graphical":
        IAnimationController graphController = new AnimationGraphicController(model);
        graphController.display(width, height);
        break;
      default:
        popUpError("------ Error: Invalid view choice.");
    }

  }

  /**
   * If there exists invalid input, pop up dialogue box.
   * @param message messages for different invalid inputs
   */
  private static void popUpError(String message) {
    JOptionPane.showMessageDialog(null, message,
            "------ Animation Error: An error occurred", JOptionPane.ERROR_MESSAGE);
    System.exit(1);
  }
}
