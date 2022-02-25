package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit class for testing CheckingAccounts class.
 */
public class TestChecking {
  private CheckingAccount checking1;

  /**
   * Initialize a valid CheckingAccount object.
   */
  @Before
  public void SetUp() {
    checking1 = new CheckingAccount(1);
  }

  /**
   * Test badChecking object of starting account smaller than 0.01.
   */
  @Test
  public void TestBadChecking() {
    try {
      CheckingAccount checking2 = new CheckingAccount(0.005);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadChecking caught") + e.getMessage());
    }

    try {
      CheckingAccount checking2 = new CheckingAccount(-100);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadChecking caught") + e.getMessage());
    }
  }

  /**
   * Test Bad Deposit with negative deposit amount.
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestBadDeposit() {
    checking1.deposit(-100);
  }

  /**
   * Test valid deposit method and use getBalance method to test.
   */
  @Test
  public void TestDeposit() {
    checking1.deposit(0.05);
    Assert.assertEquals(1.05, checking1.getBalance(), 0.001);
    checking1.deposit(1);
    Assert.assertEquals(2.05, checking1.getBalance(), 0.001);
  }

  /**
   * Test valid withdraw method and test it with getBalance method.
   */
  @Test
  public void TestWithdraw() {
    checking1.deposit(100);
    Assert.assertTrue(checking1.withdraw(0));
    Assert.assertFalse(checking1.withdraw(-1));
    Assert.assertFalse(checking1.withdraw(200));
    Assert.assertTrue(checking1.withdraw(1));
    Assert.assertEquals(checking1.getBalance(), 100, 0.001);
  }

  /**
   * Test GetBalance method.
   */
  @Test
  public void TestGetBalance() {
    checking1.withdraw(100);
    checking1.deposit(400);
    Assert.assertEquals(401, checking1.getBalance(), 0.001);
  }

  /**
   *  Test toString method.
   */
  @Test
  public void TestToString() {
    checking1.deposit(0.05);
    Assert.assertEquals("$1.05", checking1.toString());
  }

  /**
   *  Test PerformMonthlyMaintenance method by testing balance less and more than 100.
   */
  @Test
  public void TestPerformMonthlyMain() {
    // Balance less than 100.
    checking1.performMonthlyMaintenance();
    Assert.assertEquals(-4, checking1.getBalance(), 0.001);
    // next month
    checking1.performMonthlyMaintenance();
    Assert.assertEquals(-9, checking1.getBalance(), 0.001);

    // Balance dropped 100 and rise up will still charge money.
    checking1.deposit(600);
    checking1.performMonthlyMaintenance();
    Assert.assertEquals(586, checking1.getBalance(), 0.001);
  }
}
