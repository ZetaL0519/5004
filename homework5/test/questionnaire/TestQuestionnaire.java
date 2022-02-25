package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Junit test class for QuestionnaireImpl class.
 */
public class TestQuestionnaire {
  QuestionnaireImpl questionnaire;
  ShortAnswer shortAnswer;
  YesNo yesNo;
  Likert likert;

  /**
   * Declares and initializes question object.
   */
  @Before
  public void SetUp() {
    questionnaire = new QuestionnaireImpl();
    shortAnswer = new ShortAnswer("How are you", true);
    yesNo = new YesNo("Do you like Sushi?", false);
    likert = new Likert("CS5004 is tedious", false);
  }

  /**
   * Test Illegal AddQuestion method.
   */
  @Test
  public void TestBadAddQuestion() {
    try {
      questionnaire.addQuestion("", shortAnswer);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion(null, shortAnswer);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("1", null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Legal AddQuestion method.
   */
  @Test
  public void TestGoodAddQuestion() {
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    String que = "Question: How are you\n\n" + "Answer: \n\n"
            + "Question: Do you like Sushi?\n\n" + "Answer: ";
    Assert.assertEquals(que, questionnaire.toString());
  }

  /**
   * Test Illegal remove question method.
   */
  @Test
  public void TestBadRemoveQuestion() {
    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.removeQuestion("");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.removeQuestion(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.removeQuestion("abc");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.removeQuestion("abc");
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Legal RemoveQuestion method.
   */
  @Test
  public void TestRemoveQuestion() {
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.removeQuestion("second");
    String que = "Question: How are you\n\n" + "Answer: ";
    Assert.assertEquals(que, questionnaire.toString());
  }

  /**
   * Test Illegal getQuestion method.
   */
  @Test
  public void TestBadGetQuestionNum() {
    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.getQuestion(3);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.getQuestion(0);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.getQuestion(-3);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test legal getQuestion method.
   */
  @Test
  public void TestGoodGetQuestionNum() {
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    Question que1 = new ShortAnswer("How are you", true);
    que1.AddIdentifier("first");
    Assert.assertEquals(questionnaire.getQuestion(1), que1);
    Question que2 = new YesNo("Do you like Sushi?", false);
    que2.AddIdentifier("second");
    Assert.assertEquals(questionnaire.getQuestion(2), que2);

  }

  /**
   * Test Illegal GetQuestion method.
   */
  @Test
  public void TestBadGetQuestionStr() {
    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.getQuestion("");
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.getQuestion(null);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.getQuestion("huyfe");
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Legal GetQuestion method.
   */
  @Test
  public void TestGoodGetQuestionStr() {
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    Question que1 = new ShortAnswer("How are you", true);
    que1.AddIdentifier("first");
    Assert.assertEquals(questionnaire.getQuestion("first"), que1);
    Question que2 = new YesNo("Do you like Sushi?", false);
    que2.AddIdentifier("second");
    Assert.assertEquals(questionnaire.getQuestion("second"), que2);
  }

  /**
   * Test GetRequiredQuestion method.
   */
  @Test
  public void TestGetRequiredQue() {
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    List<Question> result = questionnaire.getRequiredQuestions();
    for (Question q: result) {
      Assert.assertTrue(q.isRequired());
    }
    Assert.assertEquals(1, result.size());
    Question que1 = new ShortAnswer("How are you", true);
    que1.AddIdentifier("first");
    Assert.assertEquals(que1, result.get(0));
  }

  /**
   * Test GetOptionalQuestions.
   */
  @Test
  public void testGetOptionalQuestions() {
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    List<Question> result = questionnaire.getOptionalQuestions();
    for (Question q: result) {
      Assert.assertFalse(q.isRequired());
    }
    Assert.assertEquals(2, result.size());
    Question que2 = new YesNo("Do you like Sushi?", false);
    que2.AddIdentifier("second");
    Assert.assertEquals(que2, result.get(0));
    Question que3 = new Likert("CS5004 is tedious", false);
    que3.AddIdentifier("third");
    Assert.assertEquals(que3, result.get(1));
  }

  /**
   * Test IsComplete method.
   */
  @Test
  public void testIsComplete() {
    //complete
    shortAnswer.answer("i dont know");
    yesNo.answer("yes");
    likert.answer("agree");
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    Assert.assertTrue(questionnaire.isComplete());

    // incomplete
    YesNo yesno2 = new YesNo("do you like?", true);
    questionnaire.addQuestion("fourth", yesno2);
    Assert.assertFalse(questionnaire.isComplete());
  }

  /**
   * Test GetResponse method.
   */
  @Test
  public void TestGetResponse() {
    shortAnswer.answer("i dont know");
    yesNo.answer("yes");
    likert.answer("agree");
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    List<String> response = new ArrayList<>();
    response.add("i dont know");
    response.add("yes");
    response.add("agree");
    Assert.assertEquals(response, questionnaire.getResponses());
  }

  /**
   * Test Illegal filter method.
   */
  @Test
  public void TestBadFilter() {
    try {
      Questionnaire newQn = questionnaire.filter(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test legal filter method.
   */
  @Test
  public void TestFilter() {
    shortAnswer.answer("i dont know");
    yesNo.answer("yes");
    likert.answer("agree");
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    Questionnaire newQn = questionnaire.filter((Question q) -> q.isRequired());
    String answer = "Question: How are you\n\n"
            + "Answer: i dont know\n\n"
            + "Question: Do you like Sushi?\n\n"
            + "Answer: yes\n\n"
            + "Question: CS5004 is tedious\n\n"
            + "Answer: agree";
    Assert.assertEquals(answer, questionnaire.toString());
  }

  /**
   * Test Illegal sort method.
   */
  @Test
  public void TestBadSort() {
    try {
      shortAnswer.answer("i dont know");
      yesNo.answer("yes");
      likert.answer("agree");
      questionnaire.addQuestion("first", shortAnswer);
      questionnaire.addQuestion("second", yesNo);
      questionnaire.addQuestion("third", likert);
      questionnaire.sort(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      questionnaire.sort(new Comparator<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
          if (o1.getPrompt().equals(o2.getPrompt())) {
            return 0;
          }
          return o1.getPrompt().compareTo(o2.getPrompt());
        }
      });
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Legal sort method.
   */
  @Test
  public void TestSort() {
    shortAnswer.answer("i dont know");
    yesNo.answer("yes");
    likert.answer("agree");
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    questionnaire.sort(new Comparator<Question>() {
      @Override
      public int compare(Question o1, Question o2) {
        if (o1.getPrompt().equals(o2.getPrompt())) {
          return 0;
        }
        return o1.getPrompt().compareTo(o2.getPrompt());
      }
    });
    String answer = "Question: CS5004 is tedious\n\n"
            + "Answer: agree\n\n"
            + "Question: Do you like Sushi?\n\n"
            + "Answer: yes\n\n"
            + "Question: How are you\n\n"
            + "Answer: i dont know";
    Assert.assertEquals(answer, questionnaire.toString());
  }

  /**
   * Test Illegal fold method.
   */
  @Test
  public void testBadFold() {
    try {
      Integer result = questionnaire.fold(null, 0);

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      Integer result = questionnaire.fold(((Question, string) -> string + 1), null);

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test Legal fold method.
   */
  @Test
  public void testFold() {
    shortAnswer.answer("i dont know");
    yesNo.answer("yes");
    likert.answer("agree");
    questionnaire.addQuestion("first", shortAnswer);
    questionnaire.addQuestion("second", yesNo);
    questionnaire.addQuestion("third", likert);
    // Test integer
    Integer result = questionnaire.fold((question, integer) -> integer + 1, 0);
    Assert.assertEquals(result, Integer.valueOf(3));

    //Test String
    String prompt1 = questionnaire.fold((question, string) -> string + question.getPrompt(), "");
    Assert.assertEquals(prompt1, "How are youDo you like Sushi?CS5004 is tedious");
  }
}
