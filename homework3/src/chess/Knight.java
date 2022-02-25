package chess;

/**
 * This is a Knight chess piece class.
 * It inherits getter and constructor function from AbstractChess.
 */
public class Knight extends AbstractChess implements ChessPiece {
  private int x;
  private int y;
  private Color color;

  /**
   * Knight piece constructor which inherits from AbstractChess.
   *     @param x initial row number of the chess.
   *     @param y initial column number of the chess.
   *     @param color color of the chess.
   */
  public Knight(int x, int y, Color color) {
    super(x, y, color);
  }

  /**
   * This is a canMove method for Knight.
   *  A knight can move only in an L pattern:
   *  two cells horizontally and one vertically or vice versa.
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
    if (1 == Math.abs(getRow() - row) && 2 == Math.abs(getColumn() - col)) {
      return true;
    }
    if (2 == Math.abs(getRow() - row) && 1 == Math.abs(getColumn() - col)) {
      return true;
    }
    return false;
  }

  /**
   * This is a canKill method for Knight.
   * It can kill any opponent’s piece if it can move to its place.
   *     @param piece Another ChessPiece object.
   *     @return true if it can move to the place and piece has different color than queen.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (canMove(piece.getRow(), piece.getColumn())
            && piece.getColor() != getColor()) {
      return true;
    }
    return false;
  }
}
