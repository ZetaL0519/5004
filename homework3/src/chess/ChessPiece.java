package chess;

/**
 * This interface represents a chess piece. It is the super-type,
 * for any other type of chess piece a game might offer.
 */
public interface ChessPiece {
  /**
   * This is a getter method for row.
   *  @return Row.
   */
  int getRow();

  /**
   * This is a getter method for Column.
   *   @return column.
   */
  int getColumn();

  /**
   * This is a getter method for Color.
   *    @return Color.
   */
  Color getColor();

  /**
   * This is a method which judges whether a chess piece can move to a certain spot.
   *     @param row row of the position.
   *     @param col column of the position.
   *     @return boolean. If it can move, return true.
   */
  boolean canMove(int row, int col);

  /**
   * This is a method which judges whether a chess piece can kill another piece.
   *     @param piece Another ChessPiece object.
   *     @return boolean if the chess can kill, return true.
   */
  boolean canKill(ChessPiece piece);
}
