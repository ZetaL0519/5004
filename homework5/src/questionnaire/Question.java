package questionnaire;

/**
 * This is an interface for Question class.
 */
public interface Question {

  /**
   * This is a getPrompt method.
   * @return String.
   */
  String getPrompt();

  /**
   * This is isRequired method.
   * @return boolean.
   */
  boolean isRequired();

  /**
   * This is answer method.
   *     @param ans String.
   */
  void answer(String ans);

  /**
   * This is a getter method for answer.
   * @return String.
   */
  String getAnswer();

  /**
   * This is a copy method for question.
   * @return Question.
   */
  Question copy();

  /**
   * This is an addIdentifier method.
   *     @param identifier string.
   */
  void AddIdentifier(String identifier);

  /**
   * This is a getter method for identifier.
   * @return identifier String.
   */
  String GetIdentifier();
}
