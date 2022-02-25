package chess;

/**
 * This is a King chess piece class.It inherits getter and constructor function from AbstractChess.
 */
public class King extends AbstractChess implements ChessPiece {
  private int x;
  private int y;
  private Color color;

  /**
   * King piece constructor which inherits from AbstractChess.
   *     @param x initial row number of the chess.
   *     @param y initial column number of the chess.
   *     @param color color of the chess.
   */
  public King(int x, int y, Color color) {
    super(x, y, color);
  }

  /**
   * This is a canMove method for King.
   *   they can only move one space at a time horizontally, vertically and diagonally.
   *     @param row row of the position.
   *     @param col column of the position.
   *     @return true if it can move to the place.
   */
  @Override
  public boolean canMove(int row, int col) {
    // cannot stay in the same place.
    if (row == getRow() && col == getColumn()) {
      return false;
    }
    // if row and col out of range, return false.
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }

    if (Math.abs(row - getRow()) <= 1 && Math.abs(col - getColumn()) <= 1) {
      return true;
    }
    return false;
  }
}
