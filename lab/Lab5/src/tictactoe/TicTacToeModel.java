package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implementation of TicTac game.
 */
public class TicTacToeModel implements TicTacToe {
  // add your implementation here
  private final Player[][] board;
  private int round;

  /**
   * Constructor for TicTacModel. Initialize the board.
   */
  public TicTacToeModel() {
    board = new Player[3][3];
    round = 1;
  }

  /**
   * Overriding toString method.
   * @return String.
   */
  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
  }

  /**
   * Execute a move in the position specified by the given row and column.
   * @param r the row of the intended move
   * @param c the column of the intended move
   * @throws IllegalArgumentException if the space is occupied or the position is otherwise invalid
   * @throws IllegalStateException if the game is over
   */
  @Override
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException {

    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    } else if (outOfBound(r, c) || board[r][c] != null) {
      throw new IllegalArgumentException("Invalid position.");
    }

    board[r][c] = round % 2 == 0 ? Player.O : Player.X;
    round++;
  }

  /**
   * Get the current turn.
   * @return Player type.
   */
  @Override
  public Player getTurn() {
    return round % 2 == 0 ? Player.O : Player.X;
  }

  /**
   * Return whether the game is over.
   * @return  true if the game is over, false otherwise.
   */
  @Override
  public boolean isGameOver() {
    if (round < 6) {
      return false;
    } else if (round == 10) {
      return true;
    }

    return getWinner() != null;

  }

  /**
   * Return the winner of the game.
   * @return the winner, or null if there is no winner.
   */
  @Override
  public Player getWinner() {
    // check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] != null
              && board[i][0] == board[i][1]
              && board[i][1] == board[i][2]) {
        return board[i][0];
      }
    }

    // check cols
    for (int j = 0; j < 3; j++) {
      if (board[0][j] != null
              && board[0][j] == board[1][j]
              && board[1][j] == board[2][j]) {
        return board[0][j];
      }
    }

    // check diagonals
    if (board[1][1] != null
            && ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
            || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
      return board[1][1];
    }

    return null;

  }

  /**
   * Return the current game state.
   * @return the current game board.
   */
  @Override
  public Player[][] getBoard() {
    Player[][] copy = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        copy[i][j] = board[i][j];
      }
    }

    return copy;

  }

  /**
   * Return the current mark at a given row and column.
   * @param r the row
   * @param c the column
   * @return the player at the given position.
   */
  @Override
  public Player getMarkAt(int r, int c) {
    if (outOfBound(r, c)) {
      throw new IllegalArgumentException("Invalid positions.");
    }
    return board[r][c];
  }

  /**
   * Check if a given row and col are out of bound.
   * @param r int row number.
   * @param c int column number.
   * @return boolean whether it is out of bound.
   */
  private boolean outOfBound(int r, int c) {
    return r > 2 || r < 0 || c < 0 || c > 2;
  }
}
