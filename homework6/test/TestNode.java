import cs5004.collections.ElementNode;
import cs5004.collections.EmptyNode;
import cs5004.collections.INode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Test class for INode objects including empty and element.
 */
public class TestNode {
  EmptyNode emptyNode;
  ElementNode elementNode;

  /**
   * Declare and initialize INode objects.
   */
  @Before
  public void SetUp() {
    emptyNode = new EmptyNode();
    elementNode = new ElementNode(3,"a", emptyNode);
  }

  /**
   * Test if Nodes are empty.
   */
  @Test
  public void TestIsEmpty() {
    Assert.assertTrue(emptyNode.isEmpty());
    Assert.assertFalse(elementNode.isEmpty());
  }

  /**
   * Test illegal add method.
   */
  @Test
  public void TestBadAdd() {
    // Test bad add element node.
    try {
      elementNode.add(null, "a");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      elementNode.add(6, null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      elementNode.add(0, "a");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      elementNode.add(11, "a");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    // Test bad add empty node.
    try {
      emptyNode.add(null, "a");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      emptyNode.add(8, null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test legal add method.
   */
  @Test
  public void TestGoodAdd() {
    // Test element equal
    INode elementNode2 = elementNode.add(4, "b");
    Assert.assertEquals(elementNode2.peek(), "b");
    // same priority nodes
    INode elementNode3 = elementNode.add(3, "b");
    Assert.assertEquals(elementNode3.peek(), "a");

    // Test empty equal
    INode elementNode4 = emptyNode.add(4, "u");
    Assert.assertEquals(elementNode4.peek(), "u");
  }

  /**
   * Test peek method.
   */
  @Test
  public void TestPeek() {
    Assert.assertNull(emptyNode.peek());
    Assert.assertEquals(elementNode.peek(), "a");
  }

  /**
   * Test pop method.
   */
  @Test
  public void TestPop() {
    Assert.assertEquals(new EmptyNode(), elementNode.pop());
    Assert.assertNull(emptyNode.pop());
  }
}
