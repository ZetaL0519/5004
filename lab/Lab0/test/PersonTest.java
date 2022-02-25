import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Siyue Li 5004 Lab0 Spring 2022.
 * A JUnit test class for the Person class.
 */
public class PersonTest {
 
  private Person john;
  private Person sally;

  /**
   * Constructs two person objects and initializes them.
   */
  @Before
  public void setUp() {
    this.john = new Person("John", "Doe", 1945);
    this.sally = new Person("Sally", "Ride", 1951);
  }

  /**
   * Test the acuracy of the first name.
   */
  @Test
  public void testFirst() {
    assertEquals("John", this.john.getFirstName());
    assertEquals("Sally", this.sally.getFirstName());
  }

  /**
   *Test the accuracy of age.
   */
  @Test
  public void testAge() {
    assertEquals(75, this.john.getAge());
    assertEquals(69, this.sally.getAge());
  }

  /**
   * Test the accuary of full name.
   */
  @Test
  public void testFullName() {
    assertEquals("John Doe", this.john.getFullName());
    assertEquals("Sally Ride", this.sally.getFullName());
  }
}