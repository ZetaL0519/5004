package employee;

import java.text.DecimalFormat;

/**
 * This is a class representing Employee, with two constructors: SalariedEmp and HourlyEmp.
 * They all have name, id, payrate, but their payment method differ.
 */
public class Employee {
  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private boolean isManager;
  private double hoursWorked;
  private IPaycheck paycheck;

  /**
   * This is a constructor function for salaried Employees with name,
   * id, pay rate, pay interval and isManager.
   *     @param name (string) the name of the employee.
   *     @param id (string) the id of the employee.
   *     @param payRate (double) the pay rate of the employee.
   *     @param payInterval (int) pay interval (how many weeks a pay).
   *     @param isManager (boolean) whether the employee is a manager or not.
   *     @throws IllegalArgumentException
   *     If name or id is null or length equals to 0, throw exception.
   *     If pay Interval is other than 1, 2, 4, throw exception.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager)
          throws IllegalArgumentException {
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isManager = isManager;
    this.paycheck = new SalariedPaycheck(payRate, payInterval);
    if (this.name == null || this.id == null
            || name.length() == 0 || id.length() == 0 || payInterval < 0) {
      throw new IllegalArgumentException("Name or ID cannot be empty.");
    }
    if (payInterval != 1 && payInterval != 2 && payInterval != 4 ) {
      throw new IllegalArgumentException("Illegal Pay interval. Must be 1, 2 or 4 weeks");
    }
  }

  /**
   * This is a constructor for hourly-paid employee with name, id, pay rate, hoursworked.
   *     @param name (string) the name of the employee.
   *     @param id (string) the id of the employee.
   *     @param payRate (double) the pay rate of the employee
   *     @param hoursWorked (double) hours worked each week.
   *     @throws IllegalArgumentException
   *     If name or id is null or length equals to 0, or hoursWorked is below 0,
   *     throw exception.
   */
  public Employee(String name, String id, double payRate, double hoursWorked)
          throws IllegalArgumentException {
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    this.isManager = false;
    if (this.name == null || this.id == null
            || name.length() == 0 || id.length() == 0 || hoursWorked < 0) {
      throw new IllegalArgumentException("Name or ID cannot be empty.");
    }
    this.paycheck = new HourlyPaycheck(payRate, hoursWorked);
  }

  /**
   * This is a getter method for isManager.
   *     @return isManager(boolean).
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * This is a getter method for paycheck.
   *     @return paycheck(double).
   */
  public IPaycheck getPaycheck() {
    return this.paycheck;
  }

  /**
   * This is an overriding method for toString method.
   *     @return string form of the employee information.
   */
  public String toString() {
    String pattern = "###0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    IPaycheck paycheck1 = this.getPaycheck();
    Double payaftertax = paycheck1.getPayAfterTaxes();
    String format = decimalFormat.format(payaftertax);
    String output = "Name: " + this.name + "\n"
            + "ID: " + this.id + "\n"
            + "Payment after taxes: $ " + format;
    return output;
  }
}
