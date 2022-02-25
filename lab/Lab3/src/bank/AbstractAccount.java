package bank;

import java.text.DecimalFormat;

/**
 *  This is an abstract class which implements IAccount interface,
 *  and implement common methods of Account classes.
 */
public abstract class AbstractAccount implements IAccount {
  protected double curAmount;

  /**
   * This is a constructor method which takes in starter amount as parameter.
   *        @param curAmount This is the starter amount of the account first created.
   *        @throws IllegalArgumentException
   *        If starter amount smaller than one cent, throw IllegalArgumentException.
   */
  public AbstractAccount(double curAmount) throws IllegalArgumentException {
    if (curAmount < 0.01) {
      throw new IllegalArgumentException("Start amount cannot be below 1 cent");
    }
    this.curAmount = curAmount;
  }

  /**
   *  This is a deposit method which takes in non-negative amount and deposit into the account.
   *      @param amount This is the amount which account takes and deposit.
   *      @throws IllegalArgumentException
   *      If the amount is negative, throw exception.
   */
  public void deposit(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Deposit amount cannot be below 0");
    }
    this.curAmount += amount;
  }

  /**
   * This is a withdraw method which takes in non-negative amount and withdraw from the account.
   * Return true if the transaction succeeds.
   *      @param amount This is the amount which account deducts.
   *      @return boolean. If the withdraw account is larger than curAmount, return false.
   */
  public boolean withdraw(double amount)  {
    if (amount < 0) {
      return false;
    }
    if (curAmount < amount) {
      return false;
    }
    else {
      this.curAmount -= amount;
      return true;
    }
  }

  /**
   * This is a getter method for account balance.
   *        @return curAmount. Current balance of the account.
   */
  public double getBalance() {
    return curAmount;
  }

  /**
   * This is a performMonthlyMaintenance method.
   * It is mainly used for place holding.
   * Saving and checking will have overriding methods.
   */
  public void performMonthlyMaintenance() {
    this.curAmount = 0;
  }

  /**
   * This is a toString method.
   *        @return String in form of "$10.00"
   */
  public String toString() {
    String pattern = "##0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String format = decimalFormat.format(curAmount);
    return "$" + format;
  }
}
