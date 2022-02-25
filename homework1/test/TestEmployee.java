import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Siyue Li 5004 HW1 Spring 2022.
 * A JUnit test class for the Employee class.
 */
public class TestEmployee {
  private Employee employee1;
  private Employee employee2;

  /**
   * Constructs two Employee objects and initializes them.
   * Add and subtract working hours to each employee.
   */
  @Before
  public void Setup() {
    employee1 = new Employee("Zoe", "1557929", 15);
    employee2 = new Employee("Ben", "1557927", 11);
    employee1.addHoursWorked(80);
    employee2.addHoursWorked(100);
    employee2.addHoursWorked(-20);
  }

  /**
   * Reset working hours to 0.
   * Test the Employee method: resetHoursWorked which sets hours to 0.
   */
  @Test
  public void TestresetHoursWorked() {
    employee1.resetHoursWorked();
    employee2.resetHoursWorked();
    Assert.assertEquals(0, employee1.getHoursWorked(), 0.001);
    Assert.assertEquals(0, employee2.getHoursWorked(), 0.001);
  }

  /**
   * Test the addHoursWorked method of Employee class.
   */
  @Test
  public void TestaddHoursWorked() {
    Assert.assertEquals(80, employee1.getHoursWorked(), 0.001);
    Assert.assertEquals(80, employee2.getHoursWorked(), 0.001);
  }

  /**
   * Test the accuracy of String form of name, ID and payment after taxes.
   */
  @Test
  public void TesttoString() {
    String string1 = "Name: Zoe\n" + "ID: 1557929\n" + "Payment after taxes: $ 1275.00";
    String string2 = "Name: Ben\n" + "ID: 1557927\n" + "Payment after taxes: $ 935.00";
    Assert.assertEquals(string1, employee1.toString());
    Assert.assertEquals(string2, employee2.toString());
  }
}
