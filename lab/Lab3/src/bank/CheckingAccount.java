
package bank;

/**
 * This is a CheckingAccount class which extends AbstractAccount and implements IAccount.
 * It is unique in method performMonthlyMaintenance.
 */
public class CheckingAccount extends AbstractAccount implements IAccount {
  private boolean AmountBelow;
  /**
   * This is a constructor method which inherits the AbstractAccount constructor.
   *        @param curAmount the starter amount of account.
   *        @throws IllegalArgumentException
   *        if starter account is smaller than 1 cent, throw exception.
   */

  public CheckingAccount(double curAmount) throws IllegalArgumentException {
    super(curAmount);
    if (getBalance() < 100) {
      this.AmountBelow = true;
    }
    this.AmountBelow = false;
  }

  /**
   * This is a checkAmount method which checks the current balance.
   *        @return AmountBelow boolean.
   *        If current balance below 100, true.
   */
  public boolean checkAmount() {
    if (getBalance() < 100) {
      this.AmountBelow = true;
    }
    return this.AmountBelow;
  }

  /**
   *  This is a deposit method which takes in non-negative amount and deposit into the account.
   *      @param amount This is the amount which account takes and deposit.
   *      @throws IllegalArgumentException
   *      If the amount is negative, throw exception.
   *      CheckAmount in the end.
   */
  @Override
  public void deposit(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Deposit amount cannot be below 0");
    }
    this.curAmount += amount;
    checkAmount();
  }

  /**
   * This is a withdraw method which takes in non-negative amount and withdraw from the account.
   * Return true if the transaction succeeds.
   *      @param amount This is the amount which account deducts.
   *      @return boolean. If the withdraw account is larger than curAmount,
   *      or negative, return false.
   *      check amount in the end.
   */
  @Override
  public boolean withdraw(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      return false;
    }
    if (getBalance() < amount) {
      return false;
    }
    else {
      this.curAmount -= amount;
      checkAmount();
      return true;
    }
  }

  /**
   * This is a performMonthlyMaintenance method.
   * if the balance falls below $100 at ANY time before maintenance is performed,
   * account maintenance fee of $5 is charged.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (checkAmount()) {
      this.curAmount -= 5;
    }
    AmountBelow = false;
    checkAmount();
  }
}
