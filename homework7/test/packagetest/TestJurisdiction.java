package packagetest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import registration.BlueJurisdiction;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IVehicle;
import registration.MotorCycle;
import registration.RedJurisdiction;

/**
 * This is a test class for Jurisdiction class.
 */
public class TestJurisdiction {
  IJurisdiction jurisdictionGreen;
  IJurisdiction jurisdictionRed;
  IJurisdiction jurisdictionBlue;
  IVehicle vehicle1;
  IVehicle vehicle2;

  /**
   * Initialize new Jurisdiction objects.
   */
  @Before
  public void SetUp() {
    jurisdictionBlue = new BlueJurisdiction();
    jurisdictionGreen = new GreenJurisdiction();
    jurisdictionRed = new RedJurisdiction();
    vehicle1 = new MotorCycle("Kia", 1998, 56000);
    vehicle2 = new MotorCycle("Honda", 2006, 78000);
  }

  /**
   * Test ExciseTax method.
   */
  @Test
  public void TestExciseTax() {
    double blueTax1 = jurisdictionBlue.exciseTax(vehicle1);
    Assert.assertEquals(1779, blueTax1, 0.0);
    double blueTax2 = jurisdictionBlue.exciseTax(vehicle2);
    Assert.assertEquals(2340, blueTax2, 0.0);
    double redTax = jurisdictionRed.exciseTax(vehicle1);
    Assert.assertEquals(2800, redTax, 0.0);
    double greenTax = jurisdictionGreen.exciseTax(vehicle1);
    Assert.assertEquals(greenTax, 2440, 0.0);
  }

  /**
   * Test toString method.
   */
  @Test
  public void TestToString() {
    String greenString = "GreenJurisdiction";
    String redString = "RedJurisdiction";
    String blueString = "BlueJurisdiction";
    Assert.assertEquals(greenString, jurisdictionGreen.toString());
    Assert.assertEquals(redString, jurisdictionRed.toString());
    Assert.assertEquals(blueString, jurisdictionBlue.toString());
  }
}
