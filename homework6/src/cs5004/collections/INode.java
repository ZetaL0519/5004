package cs5004.collections;

/**
 * This is an interface for Node class.
 */
public interface INode {
  /**
   * Determine whether node has any non-null value.
   *      @return boolean whether node is empty.
   */
  Boolean isEmpty();

  /**
   * Add new node with new priority and value.
   *      @param priority the value indicating the element order.
   *      @param value string form of element value.
   *      @return new Node.
   */
  INode add(Integer priority, String value);

  /**
   * Peek at the value of the first element.
   *      @return value(string).
   */
  String peek();

  /**
   * Pop the first element of the Node.
   *      @return the rest of the node.
   */
  INode pop();
}
