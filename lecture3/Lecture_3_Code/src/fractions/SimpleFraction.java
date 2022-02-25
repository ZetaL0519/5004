package fractions;

/**
 * Simple Fraction class. Supports operations like reciprocal, etc.
 */
public class SimpleFraction {
  private final int numerator;
  private final int denominator;

  public SimpleFraction(int numerator, int denominator) throws IllegalArgumentException {
    this.numerator = numerator;
    this.denominator = denominator;
    if(denominator == 0) {
      throw new IllegalArgumentException("Cannot use ZERO for denominator");
    }
  }

  public int getDenominator() {
    return this.denominator;
  }

  public int getNumerator() {
    return this.numerator;
  }

  public SimpleFraction makeReciprocal() throws ArithmeticException {
    if(this.numerator == 0)
      throw new ArithmeticException("recip denom cannot be zero!");
    return new SimpleFraction(this.denominator, this.numerator);
  }

  @Override
  public String toString() {
    return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
  }

  public static void main(String [] args) {
    try {
      SimpleFraction fraction = new SimpleFraction(1, 0);
      SimpleFraction fraction2 = new SimpleFraction(0,1);
      fraction2.makeReciprocal();
      System.out.println(fraction2);
    }
    catch(IllegalArgumentException | ArithmeticException e) {
      System.out.println("We caught this exception: " + e.getMessage());
    }
    /*
    catch(ArithmeticException e) {
      System.out.println("We caught Arithmetic Exception");
    }
     */
  }

}
