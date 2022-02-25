package chess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUNIT test class for Pawn class.
 */
public class TestPawn {
  private Pawn Pawn1;

  /**
   * Construct and initialize a pawn object.
   */
  @Before
  public void SetUp() {
    Pawn1 = new Pawn(1, 3, Color.WHITE);
  }

  /**
   * Test Bad pawn objects in which their row and column are out of range.
   */
  @Test
  public void testBadPawn() {
    try {
      Pawn Pawn2 = new Pawn(-1, 1, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadPawn caught") + e.getMessage());
    }

    try {
      Pawn Pawn2 = new Pawn(1, 8, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadPawn caught") + e.getMessage());
    }

    try {
      Pawn Pawn2 = new Pawn(1, 4, Color.BLACK);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadPawn caught") + e.getMessage());
    }

    try {
      Pawn Pawn2 = new Pawn(4, 4, Color.WHITE);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadPawn caught") + e.getMessage());
    }
  }

  /**
   * Test GetRow method.
   */
  @Test
  public void testGetRow() {
    Assert.assertEquals(1, Pawn1.getRow());
  }

  /**
   * Test GetColumn method.
   */
  @Test
  public void testGetColumn() {
    Assert.assertEquals(3, Pawn1.getColumn());
  }

  /**
   * Test GetColor method.
   */
  @Test
  public void testGetColor() {
    Assert.assertEquals(Color.WHITE, Pawn1.getColor());
  }

  /**
   * Test canMove method of pawn object.
   */
  @Test
  public void testCanMove() {
    // cannot stay in the same place.
    Assert.assertFalse(Pawn1.canMove(1, 3));

    // out of range.
    Assert.assertFalse(Pawn1.canMove(8, 3));

    // random cant-move spot.
    Assert.assertFalse(Pawn1.canMove(2, 4));

    // can move spot first move
    Assert.assertTrue(Pawn1.canMove(2, 3));
    Assert.assertTrue(Pawn1.canMove(3, 3));

    // can move spot second move
    Pawn Pawn2 = new Pawn(4, 4, Color.BLACK);
    Assert.assertTrue(Pawn2.canMove(3, 4));
    Assert.assertFalse(Pawn2.canMove(2, 4));
  }

  /**
   * Test canKill method of pawn object.
   */
  @Test
  public void testCanKill() {
    // Cannot kill same color piece.
    Pawn Pawn2 = new Pawn(2,4, Color.WHITE);
    Assert.assertFalse(Pawn1.canKill(Pawn2));

    // Cannot kill pieces on the same row or col.
    Pawn Pawn3 = new Pawn(2, 3, Color.BLACK);
    Assert.assertFalse(Pawn1.canKill(Pawn3));

    //Can kill.
    Pawn Pawn4 = new Pawn(2, 2, Color.BLACK);
    Assert.assertTrue(Pawn1.canKill(Pawn4));
    Pawn Pawn5 = new Pawn(2, 4, Color.BLACK);
    Assert.assertTrue(Pawn1.canKill(Pawn4));
  }
}
