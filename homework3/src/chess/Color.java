package chess;

/**
 * This is an enum class for chess piece color.
 */
public enum Color {
  BLACK(1), WHITE(2);
  private int value;

  /**
   * This is the constructor for enum color.
   *    @param value value for black and white.
   */
  Color(int value) {
    this.value = value;
  }

  /**
   *  This is a getter method for value.
   *      @return value for color.
   */
  public int getValue() {
    return value;
  }
}
