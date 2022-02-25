package questionnaire;

/**
 * This is a class representing shortanswer question.
 */
public class ShortAnswer extends AbstractQuestion {

  /**
   * This is a constructor for shortanswer.
   *     @param questionText the string form of question text.
   *     @param Required boolean for required field.
   */
  public ShortAnswer(String questionText, boolean Required) {
    super(questionText, Required);
  }

  /**
   * This is an answer method for short answer question type.
   *     @param ans string form of answer user inputs.
   *     @throws IllegalArgumentException
   *     if answer is null or empty or length larger than 280,
   *     throw exception.
   */
  @Override
  public void answer(String ans) throws IllegalArgumentException {
    if (ans == null || ans.equals("")) {
      throw new IllegalArgumentException("Answer empty");
    }
    if (ans.length() > 280) {
      throw new IllegalArgumentException("Your answer should be below 280 characters.");
    }
    this.answer = ans;
  }
}
