package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit class for testing SavingsAccounts class.
 */
public class TestSaving {
  private SavingsAccount saving1;

  /**
   * Initialize a valid SavingsAccount object.
   */
  @Before
  public void SetUp() {
    saving1 = new SavingsAccount(1);
  }

  /**
   * Test badSaving object of starting account smaller than 0.01.
   */
  @Test
  public void TestBadSaving() {
    try {
      SavingsAccount saving2 = new SavingsAccount(0.005);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadSaving caught") + e.getMessage());
    }

    try {
      SavingsAccount saving3 = new SavingsAccount(-100);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadSaving caught") + e.getMessage());
    }
  }

  /**
   * Test Bad Deposit with negative deposit amount.
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestBadDeposit() {
    saving1.deposit(-100);
  }

  /**
   * Test valid deposit method and use getBalance method to test.
   */
  @Test
  public void TestDeposit() {
    saving1.deposit(0.05);
    Assert.assertEquals(1.05, saving1.getBalance(), 0.001);
    saving1.deposit(1);
    Assert.assertEquals(2.05, saving1.getBalance(), 0.001);
  }


  /**
   * Test valid withdraw method and test it with getBalance method.
   */
  @Test
  public void TestWithdraw() {
    saving1.deposit(100);
    Assert.assertTrue(saving1.withdraw(0));
    Assert.assertFalse(saving1.withdraw(-1));
    Assert.assertFalse(saving1.withdraw(200));
    Assert.assertTrue(saving1.withdraw(1));
    Assert.assertEquals(saving1.getBalance(), 100, 0.001);
  }

  /**
   * Test GetBalance method.
   * Return current balance.
   */
  @Test
  public void TestGetBalance() {
    saving1.withdraw(100);
    saving1.deposit(400);
    Assert.assertEquals(401, saving1.getBalance(), 0.001);
  }

  /**
   *  Test toString method.
   */
  @Test
  public void TestToString() {
    saving1.deposit(0.05);
    Assert.assertEquals("$1.05", saving1.toString());
  }

  /**
   * Test getDrawNumber method.
   */
  @Test
  public void TestGetDrawNumber() {
    Assert.assertEquals(0, saving1.getDrawNum());
    saving1.deposit(400);
    saving1.withdraw(10);
    saving1.withdraw(20);
    saving1.withdraw(30);
    saving1.withdraw(40);
    Assert.assertEquals(4, saving1.getDrawNum());
  }

  /**
   *  Test PerformMonthlyMaintenance method by testing draw number less and more than 6.
   */
  @Test
  public void TestPerformMonthlyMain() {
    // withdraw less than 6.
    saving1.performMonthlyMaintenance();
    Assert.assertEquals(1, saving1.getBalance(), 0.001);

    // withdraw more than 6.
    saving1.deposit(600);
    saving1.withdraw(10);
    saving1.withdraw(20);
    saving1.withdraw(30);
    saving1.withdraw(40);
    saving1.withdraw(50);
    saving1.withdraw(50);
    saving1.withdraw(1);
    saving1.performMonthlyMaintenance();
    Assert.assertEquals(386, saving1.getBalance(), 0.001);
    // next month.
    saving1.performMonthlyMaintenance();
    Assert.assertEquals(386, saving1.getBalance(), 0.001);
  }
}
