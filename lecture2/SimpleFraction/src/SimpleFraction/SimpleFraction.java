package SimpleFraction;

public class SimpleFraction {
  private final int denominator;
  private final int nominator;

  public SimpleFraction(int nominator, int denominator) {
    this.denominator = denominator;
    this.nominator = nominator;
    if (this.denominator < 0){
      throw new IllegalArgumentException("Denominator cannot be negative");
    }
  }

  public int getDenominator() {
    return denominator;
  }

  public int getNominator() {
    return nominator;
  }

  public SimpleFraction makeReciprocal() throws ArithmeticException{
    if (this.nominator == 0)
      throw new ArithmeticException("cannot divide by zero");
    return new SimpleFraction(this.denominator, this.nominator);
  }

  public String toString() {
    return this.nominator + "/" + this.denominator;
  }
}
