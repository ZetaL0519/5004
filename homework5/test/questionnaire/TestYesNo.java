package questionnaire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test class for YesNo question.
 */
public class TestYesNo {
  YesNo judge1;
  YesNo judge2;

  /**
   * Declare and initialize the YesNo question objects.
   */
  @Before
  public void SetUp() {
    judge1 = new YesNo("Do you like the homework?", true);
    judge2 = new YesNo("Can you do 100 push-ups?", false);
  }

  /**
   * Test IllegalArg YesNo objects.
   */
  @Test
  public void TestBadYesNo() {
    try {
      YesNo judge3 = new YesNo("", true);
    } catch (IllegalArgumentException e) {
      System.out.println( e.getMessage());
    }

    try {
      YesNo judge3 = new YesNo(null, true);
    } catch (IllegalArgumentException e) {
      System.out.println( e.getMessage());
    }
  }

  /**
   * Test GetPrompt method.
   */
  @Test
  public void TestGetPrompt() {
    Assert.assertEquals("Do you like the homework?", judge1.getPrompt());
    Assert.assertEquals("Can you do 100 push-ups?", judge2.getPrompt());
  }

  /**
   * Test IsRequired method.
   */
  @Test
  public void TestIsRequired() {
    Assert.assertTrue(judge1.isRequired());
    Assert.assertFalse(judge2.isRequired());
  }

  /**
   * Test BadAnswer method.
   * Test answer null, empty, or other than yes/no.
   */
  @Test
  public void TestBadAnswer() {
    try {
      judge2.answer("Don't know");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      judge1.answer(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      judge1.answer("");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Good answer method.
   * Test upper/lower case of YES/NO.
   */
  @Test
  public void TestGoodAnswer() {
    Assert.assertEquals("", judge1.getAnswer());
    judge1.answer("yEs");
    Assert.assertEquals("yEs", judge1.getAnswer());
    judge2.answer("No");
    Assert.assertEquals("No", judge2.getAnswer());
  }

  /**
   * Test copy method.
   * Test the copy has the same attributes as the original one.
   * Test the copy is not the same as the original.
   */
  @Test
  public void TestCopy() {
    // Test attributes of copy and original.
    Question Short1Copy = judge1.copy();
    Assert.assertEquals(Short1Copy.getPrompt(), judge1.getPrompt());
    Assert.assertEquals(Short1Copy.isRequired(), judge1.isRequired());
    Assert.assertEquals(Short1Copy.getAnswer(), judge1.getAnswer());

    // deep test copy and original not the same
    Assert.assertNotSame(Short1Copy, judge1);
  }
}
