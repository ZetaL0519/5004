package chess;

/**
 * This is a Queen chess piece class.It inherits getter and constructor function from AbstractChess.
 */
public class Queen extends AbstractChess implements ChessPiece {
  private int x;
  private int y;
  private Color color;

  /**
   * Queen piece constructor which inherits from AbstractChess.
   *
   * @param x     initial row number of the chess.
   * @param y     initial column number of the chess.
   * @param color color of the chess.
   */
  public Queen(int x, int y, Color color) {
    super(x, y, color);
  }

  /**
   * This is a canMove method for queen.
   * A queen can move horizontally, vertically and diagonally.
   *
   * @param row row of the position.
   * @param col column of the position.
   * @return true if the queen can move to the place.
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
    // if queen can move diagonally.
    if (Math.abs(getRow() - row) == Math.abs(getColumn() - col)) {
      return true;
    }
    // if queen can move horizontally.
    if (row == getRow() && col != getColumn()) {
      return true;
    }
    // if queen can move vertically.
    if (row != getRow() && col == getColumn()) {
      return true;
    }
    return false;
  }
}
