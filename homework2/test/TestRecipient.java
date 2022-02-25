import hw2.MailItem;
import hw2.Recipient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Recipient class.
 */
public class TestRecipient {
  private Recipient recipient1;

  /**
   * Construct a Recipient object.
   */
  @Before
  public void setUp() {
    recipient1 = new Recipient("Zoe", "Lee", "zoelee@gmail.com");
  }

  /**
   * Test bad recipient with null first, last name or email OR if any of those strings is empty.
   */
  @Test
  public void testBadRecipient() {
    // bad first name
    try {
      Recipient recipient2 = new Recipient(null, "Lee", "zoelee@gmail.com");
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRecipient caught") + e.getMessage());
    }
    // bad last name
    try {
      Recipient recipient3 = new Recipient("Zoe", "", "zoelee@gmail.com");
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRecipient caught") + e.getMessage());
    }
    // bad email
    try {
      Recipient recipient4 = new Recipient("Zoe", "", "");
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRecipient caught") + e.getMessage());
    }
  }

  /**
   * Test String form of the recipient information.
   */
  @Test
  public void testtoString() {
    Assert.assertEquals("Zoe Lee Email:zoelee@gmail.com", recipient1.toString());
  }
}
