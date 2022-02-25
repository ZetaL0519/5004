package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUNIT test class for Queen class.
 */
public class TestQueen {
  private Queen Queen1;

  /**
   * Construct and initialize a queen object.
   */
  @Before
  public void SetUp() {
    Queen1 = new Queen(0, 6, Color.WHITE);
  }

  /**
   * Test Bad Queen objects in which their row and column are out of range.
   */
  @Test
  public void testBadQueen() {
    try {
      Queen Queen2 = new Queen(-1, 1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadQueen caught") + e.getMessage());
    }

    try {
      Queen Queen2 = new Queen(1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadQueen caught") + e.getMessage());
    }
  }

  /**
   * Test GetRow method.
   */
  @Test
  public void testGetRow() {
    Assert.assertEquals(0, Queen1.getRow());
  }

  /**
   * Test GetColumn method.
   */
  @Test
  public void testGetColumn() {
    Assert.assertEquals(6, Queen1.getColumn());
  }

  /**
   * Test GetColor method.
   */
  @Test
  public void testGetColor() {
    Assert.assertEquals(Color.WHITE, Queen1.getColor());
  }

  /**
   * Test canMove method of Queen object.
   */
  @Test
  public void testCanMove() {
    // cannot stay in the same place.
    Assert.assertFalse(Queen1.canMove(0, 6));

    // out of range.
    Assert.assertFalse(Queen1.canMove(8, 3));

    // random cant-move spot.
    Assert.assertFalse(Queen1.canMove(4, 5));

    // can move spot.
    Assert.assertTrue(Queen1.canMove(0, 4));
    Assert.assertTrue(Queen1.canMove(7, 6));
    Assert.assertTrue(Queen1.canMove(1, 5));
  }

  /**
   * Test canKill method of Queen object.
   */
  @Test
  public void testCanKill() {
    // Cannot kill same color piece.
    Queen Queen2 = new Queen(2,4, Color.WHITE);
    Assert.assertFalse(Queen1.canKill(Queen2));

    // Cannot kill pieces where it can't move.
    Queen Queen3 = new Queen(0, 6, Color.BLACK);
    Assert.assertFalse(Queen1.canKill(Queen3));

    //Can kill.
    Queen Queen4 = new Queen(1, 5, Color.BLACK);
    Assert.assertTrue(Queen1.canKill(Queen4));
  }
}
