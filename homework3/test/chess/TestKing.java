package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUNIT test class for Bishop class.
 */
public class TestKing {
  private King King1;

  /**
   * Construct and initialize a king object.
   */
  @Before
  public void SetUp() {
    King1 = new King(0, 4, Color.WHITE);
  }

  /**
   * Test Bad King object in which their row and column are out of range.
   */
  @Test
  public void testBadKing() {
    try {
      King King2 = new King(-1, 1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadKing caught") + e.getMessage());
    }

    try {
      King King2 = new King(1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadKing caught") + e.getMessage());
    }
  }

  /**
   * Test GetRow method.
   */
  @Test
  public void testGetRow() {
    Assert.assertEquals(0, King1.getRow());
  }

  /**
   * Test GetColumn method.
   */
  @Test
  public void testGetColumn() {
    Assert.assertEquals(4, King1.getColumn());
  }

  /**
   * Test GetColor method.
   */
  @Test
  public void testGetColor() {
    Assert.assertEquals(Color.WHITE, King1.getColor());
  }

  /**
   * Test canMove method of King object.
   */
  @Test
  public void testCanMove() {
    // cannot stay in the same place.
    Assert.assertFalse(King1.canMove(0, 4));

    // out of range.
    Assert.assertFalse(King1.canMove(8, 3));

    // random cant-move spot.
    Assert.assertFalse(King1.canMove(4, 5));

    // can move spot.
    Assert.assertTrue(King1.canMove(1, 5));
  }

  /**
   * Test canKill method of King object.
   */
  @Test
  public void testCanKill() {
    // Cannot kill same color piece.
    King King2 = new King(2,4, Color.WHITE);
    Assert.assertFalse(King1.canKill(King2));

    // Cannot kill pieces where it can't move.
    King King3 = new King(3, 5, Color.BLACK);
    Assert.assertFalse(King1.canKill(King3));

    //Can kill.
    King King4 = new King(1, 5, Color.BLACK);
    Assert.assertTrue(King1.canKill(King4));
  }
}
