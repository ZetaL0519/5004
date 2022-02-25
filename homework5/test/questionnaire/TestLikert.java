package questionnaire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Junit test class for Likert question.
 */
public class TestLikert {
  Likert likert1;
  Likert likert2;

  /**
   * Declare and initialize Likert Objects to test.
   */
  @Before
  public void SetUp() {
    likert1 = new Likert("5004 is a good class", true);
    likert2 = new Likert("5004 is a must-take class", false);
  }

  /**
   * Test IllegalArg Likert objects.
   */
  @Test
  public void TestBadLikert() {
    try {
      Likert likert3 = new Likert("", true);
    } catch (IllegalArgumentException e) {
      System.out.println( e.getMessage());
    }

    try {
      Likert likert3 = new Likert(null, true);
    } catch (IllegalArgumentException e) {
      System.out.println( e.getMessage());
    }
  }

  /**
   * This is a test for getPrompt method.
   */
  @Test
  public void TestGetPrompt() {
    Assert.assertEquals("5004 is a good class", likert1.getPrompt());
    Assert.assertEquals("5004 is a must-take class", likert2.getPrompt());
  }

  /**
   * This is a test for IsRequired method.
   */
  @Test
  public void TestIsRequired() {
    Assert.assertTrue(likert1.isRequired());
    Assert.assertFalse(likert2.isRequired());
  }

  /**
   * This is a test for IllegalArg answer.
   * Including null, empty, not in LikertResponseList.
   */
  @Test
  public void TestBadAnswer() {
    try {
      likert2.answer("Dont know");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      likert1.answer(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      likert1.answer("");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test good answer.
   * Including upper and lower case.
   */
  @Test
  public void TestGoodAnswer() {
    likert1.answer("strongly agree");
    Assert.assertEquals("strongly agree", likert1.getAnswer());

    likert1.answer("strongly DISAGREE");
    Assert.assertEquals("strongly DISAGREE", likert1.getAnswer());

    likert1.answer("agree");
    Assert.assertEquals("agree", likert1.getAnswer());

    likert1.answer("DISagree");
    Assert.assertEquals("DISagree", likert1.getAnswer());
  }

  /**
   * Test copy method.
   * Test the copy has the same attributes as the original one.
   * Test the copy is not the same as the original.
   */
  @Test
  public void TestCopy() {
    // Test attributes of copy and original.
    Question likert1Copy = likert1.copy();

    Assert.assertEquals(likert1Copy.getPrompt(), likert1.getPrompt());
    Assert.assertEquals(likert1Copy.isRequired(), likert1.isRequired());
    Assert.assertEquals(likert1Copy.getAnswer(), likert1.getAnswer());

    // deep test copy and original not the same
    Assert.assertNotSame(likert1Copy, likert1);
  }
}
