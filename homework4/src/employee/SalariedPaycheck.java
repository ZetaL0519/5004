package employee;

import java.util.Objects;

/**
 * This is a class representing salaried paycheck with pay rate and pay interval.
 */
public class SalariedPaycheck extends AbstractPaycheck {
  private double TotalPay;
  private double TotalPayAfterTax;
  private int payInterval;
  private final int WEEKPERYEAR = 52;

  /**
   * This is a constructor class for salaried paycheck with pay rate and pay interval.
   *     @param payRate (double) pay rate of the paycheck.
   *     @param payInterval (int) how many weeks per pay.
   *     @throws IllegalArgumentException
   *     If pay interval is other than 1, 2, 4, throw exception.
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    if (payInterval != 1 && payInterval != 2 && payInterval != 4 ) {
      throw new IllegalArgumentException("Illegal Pay interval. Must be 1, 2 or 4 weeks");
    }
    this.payInterval = payInterval;
  }

  /**
   * This is a method for calculating total pay.
   * Total pay = interval * rate / 52 weeks.
   *     @return Total pay (double) Total pay before tax.
   */
  public double getTotalPay() {
    TotalPay = this.payInterval * this.payRate / WEEKPERYEAR;
    return TotalPay;
  }

  /**
   * This is a getter method for payInterval.
   * @return payInterval(int).
   */
  public int getPayInterval() {
    return payInterval;
  }

  /**
   * This is an overriding method for equal method for salaried paycheck.
   * @param o the other salariedPaycheck object.
   * @return boolean equal or not.
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SalariedPaycheck that = (SalariedPaycheck) o;
    return payInterval == that.payInterval && payRate == that.payRate;
  }

  /**
   * This is an overriding method for calculating hash code.
   * @return hash code of payinterval and payrate.
   */
  @Override
  public int hashCode() {
    return Objects.hash(payInterval, payRate);
  }
}
