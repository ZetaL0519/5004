package cs5004.collections;

import java.util.Objects;

/**
 * This is an ListPriorityQueue class implementing PriorityQueue.
 */
public class ListPriorityQueue implements PriorityQueue {
  private INode head;

  /**
   * This is a constructor of ListPQ.
   *      @param head INode object.
   */
  public ListPriorityQueue(INode head) {
    this.head = head;
  }

  /**
   * This is a createEmpty method for an empty PQ.
   *      @return empty PriorityQueue.
   */
  public static PriorityQueue createEmpty() {
    return new ListPriorityQueue(new EmptyNode());
  }

  /**
   * This is an isEmpty method for ListPQ.
   * @return boolean whether head is empty.
   */
  @Override
  public Boolean isEmpty() {
    return this.head.isEmpty();
  }

  /**
   * Add new node to listPQ while keeping them in order.
   *      @param priority The element's (non-negative) priority.
   *      @param value The element's value.
   *      @return new PriorityQueue.
   *      @throws IllegalArgumentException
   *      If priority or value is null,
   *      or priority is out of range,
   *      throw exception.
   */
  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority == null || value == null || value.equals("")) {
      throw new IllegalArgumentException("Priority or value null");
    }

    if (priority > 10 || priority < 1) {
      throw new IllegalArgumentException("Priority Value out of range");
    }

    return new ListPriorityQueue(this.head.add(priority, value));
  }

  /**
   * This is a peek method for ListPriorityQueue.
   *      @return head node of List Priority Queue.
   *      @throws EmptyPriorityQueueException
   *      If list Priority queue is empty,
   *      throw illegal exception.
   */
  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (this.isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return this.head.peek();
  }

  /**
   * Pop the first head node of list priority queue.
   *      @return new node with head node removed.
   *      @throws EmptyPriorityQueueException
   *      If priority queue is empty,
   *      throw exception.
   */
  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    if (this.isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return new ListPriorityQueue(this.head.pop());
  }

  /**
   * This is a toString method of List Priority Queue.
   * Iterate through the list to print out the value.
   * @return String form of priority queue.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Priority Queue is: ");
    ListPriorityQueue listPQ = new ListPriorityQueue(this.head);
    while (!listPQ.head.isEmpty()) {
      sb.append(listPQ.head.peek()).append(" ");
      listPQ.head = listPQ.head.pop();
    }
    return sb.toString();
  }

  /**
   * Equal method to compare ListPQ objects.
   * @param o object to be compared.
   * @return boolean whether equal or not.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListPriorityQueue that = (ListPriorityQueue) o;
    return head.equals(that.head);
  }

  /**
   * Calculate hashcode of listPQ.
   * @return int.
   */
  @Override
  public int hashCode() {
    return Objects.hash(head);
  }

}
