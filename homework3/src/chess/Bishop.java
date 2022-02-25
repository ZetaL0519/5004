package chess;

/**
 * This is a Bishop chess piece class.
 * It inherits getter and constructor function from AbstractChess.
 */
public class Bishop extends AbstractChess implements ChessPiece {
  private int x;
  private int y;
  private Color color;

  /**
   * Bishop piece constructor which inherits from AbstractChess.
   *     @param x initial row number of the chess.
   *     @param y initial column number of the chess.
   *     @param color color of the chess.
   */
  public Bishop(int x, int y, Color color) {
    super(x, y, color);
  }

  /**
   * This is a canMove method for bishop.
   *  A bishop can only move diagonally.
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
    // Bishop moves diagonally.
    if (Math.abs(getRow() - row) == Math.abs(getColumn() - col)) {
      return true;
    }
    return false;
  }
}
