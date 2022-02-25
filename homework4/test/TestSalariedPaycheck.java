import employee.SalariedPaycheck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit class for salaried paycheck.
 */
public class TestSalariedPaycheck {
  private SalariedPaycheck salariedPaycheck1;
  private SalariedPaycheck salariedPaycheck2;

  /**
   * Construct and initialize salaried paycheck objects.
   */
  @Before
  public void SetUp() {
    salariedPaycheck1 = new SalariedPaycheck(120000, 4);
    salariedPaycheck2 = new SalariedPaycheck(5200,2 );
  }

  /**
   * Test Bad salaried paycheck for negative pay rate and pay interval.
   */
  @Test
  public void TestBadSalariedPaycheck() {
    try {
      SalariedPaycheck salariedPaycheck2 = new SalariedPaycheck(-90, 4);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadSalariedPaycheck caught. Pay rate under 0") + e.getMessage());
    }

    try {
      SalariedPaycheck salariedPaycheck3 = new SalariedPaycheck(80000, 7);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadSalariedPaycheck caught. Interval under 0") + e.getMessage());
    }
  }

  /**
   * Test getTotalPay method.
   */
  @Test
  public void TestGetTotalPay() {
    double PayTotal1 = (double) 120000 * 4 / 52;
    Assert.assertEquals(PayTotal1, salariedPaycheck1.getTotalPay(), 0.001);
    double PayTotal2 = (double) 5200 * 2 / 52;
    Assert.assertEquals(PayTotal2, salariedPaycheck2.getTotalPay(), 0.001);
  }

  /**
   * Test GetTotalPayAfterTax method.
   */
  @Test
  public void TestGetTotalPayAfterTax() {
    double PayAfterTax1 = (double)0.85 * 120000 * 4 / 52;
    Assert.assertEquals(PayAfterTax1, salariedPaycheck1.getPayAfterTaxes(), 0.001);
    double PayAfterTax2 = (double) 0.9 * 5200 * 2 / 52;
    Assert.assertEquals(PayAfterTax2, salariedPaycheck2.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test GetPayRate method.
   */
  @Test
  public void TestGetPayRate() {
    Assert.assertEquals(salariedPaycheck1.getPayRate(), 120000, 0.001);
    Assert.assertEquals(salariedPaycheck2.getPayRate(), 5200, 0.001);
  }

  /**
   * Test GetPayInterval method.
   */
  @Test
  public void TestGetPayInterval() {
    Assert.assertEquals(salariedPaycheck1.getPayInterval(), 4);
    Assert.assertEquals(salariedPaycheck2.getPayInterval(), 2);
  }
}
