package Model;

import java.io.InputStreamReader;

/**
 * This is the main function.
 */
public class Main {
  public static void main(String[] args) {
    new ShapeController(new InputStreamReader(System.in),
            System.out).ShapeGame(new ShapeModel());
  }
}
