package cs5004.collections;

import java.util.Objects;

/**
 * This is an ElementNode class implementing INode class.
 */
public class ElementNode implements INode {
  private String value;
  private Integer priority;
  private INode next;

  /**
   * This is a constructor for element node.
   *      @param priority the value of which indicates the order of element.
   *      @param value the string value that is stored in the node.
   *      @param next the next node of the current node.
   */
  public ElementNode(Integer priority, String value, INode next) {
    this.value = value;
    this.priority = priority;
    this.next = next;
  }

  /**
   * This is an IsEmpty method for elementNode.
   *        @return true for element node.
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Add new node with priority and value to the current node.
   *      @param priority the value indicating the element order.
   *      @param value string form of element value.
   *      @return INode class of object.
   *      @throws IllegalArgumentException
   *      If priority or value is null,
   *      Or priority is out of range,
   *      throw IllegalArgument.
   */
  @Override
  public INode add(Integer priority, String value) throws IllegalArgumentException {
    if (priority == null || value == null) {
      throw new IllegalArgumentException("Priority or value cannot be null");
    }
    if (priority > 10 || priority < 1) {
      throw new IllegalArgumentException("Priority Value out of range");
    }

    if (this.isEmpty()) {
      return new ElementNode(priority, value, this);
    }
    if (priority > this.priority) {
      return new ElementNode(priority, value, this);
    }
    return new ElementNode(this.priority, this.value, this.next.add(priority, value));
  }

  /**
   * Getter method for priority value.
   * @return Integer  priority.
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Getter method for next Node.
   *      @return INode class object.
   */
  public INode getNext() {
    return next;
  }

  /**
   * Peek at the value of the first element.
   *      @return String value.
   */
  @Override
  public String peek() {
    return this.value;
  }

  /**
   * Pop the first head node of the element node.
   *      @return INode class object.
   */
  @Override
  public INode pop() {
    return this.next;
  }

  /**
   * This is an equal method for element node.
   *      @param o Object.
   *      @return boolean whether equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ElementNode that = (ElementNode) o;
    return value.equals(that.value) && priority.equals(that.priority) && next.equals(that.next);
  }

  /**
   * Calculate hashcode for all attributes.
   *     @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, priority, next);
  }

}
