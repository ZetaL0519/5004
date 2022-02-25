package bank;

/**
 * This is SavingsAccount class which extends AbstractAccount and implements IAccount.
 * It is unique in withdraw and performMonthlyMaintenance methods.
 */
public class SavingsAccount extends AbstractAccount implements IAccount {
  private int DrawNum;

  /**
   * This is a constructor method which inherits the AbstractAccount constructor.
   *        @param curAmount the starter amount of account.
   *        @throws IllegalArgumentException
   *        if starter account is smaller than 1 cent, throw exception.
   */
  public SavingsAccount(double curAmount) throws IllegalArgumentException {
    super(curAmount);
    DrawNum = 0;
  }

  /**
   * This withdraw method inherits the AbstractAcoount withdraw and takes track of withdraw number.
   *        @param amount This is the amount which account deducts.
   *        @return boolean. If successful, return true.
   *        If negative or larger than balance, return false.
   */
  @Override
  public boolean withdraw(double amount) {
    if (amount < 0) {
      return false;
    }
    if (curAmount < amount) {
      return false;
    }
    else {
      DrawNum += 1;
      this.curAmount -= amount;
      return true;
    }
  }

  /**
   * This is a getter method for WithDraw number.
   * @return DrawNum. The number of withdrawals for the month
   */
  public int getDrawNum() {
    return DrawNum;
  }

  /**
   * This is performMonthlyMaintenance method.
   * if the number of withdraw is larger than 6,
   * a transaction penalty of $14 is deducted from the account.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (getDrawNum() > 6 && getBalance() >= 0) {
      this.curAmount -= 14;
      DrawNum = 0;
    }
  }
}
