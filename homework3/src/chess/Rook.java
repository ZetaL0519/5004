package chess;

/**
 * This is a Rook chess piece class.It inherits getter and constructor function from AbstractChess.
 */
public class Rook extends AbstractChess implements ChessPiece {
  private int x;
  private int y;
  private Color color;

  /**
   * Rook piece constructor which inherits from AbstractChess.
   *
   * @param x     initial row number of the chess.
   * @param y     initial column number of the chess.
   * @param color color of the chess.
   */
  public Rook(int x, int y, Color color) {
    super(x, y, color);
  }

  /**
   * This is a canMove method for Rook.
   * A rook can move horizontally or vertically.
   *
   * @param row row of the position.
   * @param col column of the position.
   * @return true if it can move to the place.
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
    // horizontal or vertical
    if (getRow() == row || getColumn() == col) {
      return true;
    }
    return false;
  }
}

