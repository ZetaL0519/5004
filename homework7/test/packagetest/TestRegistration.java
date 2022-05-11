package packagetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.MotorCycle;
import registration.Person;
import registration.Registration;

/**
 * This is a test class for Registration.
 */
public class TestRegistration {
  IVehicle motorcycle;
  Person owner1;
  Person owner2;
  List<Person> ownerList1;
  List<Person> ownerList2;
  IJurisdiction GreenJurisdiction;
  IRegistration registration;

  /**
   * Declare and initialize objects.
   */
  @Before
  public void SetUp() {
    motorcycle = new MotorCycle("Kia", 1988, 88000);
    owner1 = new Person("Zoe Lee", "Shanghai");
    owner2 = new Person("JaneGI", "LA");
    ownerList1 = new ArrayList<>();
    ownerList2 = new ArrayList<>();
    ownerList1.add(owner1);
    ownerList1.add(owner2);
    GreenJurisdiction = new GreenJurisdiction();
    registration = new Registration(2005, GreenJurisdiction, ownerList1, motorcycle);
  }

  /**
   * Test Bad Registration.
   */
  @Test
  public void TestBadRegistration() {
    try {
      IRegistration registration1 = new Registration(2006,
              null, ownerList1, motorcycle);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      IRegistration registration2 = new Registration(2008,
              GreenJurisdiction, ownerList1, null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      IRegistration registration3 = new Registration(2005,
              GreenJurisdiction, ownerList2, motorcycle);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test GetRegistrationYear method.
   */
  @Test
  public void TestGetRegistrationYear() {
    Assert.assertEquals(registration.getRegistrationYear(), 2005);
  }

  /**
   * Test GetProductionYear method.
   */
  @Test
  public void TestGetProductionYear() {
    Assert.assertEquals(registration.getProductionYear(), 1988);
  }

  /**
   * Test GetJurisdiction method.
   */
  @Test
  public void TestGetJurisdiction() {
    Assert.assertEquals(GreenJurisdiction, registration.getJurisdiction());
  }

  /**
   * Test GetOwners method.
   */
  @Test
  public void TestGetOwners() {
    Assert.assertEquals(ownerList1, registration.getOwners());
  }

  /**
   * Test GetMaxPassenger method.
   */
  @Test
  public void TestGetMaxPassenger() {
    Assert.assertEquals(2, registration.getMaxPassengers());
  }

  /**
   * Test CalculateTax method.
   */
  @Test
  public void TestCalculateTax() {
    Assert.assertEquals(3720 ,registration.calculateExciseTax(), 0.0);
  }

  /**
   * Test ToString method.
   */
  @Test
  public void TestToString() {
    String string1 = "Registration: \n" + "MOTORCYCLE: Kia Year(1988)  " + "Price = $88000.00\n"
            + "Owned By: " + "Zoe Lee, Shanghai; JaneGI, LA \n" + "Year: 2005\n"
            + "GreenJurisdiction Excise Tax: $3720.00";
    Assert.assertEquals(string1, registration.toString());
  }
}
