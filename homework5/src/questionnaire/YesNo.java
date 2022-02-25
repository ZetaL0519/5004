package questionnaire;

/**
 * This is a class representing YesNo question type.
 */
public class YesNo extends AbstractQuestion {
  /**
   * This is a constructor for YesNo question type.
   *     @param questionText String of question text.
   *     @param Required boolean whether the question is required.
   */
  public YesNo(String questionText, boolean Required) {
    super(questionText, Required);
  }

  /**
   * This is an answer method for YesNo question type.
   * User must answer yes/no.
   *     @param ans string form of answer user inputs.
   *     @throws IllegalArgumentException
   *     If answer is null or empty or other than yes/no,
   *     throw exception.
   */
  @Override
  public void answer(String ans) throws IllegalArgumentException {
    if (ans == null || ans.equals("")) {
      throw new IllegalArgumentException("Answer null");
    }
    if (ans.equalsIgnoreCase("YES") || ans.equalsIgnoreCase("NO")) {
      this.answer = ans;
    } else {
      throw new IllegalArgumentException("Answer Required.Cannot be Empty");
    }
  }
}
