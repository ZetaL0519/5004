package questionnaire;

/**
 * This is a class representing Likert question with QuestionText and required.
 */
public class Likert extends AbstractQuestion {
  /**
   * This is the constructor for Likert question.
   *     @param questionText text of question.
   *     @param Required boolean whether question is required or not.
   */
  public Likert(String questionText, boolean Required) {
    super(questionText, Required);
  }

  /**
   * This is answer method for Likert question.
   * The answer must be among likertResponseList.
   *     @param ans string form of answer user inputs.
   *     @throws IllegalArgumentException
   *     if answer is null or empty or not in the list of response,
   *     throw exception.
   */
  @Override
  public void answer(String ans) throws IllegalArgumentException {
    if (ans == null || ans.equals("")) {
      throw new IllegalArgumentException("Answer null");
    }
    LikertResponseOption[] likertList = LikertResponseOption.values();
    for (int i = 0; i < likertList.length; i ++) {
      if (ans.equalsIgnoreCase(likertList[i].getText())) {
        this.answer = ans;
        return;
      }
    }
    throw new IllegalArgumentException("Answer not valid.");
  }
}
