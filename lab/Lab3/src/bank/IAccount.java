package bank;

/**
 * This interface represents a bank account. It is the super-type for
 * any other type of traditional financial account a bank might offer
 */

public interface IAccount {
  /**
   *  This is a deposit method which takes in non-negative amount and deposit into the account.
   *      @param amount This is the amount which account takes and deposit.
   */
  void deposit(double amount);

  /**
   * This is a withdraw method which takes in non-negative amount and withdraw from the account.
   * Return true if the transaction succeeds.
   *      @param amount This is the amount which account deducts.
   */
  boolean withdraw(double amount);

  /**
   * This is a getter method for account balance.
   *        @return curAmount. Current balance of the account.
   */
  double getBalance();

  /**
   * This is a performMonthlyMaintenance method.
   * It is mainly used for place holding.
   */
  void performMonthlyMaintenance();
}
