package packagetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.MotorCycle;
import registration.Person;
import registration.RegistrationSystem;

/**
 * This is test class for RegistrationSystem.
 */
public class TestRegistrationSystem {
  RegistrationSystem RegSys;
  IVehicle vehicle;
  IJurisdiction Green;
  List<Person> ownerList;
  Person owner1;
  int RegYear;

  /**
   * Declare and initialize RegistrationSystem.
   */
  @Before
  public void SetUp() {
    RegSys = RegistrationSystem.getInstance();
  }

  /**
   * This is a test for bad CreateVehicle method.
   */
  @Test
  public void TestBadCreateVehicle() {
    try {
      RegSys.createVehicle("", "Kia", 1998, 7800);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      RegSys.createVehicle("MotorCycle", "", 1997, 90);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      RegSys.createVehicle("MotorCycle", "Kia", 2024, 9000);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      RegSys.createVehicle("MotorCycle", "Kia", 2008, -9);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test CreateVehicle method.
   */
  @Test
  public void TestCreateVehicle() {
    IVehicle motorVehicle = RegSys.createVehicle("MotorCycle", "Kia", 1988, 9000.0);
    IVehicle motorVehicleRep = new MotorCycle("Kia", 1988, 9000.0);
    Assert.assertEquals(motorVehicle, motorVehicleRep);
  }

  /**
   * Test Register method.
   */
  @Test
  public void TestRegister() {
    RegSys.reboot();
    vehicle = new MotorCycle("Kia", 1998, 98000);
    ownerList = new ArrayList<>();
    owner1 = new Person("John", "123 Heaven");
    ownerList.add(owner1);
    RegYear = 2006;
    Green = new GreenJurisdiction();
    RegSys.register(vehicle, Green, RegYear, ownerList);
    Assert.assertEquals(RegSys.getAllRegistrations().size(), 1);

    vehicle = new Automobile("Kia", 2001, 21000);
    ownerList = new ArrayList<>();
    owner1 = new Person("Zoe", "Boston");
    ownerList.add(owner1);
    RegYear = 2005;
    RegSys.register(vehicle, Green, RegYear, ownerList);

    Assert.assertEquals(RegSys.getAllRegistrations().size(), 2);
  }

  /**
   * Test Register Duplicate.
   */
  @Test
  public void TestDuplicate() {
    RegSys.reboot();
    vehicle = new MotorCycle("Kia", 1998, 98000);
    ownerList = new ArrayList<>();
    owner1 = new Person("John", "123 Heaven");
    ownerList.add(owner1);
    RegYear = 2006;
    Green = new GreenJurisdiction();
    RegSys.register(vehicle, Green, RegYear, ownerList);
    Assert.assertEquals(RegSys.getAllRegistrations().size(), 1);

    RegSys.register(vehicle, Green, RegYear, ownerList);
    Assert.assertEquals(RegSys.getAllRegistrations().size(), 1);
  }

  /**
   * Test GetAllRegistration method List immutable.
   */
  @Test
  public void TestGetAllRegistrations() {
    RegSys.reboot();
    vehicle = new MotorCycle("Kia", 1998, 98000);
    ownerList = new ArrayList<>();
    owner1 = new Person("John", "123 Heaven");
    ownerList.add(owner1);
    RegYear = 2006;
    Green = new GreenJurisdiction();
    RegSys.register(vehicle, Green, RegYear, ownerList);

    try {
      RegSys.getAllRegistrations().clear();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Test getFilteredList method.
   */
  @Test
  public void TestGetFilteredList() {
    RegSys.reboot();
    vehicle = new MotorCycle("Kia", 1998, 98000);
    ownerList = new ArrayList<>();
    owner1 = new Person("John", "123 Heaven");
    ownerList.add(owner1);
    RegYear = 2006;
    Green = new GreenJurisdiction();
    RegSys.register(vehicle, Green, RegYear, ownerList);

    vehicle = new Automobile("Kia", 2001, 21000);
    ownerList = new ArrayList<>();
    owner1 = new Person("Zoe", "Boston");
    ownerList.add(owner1);
    RegYear = 2005;
    RegSys.register(vehicle, Green, RegYear, ownerList);
    Assert.assertEquals(RegSys.getAllRegistrations().size(), 2);

    List<IRegistration> FilterList = RegSys.getFilteredList((IRegistration r)
            -> r.getProductionYear() > 2000);
    Assert.assertEquals(FilterList.size(), 1);
  }

  /**
   * Test reboot method.
   */
  @Test
  public void TestReboot() {
    RegSys.reboot();
    Assert.assertEquals(RegSys.getAllRegistrations().size(), 0);
  }
}
