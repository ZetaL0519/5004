package questionnaire;

import java.util.Objects;

/**
 * This is an abstract class for Question.
 */
public class AbstractQuestion implements Question {
  protected String questionText;
  protected boolean Required;
  protected String answer;
  protected String identifier;

  /**
   * This is a constructor of question type with text and required.
   *     @param questionText Text of the question.
   *     @param Required boolean whether the question is required.
   *     @throws IllegalArgumentException
   *     If question text is null or empty, throw exception.
   */
  public AbstractQuestion(String questionText, boolean Required) throws IllegalArgumentException {
    if (questionText == null || questionText.equals("")) {
      throw new IllegalArgumentException("Question Text null");
    }
    this.questionText = questionText;
    this.Required = Required;
    this.answer = "";
  }

  /**
   * This is a method for GetPrompt(question text).
   *     @return String of question form.
   */
  @Override
  public String getPrompt() {
    return questionText;
  }

  /**
   * This is a method for getting required field.
   *     @return boolean Required.
   */
  @Override
  public boolean isRequired() {
    return Required;
  }

  /**
   * This is a general method for answer method.
   *     @param ans string form of answer user inputs.
   *     @throws IllegalArgumentException
   *     if answer is null, throw exception.
   */
  @Override
  public void answer(String ans) throws IllegalArgumentException {
    if (ans == null) {
      throw new IllegalArgumentException("Answer null");
    }
    this.answer = ans;
  }

  /**
   * This is a getter for answer method.
   *     @return string form of answer.
   */
  @Override
  public String getAnswer() {
    return answer;
  }

  /**
   * This is a copy method for copy the Question.
   *     @return the copy of Question.
   */
  @Override
  public Question copy() {
    AbstractQuestion CopyQuestion = new AbstractQuestion(this.questionText, this.Required);
    CopyQuestion.answer(this.answer);
    return CopyQuestion;
  }

  /**
   * This is an add identifier method used for Questionnaire.
   *     @param identifier String identifier for question.
   */
  @Override
  public void AddIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * This is a getter method for identifier.
   *     @return identifier String identifier for question.
   */
  @Override
  public String GetIdentifier() {
    return identifier;
  }

  /**
   * This is an overriding equal class.
   * @param o another Question object.
   * @return boolean if they are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractQuestion that = (AbstractQuestion) o;
    return Required == that.Required && questionText.equals(that.questionText)
            && answer.equals(that.answer) && identifier.equals(that.identifier);
  }

  /**
   * This is a hashcode function.
   * @return hashcode integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(questionText, Required, answer, identifier);
  }
}
