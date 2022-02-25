package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUNIT test class for Knight class.
 */
public class TestKnight {
  private Knight Knight;

  /**
   * Construct and initialize a knight object.
   */
  @Before
  public void SetUp() {
    Knight = new Knight(0, 2, Color.BLACK);
  }

  /**
   * Test Bad Knight object in which their row and column are out of range.
   */
  @Test
  public void testBadKnight() {
    try {
      Knight Knight2 = new Knight(-1, 1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadKnight caught") + e.getMessage());
    }

    try {
      Knight Knight2 = new Knight(1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadKnight caught") + e.getMessage());
    }
  }

  /**
   * Test GetRow method.
   */
  @Test
  public void testGetRow() {
    Assert.assertEquals(0, Knight.getRow());
  }

  /**
   * Test GetColumn method.
   */
  @Test
  public void testGetColumn() {
    Assert.assertEquals(2, Knight.getColumn());
  }

  /**
   * Test GetColor method.
   */
  @Test
  public void testGetColor() {
    Assert.assertEquals(Color.BLACK, Knight.getColor());
  }

  /**
   * Test canMove method of Knight object.
   */
  @Test
  public void testCanMove() {
    // cannot stay in the same place.
    Assert.assertFalse(Knight.canMove(0, 2));

    // out of range.
    Assert.assertFalse(Knight.canMove(8, 3));

    // random cant-move spot.
    Assert.assertFalse(Knight.canMove(4, 5));

    // can move spot.
    Assert.assertTrue(Knight.canMove(1, 4));
    Assert.assertTrue(Knight.canMove(2, 3));
  }

  /**
   * Test canKill method of Knight object.
   */
  @Test
  public void testCanKill() {
    // Cannot kill same color piece.
    Knight Knight2 = new Knight(2,4, Color.BLACK);
    Assert.assertFalse(Knight.canKill(Knight2));

    // Cannot kill pieces where it can't move.
    Knight Knight3 = new Knight(3, 5, Color.WHITE);
    Assert.assertFalse(Knight.canKill(Knight3));

    //Can kill.
    Knight Knight4 = new Knight(1, 4, Color.WHITE);
    Assert.assertTrue(Knight.canKill(Knight4));
    Knight Knight5 = new Knight(2, 3, Color.WHITE);
    Assert.assertTrue(Knight.canKill(Knight5));
  }
}
