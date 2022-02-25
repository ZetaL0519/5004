package employee;

/**
 *  This is a class representing HourlyPaycheck with payrate and hoursworked.
 */
public class HourlyPaycheck extends AbstractPaycheck {
  private double hoursWorked;
  private double TotalPay;
  private final int HOURLIMIT = 40;
  private final double EXTRARATE = 1.5;

  /**
   * This is a constructor for HourlyPaycheck with pay rate and horus worked.
   *     @param payRate (double) Payment rate for the employee.
   *     @param hoursWorked (double) Hours worked each week.
   *     @throws IllegalArgumentException
   *     If hours worked is below 0, throw exception.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    this.hoursWorked = hoursWorked;
    if (hoursWorked < 0) {
      throw new IllegalArgumentException("Pay rate and hours worked cannot be below 0");
    }
  }

  /**
   * This is a method to calculate total pay.
   * If hours worked is under 40, total = rate * hours.
   * If not, the extra hours have 1.5 over working rate.
   *     @return Total pay(double)
   */
  public double getTotalPay() {
    if (getHoursWorked() <= HOURLIMIT) {
      TotalPay = getHoursWorked() * this.payRate;
    } else {
      TotalPay = HOURLIMIT * this.payRate
              + (getHoursWorked() - HOURLIMIT) * this.payRate * EXTRARATE;
    }
    return TotalPay;
  }

  /**
   * This is a method for adding work hours.
   * Negative adding hours are acceptable, but total working hours have to be non-negative.
   *     @param hoursAdded adding work hours. can be positive or negative.
   */
  public void addHoursWorked(double hoursAdded) {
    this.hoursWorked += hoursAdded;
    if (this.hoursWorked < 0) {
      this.hoursWorked = 0;
    }
  }

  /**
   * This is a setter method for working hours.
   * Reset hours worked to 0.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

  /**
   * This is a getter method for working hours.
   *     @return hours worked(double)
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }
}
