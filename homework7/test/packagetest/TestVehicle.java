package packagetest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.Boat;
import registration.IVehicle;
import registration.MotorCycle;

/**
 * This is a Test class for Vehicle.
 */
public class TestVehicle {
  IVehicle boat;
  IVehicle Automobile;
  IVehicle Motorcycle;

  /**
   * Declare and initialize IVehicle objects.
   */
  @Before
  public void SetUp() {
    boat = new Boat("ABV", 1978, 3000);
    Automobile = new Automobile("Auto", 1899, 7000);
    Motorcycle = new MotorCycle("Mobile", 2007, 35000);
  }

  /**
   * Test BadVehicle objects.
   */
  @Test
  public void TestNull() {
    try {
      IVehicle BadBoat = new Boat("", 1988, 6000);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test GetBrand method.
   */
  @Test
  public void TestGetBrand() {
    Assert.assertEquals("ABV", boat.getBrand());
    Assert.assertEquals("Auto", Automobile.getBrand());
    Assert.assertEquals("Mobile", Motorcycle.getBrand());
  }

  /**
   * Test GetProductionYear method.
   */
  @Test
  public void TestGetProductionYear() {
    Assert.assertEquals(1978, boat.getProductionYear());
    Assert.assertEquals(1899, Automobile.getProductionYear());
    Assert.assertEquals(2007, Motorcycle.getProductionYear());
  }

  /**
   * Test GetPrice method.
   */
  @Test
  public void TestGetPrice() {
    Assert.assertEquals(3000, boat.getPrice(), 0.0);
    Assert.assertEquals(7000, Automobile.getPrice(), 0.0);
    Assert.assertEquals(35000, Motorcycle.getPrice(), 0.0);
  }

  /**
   * Test GetPasNum method.
   */
  @Test
  public void TestGetPasNum() {
    Assert.assertEquals(10, boat.getPasNum());
    Assert.assertEquals(2, Motorcycle.getPasNum());
    Assert.assertEquals(5, Automobile.getPasNum());
  }

  /**
   * Test GetKind method.
   */
  @Test
  public void TestGetKind() {
    Assert.assertEquals(boat.getKind(), "boat");
    Assert.assertEquals(Automobile.getKind(), "auto");
    Assert.assertEquals(Motorcycle.getKind(), "motorcycle");
  }
}
