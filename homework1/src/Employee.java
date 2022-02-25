import java.text.DecimalFormat;

/**
 * Siyue Li 5004 HW1 Spring 2022.
 * This class represents an employee who has a name, ID, a pay rate amd hours.
 */

public class Employee {
  private String name;
  private String ID;
  private double PayRate;
  private double hours;

  /**
   * Construct an employee object that has the provided name, ID, pay rate and hours.
   *
   * @param name  the employee name.
   * @param ID the employee ID.
   * @param PayRate  the pay rate of the employee.
   */
  public Employee(String name, String ID, double PayRate) {
    this.name = name;
    this.ID = ID;
    this.PayRate = PayRate;
    hours = 0;
  }

  /**
   * Add/Subtract hours from the initial hours must larger or equal to 0.
   * @param AddHour  the employee name.
   */

  public void addHoursWorked(double AddHour) {
    this.hours += AddHour;
    if (this.hours < 0) {
      this.hours = 0;
    }
  }

  /**
   * Reset the working hours of the employee to 0.
   *
   */
  public void resetHoursWorked() {
    this.hours = 0;
  }

  /**
   * Return the working hours of the employee.
   *
   * @return the working hours of the employee.
   */
  public double getHoursWorked() {
    return this.hours;
  }

  /**
   * Return a Paycheck object with pay rate and hours.
   *
   * @return a Paycheck object with pay rate and hours.
   */
  public Paycheck getWeeklyCheck() {
    Paycheck Pay = new Paycheck(this.PayRate, this.hours);
    return Pay;
  }

  /**
   * Return a string with employee name, ID and payment after taxes.
   *
   * @return a string with employee name, ID and payment after taxes.
   */
  public String toString() {
    String pattern = "##0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    Paycheck paycheck1 = this.getWeeklyCheck();
    Double payaftertax = paycheck1.getPayAfterTaxes();
    String format = decimalFormat.format(payaftertax);
    String output = "Name: " + this.name + "\n"
            + "ID: " + this.ID + "\n"
            + "Payment after taxes: $ " + format;
    return output;
  }
}
