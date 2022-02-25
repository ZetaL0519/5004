import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Siyue Li 5004 HW1 Spring 2022.
 * A JUnit test class for the Person class.
 */

public class TestPaycheck {
  private Paycheck paycheck1;
  private Paycheck paycheck2;

  /**
   * Constructs two Paycheck objects and initializes them.
   */
  @Before
  public void Setup() {
    paycheck1 = new Paycheck(15, 60);
    paycheck2 = new Paycheck(11, 30);
  }

  /**
   * Test the accuracy of Total Pay.
   */
  @Test
  public void TestgetTotalPay() {
    Assert.assertEquals(15 * 60 * 1.5, paycheck1.getTotalPay(), 0.001);
    Assert.assertEquals((11 * 30), paycheck2.getTotalPay(), 0.001);
  }

  /**
   * Test the accuracy of total pay after taxes.
   */
  @Test
  public void TestgetPayAfterTaxes() {
    Assert.assertEquals(0.85 * 15 * 60 * 1.5, paycheck1.getPayAfterTaxes(), 0.001);
    Assert.assertEquals(0.9 * 11 * 30, paycheck2.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test the accuracy of string form of payment after taxes.
   */
  @Test
  public void TesttoString() {
    Assert.assertEquals("Payment after taxes: $ 1147.50", paycheck1.toString());
    Assert.assertEquals("Payment after taxes: $ 297.00", paycheck2.toString());
  }
}
