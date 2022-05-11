package model;

public class CalculatorModel implements ICalculator {
  private int lastValue = 0;
  public int add(int one, int two) {
    lastValue = one + two;
    return  lastValue;
  }

  public int subtract(int one, int two) {
    lastValue = one - two;
    return lastValue;
  }
  public int memory() { return lastValue; }
}

