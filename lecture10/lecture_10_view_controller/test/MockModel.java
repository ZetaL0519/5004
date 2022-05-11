import model.ICalculator;

class MockModel implements ICalculator {
  private StringBuilder log;
  private final int uniqueCode;

  public MockModel(StringBuilder log,int uniqueCode) {
    this.log = log;
    this.uniqueCode = uniqueCode;
  }

  @Override
  public int add(int num1, int num2) {
    log.append("Input: " + num1 + " " + num2 + "\n");
    return uniqueCode;
  }

  public int subtract(int num1, int num2 ) {
    log.append("Input: " + num1 + " " + num2 + "\n");
    return uniqueCode;
  }
}
