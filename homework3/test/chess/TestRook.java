package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUNIT test class for Rook class.
 */
public class TestRook {
  private Rook Rook1;

  /**
   * Construct and initialize a rook object.
   */
  @Before
  public void SetUp() {
    Rook1 = new Rook(0, 5, Color.WHITE);
  }

  /**
   * Test Bad rook objects in which their row and column are out of range.
   */
  @Test
  public void testBadRook() {
    try {
      Rook Rook2 = new Rook(-1, 1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRook caught") + e.getMessage());
    }

    try {
      Rook Rook2 = new Rook(1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRook caught") + e.getMessage());
    }
  }

  /**
   * Test GetRow method.
   */
  @Test
  public void testGetRow() {
    Assert.assertEquals(0, Rook1.getRow());
  }

  /**
   * Test GetColumn method.
   */
  @Test
  public void testGetColumn() {
    Assert.assertEquals(5, Rook1.getColumn());
  }

  /**
   * Test GetColor method.
   */
  @Test
  public void testGetColor() {
    Assert.assertEquals(Color.WHITE, Rook1.getColor());
  }

  /**
   * Test canMove method of Rook object.
   */
  @Test
  public void testCanMove() {
    // cannot stay in the same place.
    Assert.assertFalse(Rook1.canMove(0, 5));

    // out of range.
    Assert.assertFalse(Rook1.canMove(8, 3));

    // random cant-move spot.
    Assert.assertFalse(Rook1.canMove(4, 3));

    // can move spot.
    Assert.assertTrue(Rook1.canMove(0, 3));
    Assert.assertTrue(Rook1.canMove(4, 5));
  }

  /**
   * Test canKill method of Bishop object.
   */
  @Test
  public void testCanKill() {
    // Cannot kill same color piece.
    Rook Rook2 = new Rook(2,4, Color.WHITE);
    Assert.assertFalse(Rook1.canKill(Rook2));

    // Cannot kill pieces where it can't move.
    Rook Rook3 = new Rook(4, 4, Color.BLACK);
    Assert.assertFalse(Rook1.canKill(Rook3));

    //Can kill.
    Rook Rook4 = new Rook(0, 3, Color.BLACK);
    Assert.assertTrue(Rook1.canKill(Rook4));
  }
}
