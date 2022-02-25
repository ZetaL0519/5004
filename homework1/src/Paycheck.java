import java.text.DecimalFormat;

/**
 *  Siyue Li 5004 HW1 Spring 2022.
 * This class represents a paycheck with a pay rate and hours.
 */

public class Paycheck {
  private double PayRate;
  private double hours;
  private double TotalPay;
  private double TotalPayAfterTax;
  private final int HOURLIMIT = 40;
  private final int PAYLIMIT = 400;
  /**
   * Construct a Paycheck object that has the provided pay rate and hours.
   * TotalPay is calculated by multiplying rate with hours.
   *
   * @param PayRate  the pay rate to be given to this paycheck.
   * @param hours the weekly working hours.
   */
  public Paycheck(double PayRate, double hours) {
    this.PayRate = PayRate;
    this.hours = hours;
  }

  /**
   * the total pay of this week.
   * If more than 40 hours, there is 1.5 overtime rate.
   * @return the total pay of this week.
   */

  public double getTotalPay() {
    if (this.hours <= HOURLIMIT) {
      TotalPay = this.hours * this.PayRate;
    } else {
      TotalPay = 40 * this.PayRate + (this.hours - 40) * this.PayRate * 1.5;
    }
    return TotalPay;
  }

  /**
   * the total pay after tax of this week.
   * if smaller than 400, tax rate = 0.9.
   * if larger than 400, tax rate = 0.85.
   * @return the total pay after tax of this week.
   */

  public double getPayAfterTaxes() {
    if (this.getTotalPay() < 400) {
      TotalPayAfterTax = 0.9 * this.getTotalPay();
    }
    else {
      TotalPayAfterTax = 0.85 * this.getTotalPay();
    }
    if (TotalPayAfterTax < 0.01 && TotalPayAfterTax != 0) {
      TotalPayAfterTax = 0.01;
    }
    return TotalPayAfterTax;
  }

  /**
   * the string form of total pay after tax of this week.
   * @return string form of total pay after taxes
   */

  public String toString() {
    String pattern = "##0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String format = decimalFormat.format(this.getPayAfterTaxes());
    return "Payment after taxes: $ " + format;
  }
}
