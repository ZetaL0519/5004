import employee.HourlyPaycheck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit class for Hourly paycheck.
 */
public class TestHourlyPaycheck {
  private HourlyPaycheck HourPaycheck1;
  private HourlyPaycheck HourPaycheck2;

  /**
   * Construct and initialize the hourlypaycheck objects.
   */
  @Before
  public void SetUp() {
    HourPaycheck1 = new HourlyPaycheck(60, 80);
    HourPaycheck2 = new HourlyPaycheck(10, 30);
  }

  /**
   * Test bad hourly paycheck with negative payrate or hours worked.
   */
  @Test
  public void TestBadHourlyCheck() {
    try {
      HourlyPaycheck HourPaycheck3 = new HourlyPaycheck(-8, 30);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadHourlyPaycheck caught") + e.getMessage());
    }

    try {
      HourlyPaycheck HourlyPaycheck4 = new HourlyPaycheck(8, -8);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadHourlyPaycheck caught") + e.getMessage());
    }
  }

  /**
   * Test GetTotalPay method.
   */
  @Test
  public void TestGetTotalPay() {
    // Over 40 hours;
    Assert.assertEquals(HourPaycheck1.getTotalPay(), 40 * 60 + 1.5 * 40 * 60, 0.001);
    // Below 40 hours;
    Assert.assertEquals(HourPaycheck2.getTotalPay(), 10 * 30, 0.001);
  }

  /**
   * Test GetTotalPayAfterTax method.
   */
  @Test
  public void TestGetTotalPayAfterTax() {
    // Test after tax pay above 400.
    Assert.assertEquals(HourPaycheck1.getPayAfterTaxes(), 0.85 * (40 * 60 + 1.5 * 40 * 60), 0.001);

    // Test after tax pay below 400.
    Assert.assertEquals(HourPaycheck2.getPayAfterTaxes(), 0.9 * 10 * 30, 0.001);

    // Test after tax pay if total pay is within the range of (0, 0.01).
    HourPaycheck1.resetHoursWorked();
    HourPaycheck1.addHoursWorked(0.0001);
    Assert.assertEquals(0.01, HourPaycheck1.getPayAfterTaxes(), 0.001);

    // Test after tax pay if total pay is under 0.
    HourPaycheck1.resetHoursWorked();
    HourPaycheck1.addHoursWorked(-2);
    Assert.assertEquals(0, HourPaycheck1.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test GetPayRate method.
   */
  @Test
  public void TestGetPayRate() {
    Assert.assertEquals(HourPaycheck1.getPayRate(), 60, 0.001);
    Assert.assertEquals(HourPaycheck2.getPayRate(), 10, 0.001);
  }

  /**
   * Test AddHoursWorked method.
   */
  @Test
  public void TestAddHoursWorked() {
    Assert.assertEquals(80, HourPaycheck1.getHoursWorked(), 0.001);
    HourPaycheck1.addHoursWorked(-79);
    Assert.assertEquals(1, HourPaycheck1.getHoursWorked(), 0.001);
    HourPaycheck1.addHoursWorked(-2);
    Assert.assertEquals(0, HourPaycheck1.getHoursWorked(), 0.001);
  }

  /**
   * Test ResetHours method.
   */
  @Test
  public void TestResetHours() {
    HourPaycheck1.resetHoursWorked();
    Assert.assertEquals(0, HourPaycheck1.getHoursWorked(), 0.001);

    HourPaycheck2.resetHoursWorked();
    Assert.assertEquals(0, HourPaycheck2.getHoursWorked(), 0.001);
  }

  /**
   * Test toString method.
   */
  @Test
  public void TestToString() {
    String HourPaycheck1String = HourPaycheck1.toString();
    String output = "Payment after taxes: $ 5100.00";
    Assert.assertEquals(output, HourPaycheck1String);

    String HourPaycheck2String = HourPaycheck2.toString();
    String output2 = "Payment after taxes: $ 270.00";
    Assert.assertEquals(output2, HourPaycheck2String);
  }
}
