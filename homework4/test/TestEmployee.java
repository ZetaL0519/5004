import employee.Employee;
import employee.IPaycheck;
import employee.SalariedPaycheck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is JUnit test class for employee class.
 */
public class TestEmployee {
  private Employee manager1;
  private Employee manager2;
  private Employee employee1;

  /**
   * Construct and initialize two different employee objects.
   */
  @Before
  public void SetUp() {
    manager1 = new Employee("Zac", "15732", 120000, 2, true);
    manager2 = new Employee("Zoe", "15733", 140000, 2, false);
    employee1 = new Employee("Garry", "14790", 40, 2);
  }

  /**
   * Test bad Salaried employee with null name or id or wrong pay interval.
   */
  @Test
  public void testBadSalariedEmployee() {
    try {
      Employee manager2 = new Employee("", "78", 124380, 4, false);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }

    try {
      Employee manager3 = new Employee("Zac", null, 124380, 4, false);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }

    try {
      Employee manager3 = new Employee("Zac", "24356", 124380, 5, false);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }

    try {
      Employee manager3 = new Employee("Zac", "24356", 124380, -8, false);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }
  }

  /**
   * Test bad hourly employee for null name or null id or negative hoursworked.
   */
  @Test
  public void TestBadHourlyEmp() {
    try {
      Employee employee2 = new Employee("", "78", 124380, 4);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }

    try {
      Employee employee2 = new Employee("Zav", "", 124380, 4);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }

    try {
      Employee employee2 = new Employee("Zav", "78", 124380, -9);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadEmployee caught") + e.getMessage());
    }
  }

  /**
   * Test IsManager method.
   */
  @Test
  public void TestIsManager() {
    Assert.assertTrue(manager1.isManager());
    Assert.assertFalse(manager2.isManager());
  }

  /**
   * Test GetPaycheck method.
   */
  @Test
  public void TestGetPaycheck() {
    IPaycheck manager1Paycheck = manager1.getPaycheck();
    SalariedPaycheck paycheck1 = new SalariedPaycheck(120000, 2);
    Assert.assertEquals(paycheck1, manager1Paycheck);

    IPaycheck manager2Paycheck = manager2.getPaycheck();
    SalariedPaycheck paycheck2 = new SalariedPaycheck(140000, 2);
    Assert.assertEquals(paycheck2, manager2Paycheck);
  }


  /**
   * Test ToString method of employee.
   */
  @Test
  public void TestToString() {
    // Salaried employee
    String manager1String = manager1.toString();
    String testManager1 = "Name: Zac\n" + "ID: 15732\n" + "Payment after taxes: $ 3923.08";
    Assert.assertEquals(manager1String, testManager1);

    String manager2String = manager2.toString();
    String testManager2 = "Name: Zoe\n" + "ID: 15733\n" + "Payment after taxes: $ 4576.92";
    Assert.assertEquals(manager2String, testManager2);

    // hourly employee
    String employee1String = employee1.toString();
    String testEmployee1 = "Name: Garry\n" + "ID: 14790\n" + "Payment after taxes: $ 72.00";
    Assert.assertEquals(employee1String, testEmployee1);
  }
}
