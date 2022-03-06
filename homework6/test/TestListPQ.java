import cs5004.collections.ElementNode;
import cs5004.collections.EmptyNode;
import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Test class for list PriorityQueue.
 */
public class TestListPQ {
  ListPriorityQueue listPriorityQueue1;
  ListPriorityQueue listPriorityQueue2;
  ElementNode elementNode;
  EmptyNode emptyNode;

  /**
   * Declare and initialize INode objects and listPQ objects.
   */
  @Before
  public void SetUp() {
    emptyNode = new EmptyNode();
    elementNode = new ElementNode(2, "a", emptyNode);
    listPriorityQueue1 = new ListPriorityQueue(elementNode);
    listPriorityQueue2 = new ListPriorityQueue(emptyNode);
  }

  /**
   * This is to test static method CreateEmpty.
   */
  @Test
  public void TestCreateEmpty() {
    PriorityQueue emptyPQ = ListPriorityQueue.createEmpty();
    Assert.assertTrue(emptyPQ.isEmpty());
  }

  /**
   * This is to test IsEmpty method.
   */
  @Test
  public void TestIsEmpty() {
    Assert.assertTrue(listPriorityQueue2.isEmpty());
    Assert.assertFalse(listPriorityQueue1.isEmpty());
  }

  /**
   * This is to test illegal add method.
   */
  @Test
  public void TestBadAdd() {
    try {
      listPriorityQueue2.add(null, "a");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      listPriorityQueue2.add(2, null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      listPriorityQueue2.add(78, "g");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      listPriorityQueue2.add(0, "h");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * This is to test whether add method is implemented well
   * each node is ordered according to priority.
   */
  @Test
  public void TestGoodAdd() {
    PriorityQueue listPQ2 = listPriorityQueue1.add(3, "b");
    PriorityQueue listPQ3 = listPQ2.add(2,"j");
    PriorityQueue listPQ4 = listPQ3.add(1, "h");
    String output = "Priority Queue is: b a j h ";
    Assert.assertEquals(output, listPQ4.toString());

    String output2 = "Priority Queue is: ";
    Assert.assertEquals(output2, listPriorityQueue2.toString());
  }

  /**
   * This is to test the illegal peek method.
   *        @throws EmptyPriorityQueueException
   *        If listPQ is empty.
   */
  @Test(expected = EmptyPriorityQueueException.class)
  public void TestBadPeek() throws EmptyPriorityQueueException {
    listPriorityQueue2.peek();
  }

  /**
   * This is to test the legal peek method.
   *      @throws EmptyPriorityQueueException
   *      If listPQ is empty.
   */
  @Test
  public void TestGoodPeek() throws EmptyPriorityQueueException {
    PriorityQueue listPQ2 = listPriorityQueue1.add(3, "b");
    PriorityQueue listPQ3 = listPQ2.add(2,"j");
    PriorityQueue listPQ4 = listPQ3.add(1, "h");
    Assert.assertEquals(listPriorityQueue1.peek(), "a");
    Assert.assertEquals(listPQ2.peek(), "b");
    Assert.assertEquals(listPQ3.peek(), "b");
    Assert.assertEquals(listPQ4.peek(), "b");
  }

  /**
   * This is to test illegal pop method.
   *      @throws EmptyPriorityQueueException
   *      If listPQ is empty.
   */
  @Test(expected = EmptyPriorityQueueException.class)
  public void TestBadPop() throws EmptyPriorityQueueException {
    listPriorityQueue2.pop();
  }

  /**
   * This is to test legal pop method.
   *      @throws EmptyPriorityQueueException
   *      if listPQ is empty.
   */
  @Test
  public void TestGoodPop() throws EmptyPriorityQueueException {
    PriorityQueue listPriorityQueue3 = listPriorityQueue1.pop();
    Assert.assertEquals(ListPriorityQueue.createEmpty(), listPriorityQueue3);
  }

  /**
   * This is to test toString method.
   */
  @Test
  public void TestToString() {
    PriorityQueue listPQ2 = listPriorityQueue1.add(3, "b");
    PriorityQueue listPQ3 = listPQ2.add(2,"j");
    PriorityQueue listPQ4 = listPQ3.add(1, "h");
    String output = "Priority Queue is: b a j h ";
    Assert.assertEquals(output, listPQ4.toString());
  }

  /**
   * Test if two listPQ is equal while adding same nodes but different order.
   */
  @Test
  public void TestEqual() {
    // equal for non-empty pq
    PriorityQueue listPriorityQueue5 = listPriorityQueue1.add(3, "b");

    ElementNode elementNode5 = new ElementNode(3, "b", emptyNode);
    ListPriorityQueue listPriorityQueue6 = new ListPriorityQueue(elementNode5);
    PriorityQueue listPriorityQueue7 = listPriorityQueue6.add(2, "a");
    Assert.assertEquals(listPriorityQueue5, listPriorityQueue7);

    // equal for empty pq
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    Assert.assertEquals(pq, listPriorityQueue2);
  }
}

