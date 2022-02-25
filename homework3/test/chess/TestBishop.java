package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUNIT test class for Bishop class.
 */
public class TestBishop {
  private Bishop bishop1;

  /**
   * Construct and initialize a bishop object.
   */
  @Before
  public void SetUp() {
    bishop1 = new Bishop(0, 3, Color.WHITE);
  }

  /**
   * Test Bad Bishop objects in which their row and column are out of range.
   */
  @Test
  public void testBadBishop() {
    try {
      Bishop bishop2 = new Bishop(-1, 1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadBishop caught") + e.getMessage());
    }

    try {
      Bishop bishop2 = new Bishop(1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadBishop caught") + e.getMessage());
    }
  }

  /**
   * Test GetRow method.
   */
  @Test
  public void testGetRow() {
    Assert.assertEquals(0, bishop1.getRow());
  }

  /**
   * Test GetColumn method.
   */
  @Test
  public void testGetColumn() {
    Assert.assertEquals(3, bishop1.getColumn());
  }

  /**
   * Test GetColor method.
   */
  @Test
  public void testGetColor() {
    Assert.assertEquals(Color.WHITE, bishop1.getColor());
  }

  /**
   * Test canMove method of Bishop object.
   */
  @Test
  public void testCanMove() {
    // cannot stay in the same place.
    Assert.assertFalse(bishop1.canMove(0, 3));

    // out of range.
    Assert.assertFalse(bishop1.canMove(8, 3));

    // random cant-move spot.
    Assert.assertFalse(bishop1.canMove(4, 5));

    // can move spot.
    Assert.assertTrue(bishop1.canMove(1, 4));
  }

  /**
   * Test canKill method of Bishop object.
   */
  @Test
  public void testCanKill() {
    // Cannot kill same color piece.
    Bishop bishop2 = new Bishop(2,4, Color.WHITE);
    Assert.assertFalse(bishop1.canKill(bishop2));

    // Cannot kill pieces where it can't move.
    Bishop bishop3 = new Bishop(3, 5, Color.BLACK);
    Assert.assertFalse(bishop1.canKill(bishop3));

    //Can kill.
    Bishop bishop4 = new Bishop(1, 2, Color.BLACK);
    Assert.assertTrue(bishop1.canKill(bishop4));
  }
}
