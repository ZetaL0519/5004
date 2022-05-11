import org.junit.Test;

import java.io.StringReader;

import Model.ShapeController;
import Model.ShapeModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is test class for Shape Album
 */
public class ShapeAlbumTest {
  /**
   * Test add wrong type shape object.
   */
  @Test
  public void testInvalidAddType() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o orangev oval 1 2 3 4 5 6 7 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Type does not exist.Please enter again.\n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (1.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }

  /**
   * Test Add illegal coordinate.
   */
  @Test
  public void TestInvalidAddCoordinate() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval how 2 2 3 4 5 6 7 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Number invalid.Please enter again.\n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());

    // test double number
    ShapeModel m2 = new ShapeModel();
    StringBuilder gameLog2 = new StringBuilder();
    ShapeController c2 = new ShapeController(new StringReader("add o oval 2.7 2 3 4 5 6 7 quit"), gameLog2);
    c2.ShapeGame(m2);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.7,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog2.toString());
  }

  /**
   * Test add illegal size number.
   */
  @Test
  public void TestInvalidAddSize() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 e 3 4 5 6 7 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Number invalid.Please enter again.\n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());

    ShapeModel m1 = new ShapeModel();
    StringBuilder gameLog1 = new StringBuilder();
    ShapeController c1 = new ShapeController(new StringReader("add o oval 2 2 3 -8 4 5 6 7 quit"), gameLog1);
    c1.ShapeGame(m1);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Number negative.Please enter again.\n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog1.toString());
  }

  /**
   * Test add illegal color number.
   */
  @Test
  public void TestInvalidAddColor() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 365 5 6 7 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());

    ShapeModel m1 = new ShapeModel();
    StringBuilder gameLog1 = new StringBuilder();
    ShapeController c1 = new ShapeController(new StringReader("add o oval 2 2 3 4 5 -8 0 6 7 quit"), gameLog1);
    c1.ShapeGame(m1);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }

  /**
   * Test add object that already exists in the list.
   */
  @Test
  public void TestAddRepeat() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 5 6 7 add o o2 oval 3 4 5 6 7 8 9 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Name already exists.Please enter again. \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "Name: o2\n" +
            "Type: oval\n" +
            "Center: (3.0,4.0), X radius: 5.0, Y radius: 6.0, Color: (7.0,8.0,9.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }

  /**
   * Test remove non-exist object.
   */
  @Test
  public void TestInvalidRemove() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 365 5 6 7 remove joe o quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Shape does not exist. Please enter again.\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }

  /**
   * Test Invalid move including non-exist object and illegal number
   */
  @Test
  public void TestInvalidMove() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 365 5 6 7 move joe o 3 4 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Shape does not exist. Please enter again.\n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Shape position changed \n" +
            "Name: o\n" + "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());

    // illegal parameter
    ShapeModel m1 = new ShapeModel();
    StringBuilder gameLog1 = new StringBuilder();
    ShapeController c1 = new ShapeController(new StringReader("add o oval 2 2 3 4 5 6 7 move o 3 e 4 quit"), gameLog1);
    c1.ShapeGame(m1);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Number invalid.Please enter again.\n" +
            "Shape position changed \n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog1.toString());
  }

  /**
   * Test Invalid Resize, including non-exist object and illegal number.
   */
  @Test
  public void TestInvalidResize() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 365 5 6 7 resize joe o 3 -1 4 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Shape does not exist. Please enter again.\n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Number negative.Please enter again.\n" +
            "Shape size changed \n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }

  /**
   * Test invalid change color, including non-exist object and invalid color value.
   */
  @Test
  public void TestInvalidColor() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 365 5 6 7 color joe o 278 200 -1 0 fr 4 quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Shape does not exist. Please enter again.\n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color B Value: \n" +
            "Number invalid.Please enter again.\n" +
            "Shape Color changed \n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }

  /**
   * Test SnapShot and print snapshot method.
   */
  @Test
  public void TestSnapShot() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 365 5 6 7 snapshot first print quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Number out of range.Please enter again.\n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Add Description to SnapShot: This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            m.printSnapShotList() + "\n" +
            "Printing SnapShot List\n" +
            m.printSnapShapeList() + "\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit",gameLog.toString());
  }

  /**
   * Test reset method.
   */
  @Test
  public void TestReset() {
    ShapeModel m = new ShapeModel();
    StringBuilder gameLog = new StringBuilder();
    ShapeController c = new ShapeController(new StringReader("add o oval 2 2 3 4 5 6 7 snapshot first reset print quit"), gameLog);
    c.ShapeGame(m);
    assertEquals("This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Enter Shape name: \n" +
            "Enter Shape type (Oval/Rectangle): \n" +
            "Enter Shape position X-Coordinate: \n" +
            "Enter Shape position Y-Coordinate: \n" +
            "Enter Shape size one: \n" +
            "Enter Shape size two: \n" +
            "Enter Shape Color R Value: \n" +
            "Enter Shape Color G Value: \n" +
            "Enter Shape Color B Value: \n" +
            "Shape added\n" +
            "Name: o\n" +
            "Type: oval\n" +
            "Center: (2.0,2.0), X radius: 3.0, Y radius: 4.0, Color: (5.0,6.0,7.0)\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Add Description to SnapShot: This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo Album reset\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "List of SnapShot taken before reset: \n" +
            "[]\n" +
            "Printing SnapShot List\n" +
            "\n" +
            "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)\n" +
            "Photo album quit", gameLog.toString());
  }
}
