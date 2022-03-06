package cs5004.collections;

/**
 * This is the EmptyNode implementing INode interface.
 */
public class EmptyNode implements INode {

  /**
   * Default constructor.
   */
  public EmptyNode() {}

  /**
   * EmptyNode is empty.
   * @return true.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Add new node with priority and value to an empty node.
   *      @param priority the value indicating the element order.
   *      @param value string form of element value.
   *      @return new Node.
   *      @throws IllegalArgumentException
   *      If passes parameters are null(priority/value),
   *      throw illegal Argument.
   */
  @Override
  public INode add(Integer priority, String value) throws IllegalArgumentException {
    if (priority == null || value == null) {
      throw new IllegalArgumentException("Parameter value cannot be null");
    }
    return new ElementNode(priority, value, this);
  }

  /**
   * Peek at the value of the first element.
   * @return null for empty node.
   */
  @Override
  public String peek() {
    return null;
  }

  /**
   * Pop the first element of the Node.
   * @return null for empty node.
   */
  @Override
  public INode pop() {
    return null;
  }

  /**
   * Equal method for empty node.
   * @param obj Object to be compared.
   * @return boolean whether equal
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    return obj != null && getClass() == obj.getClass();
  }

  /**
   * toString method of empty Node.
   * @return String form of empty node.
   */
  @Override
  public String toString() {
    return "EmptyNode";
  }
}
