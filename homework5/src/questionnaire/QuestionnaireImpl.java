package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * This is a concrete class implementing interface questionnaire.
 */
public class QuestionnaireImpl implements Questionnaire {
  private List<Question> QList;

  /**
   * Constructor for QuestionnaireImpl.
   */
  public QuestionnaireImpl() {
    this.QList = new ArrayList<>();
  }

  /**
   * This is an addQuestion method for identifier and question.
   *     @param identifier a name for the question <b>unique</b> within this questionnaire. Not null
   *                   or empty.
   *     @param q the {@link Question} to be added to the questionnaire
   *     @throws IllegalArgumentException
   *     if identifier is null or empty,
   *     throw exception
   */
  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || identifier.length() == 0 || q == null) {
      throw new IllegalArgumentException("Identifier or Question null");
    }
    q.AddIdentifier(identifier);
    QList.add(q);
  }

  /**
   * This is a removeQuestion method.
   *     @param identifier the identifier of the question to be removed.
   *     @throws IllegalArgumentException
   *     If identifier is null or empty,
   *     throw illegal exception.
   *     @throws NoSuchElementException
   *     If identifier does not exist,
   *     throw nosuchelement exception.
   */
  @Override
  public void removeQuestion(String identifier) throws IllegalArgumentException,
          NoSuchElementException {
    if (identifier == null || identifier.equals("")
            || QList == null || QList.isEmpty()) {
      throw new IllegalArgumentException("Remove null identifier");
    }
    for (Question q: QList) {
      if (q.GetIdentifier().equals(identifier)) {
        QList.remove(q);
        return;
      }
    }
    throw new NoSuchElementException("Cannot remove question from Questionnaire");
  }

  /**
   * This is a getQuestion method according to the order of questions.
   *     @param num the number of the question, counting from 1
   *     @return Question of the num-th order.
   *     @throws IndexOutOfBoundsException
   *     If num is bigger than the size of question list,
   *     throw exception.
   */
  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (QList.size() < num || num <= 0) {
      throw new IndexOutOfBoundsException("Index out of bound");
    }
    return QList.get(num - 1);
  }

  /**
   * This is a getQuestion method according to identifier.
   *     @param identifier the identifier of the question
   *     @return Question with the matching identifier.
   *     @throws NoSuchElementException
   *     If identifier does not exist,
   *     throw exception.
   */
  @Override
  public Question getQuestion(String identifier) throws NoSuchElementException {
    for (Question q: QList) {
      if (q.GetIdentifier().equals(identifier)) {
        return q;
      }
    }
    throw new NoSuchElementException("No question existed");
  }

  /**
   * This is a getRequiredQuestion method.
   *     @return an array list of required questions.
   */
  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> RequiredList = new ArrayList<>();
    for (Question q: QList) {
      if (q.isRequired()) {
        RequiredList.add(q);
      }
    }
    return RequiredList;
  }

  /**
   * This is a getOptionalQuestions method.
   *    @return an arrayList of optional questions.
   */
  @Override
  public List<Question> getOptionalQuestions() {
    List<Question> OptionalList = new ArrayList<>();
    for (Question q: QList) {
      if (!q.isRequired()) {
        OptionalList.add(q);
      }
    }
    return OptionalList;
  }

  /**
   * This is an isComplete method to check if every required question has an answer.
   *     @return boolean whether questionnaire is complete.
   */
  @Override
  public boolean isComplete() {
    for (Question q: getRequiredQuestions()) {
      if (q.getAnswer().equalsIgnoreCase("") || q.getAnswer() == null) {
        return false;
      }
    }
    return true;
  }

  /**
   * This is a getResponses method.
   * @return an arrayList of answer of each question.
   */
  @Override
  public List<String> getResponses() {
    List<String> ResponseList = new ArrayList<>();
    for (Question q: QList) {
      ResponseList.add(q.getAnswer());
    }
    return ResponseList;
  }

  /**
   * This is a filter method.
   *     @param pq the predicate for filter.
   *     @return a copied Questionnaire after filtered.
   *     @throws IllegalArgumentException
   *     If Question List is empty or pq is null,
   *     throw exception.
   */
  @Override
  public Questionnaire filter(Predicate<Question> pq) throws IllegalArgumentException {
    if (QList == null || QList.isEmpty()) {
      throw new IllegalArgumentException("Questionnaire is empty!");
    }
    if (pq == null) {
      throw new IllegalArgumentException("Predicate is invalid");
    }
    Questionnaire newQuestionnaire = new QuestionnaireImpl();
    for (int i = 0; i < QList.size(); i++) {
      Question tempQ = QList.get(i);
      // If predicate function returns true.
      if (pq.test(tempQ)) {
        newQuestionnaire.addQuestion(tempQ.GetIdentifier(), tempQ.copy());
      }
    }
    return newQuestionnaire;
  }

  /**
   * This is a sort method for Question List.
   *     @param comp a comparator for Question
   *     @throws IllegalArgumentException
   *     If question list is null or comparator is null,
   *     throw exception.
   */
  @Override
  public void sort(Comparator<Question> comp) throws IllegalArgumentException {
    if (QList == null || QList.size() == 0) {
      throw new IllegalArgumentException("Question List is null");
    }
    if (comp == null) {
      throw new IllegalArgumentException("Comparator is null");
    }
    QList.sort(comp);
  }

  /**
   * This is a reducing function for Question.
   *     @param bf the folding function
   *     @param seed the seed value.
   *     @return return data type.
   *     @throws IllegalArgumentException
   *     If bifunction or seed is null,
   *     throw exception.
   */
  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) throws IllegalArgumentException {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException("Null Exception");
    }
    for (Question q : QList) {
      seed = bf.apply(q, seed);
    }
    return seed;
  }

  /**
   * This is an overriding method for toString method.
   * @return String form of question and answer text.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Question q : QList) {
      sb.append("Question: ");
      sb.append(q.getPrompt()).append("\n\n");
      sb.append("Answer: ");
      sb.append(q.getAnswer()).append("\n\n");
    }
    return sb.substring(0, sb.length() - 2);
  }
}
