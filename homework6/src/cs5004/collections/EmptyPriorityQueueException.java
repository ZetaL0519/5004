package cs5004.collections;

/**
 * This is an exception class for empty priority queue.
 */
public class EmptyPriorityQueueException extends Exception {
  /**
   * This is an empty queue exception.
   */
  public EmptyPriorityQueueException() {
    super("The Priority Queue is Empty.");
  }
}
