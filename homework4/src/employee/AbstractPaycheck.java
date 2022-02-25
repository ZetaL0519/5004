package employee;

import java.text.DecimalFormat;

/**
 * This is an abstract class for paycheck.
 */
public abstract class AbstractPaycheck implements IPaycheck {
  protected double payRate;
  private final int PAYLIMIT = 400;

  /**
   * This is a constructor for AbstractPaycheck with pay rate.
   *     @param payRate (double) payrate of the employee.
   *     @throws IllegalArgumentException
   *     If pay rate is below 0, throw exception.
   *
   */
  public AbstractPaycheck(double payRate) throws IllegalArgumentException {
    this.payRate = payRate;
    if (payRate < 0) {
      throw new IllegalArgumentException("cannot be under 0");
    }
  }

  /**
   * This is a method to calculate pay after taxes.
   * If total pay is below 400, tax rate is 10%.
   * If not, tax rate is 15%.
   * If total pay is below 0, then 0.
   * If total pay is within range of (0, 0.01), then 0.01.
   *     @return payment after taxes.
   */
  public double getPayAfterTaxes() {
    double pay = this.getTotalPay();
    if (pay < PAYLIMIT) {
      pay = pay - pay * 0.1;
    }
    else {
      pay = pay - pay * 0.15;
    }
    if (pay < 0) {
      pay = 0;
    }
    else if (pay < 0.01 && pay > 0.0)
      pay = 0.01;
    return pay;
  }

  /**
   * This is a getter method for payrate.
   *     @return pay rate (double).
   */
  public double getPayRate() {
    return payRate;
  }

  /**
   * This is an overriding method for toString().
   * @return string form of payment after tax.
   */
  public String toString() {
    double PayAfter = this.getPayAfterTaxes();
    String pattern = "###0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String format = decimalFormat.format(PayAfter);
    return "Payment after taxes: $ " + format;
  }
}
