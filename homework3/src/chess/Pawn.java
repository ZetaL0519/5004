package chess;

/**
 * This is a Pawn chess piece class.It inherits getter and constructor function from AbstractChess.
 */
public class Pawn extends AbstractChess implements ChessPiece {
  private int x;
  private int y;
  private Color color;

  /**
   * Pawn piece constructor which inherits from AbstractChess.
   * Black pawn cannot start at row smaller than 1.
   * White pawn cannot start at row smaller than 6.
   *     @param x initial row number of the chess.
   *     @param y initial column number of the chess.
   *     @param color color of the chess.
   */
  public Pawn(int x, int y, Color color) throws IllegalArgumentException {
    super(x, y, color);
    if (color.getValue() == 2 && x < 1 ) {
      throw new IllegalArgumentException(" White Chess piece has to be in row < 1");
    }
    if (color.getValue() == 1 && x > 6 ) {
      throw new IllegalArgumentException(" Black Chess piece has to be in row > 6");
    }
  }

  /**
   * This is a canMove method for Pawn.
   *   It can move only one place forward in its own column,
   *   except for the first step, it can move up to 2 steps.
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

    // out of range
    if (row > 7 || row < 0 || col > 7 || col < 0) {
      return false;
    }

    if (getColor() == Color.WHITE && getRow() == 1) {
      if (col == getColumn() && row == (getRow()  + 1) ||  row == (getRow() + 2)) {
        return true;
      }
    }

    if (getColor() == Color.BLACK && getRow() == 6) {
      if (col == getColumn() && row == (getRow() - 1) ||  row == (getRow() - 2)) {
        return true;
      }
    }

    else if (getColumn() == col && row == (getRow() + 1) && getColor() == Color.WHITE) {
      return true;
    }

    else if (getColumn() == col && row == (getRow() - 1) && getColor() == Color.BLACK) {
      return true;
    }

    return false;
  }

  /**
   * This is a canKill method for Pawn.
   * to kill it must move one place forward diagonally
   *     @param piece Another ChessPiece object.
   *     @return true if it can move diagonally and piece has different color than queen.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (1 == Math.abs(piece.getColumn() - getColumn()) && piece.getRow() == getRow() + 1
            && piece.getColor() != getColor() && getColor() == Color.WHITE) {
      return true;
    }

    if (1 == Math.abs(piece.getColumn() - getColumn()) && piece.getRow() == getRow() - 1
            && piece.getColor() != getColor() && getColor() == Color.BLACK) {
      return true;
    }
    return false;
  }
}
