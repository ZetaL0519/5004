package chess;

/**
 * This is an abstract class for Chess Piece.
 */
public class AbstractChess implements ChessPiece {
  protected int x;
  protected int y;
  protected Color color;

  /**
   * This is a constructor for abstract chess object.
   *     @param x row number for the chess piece.
   *     @param y column number for the chess piece.
   *     @param color color of the chess piece.
   *     throw IllegalArgumentException if row or column number out of range.
   */
  public AbstractChess(int x, int y, Color color) throws IllegalArgumentException {
    if (x < 0 || x > 7 || y < 0 || y > 7) {
      throw new IllegalArgumentException("Chess piece has to be in the range of 0-7");
    }
    this.x = x;
    this.y = y;
    this.color = color;
  }

  /**
   * This is a getter method for row.
   *  @return int x Row number.
   */
  public int getRow() {
    return x;
  }

  /**
   * This is a getter method for Column.
   *   @return int y Column number.
   */
  public int getColumn() {
    return y;
  }

  /**
   * This is a getter method for Color.
   *    @return Color.
   */
  public Color getColor() {
    return color;
  }

  /**
   * This is mainly a place holding method for canMove method.
   *     @param row row of the position.
   *     @param col column of the position.
   *     @return default false.
   */
  public boolean canMove(int row, int col) {
    return false;
  }

  /**
   * This is a canKill method.
   * It can kill any opponent’s piece if it can move to its place.
   *     @param piece Another ChessPiece object.
   *     @return true if it can move to the place and piece has different color than queen.
   */
  public boolean canKill(ChessPiece piece) {
    if (canMove(piece.getRow(), piece.getColumn())
            && piece.getColor() != getColor()) {
      return true;
    }
    return false;
  }
}
