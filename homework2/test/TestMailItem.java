import hw2.MailItem;
import hw2.Recipient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the MailItem class.
 */
public class TestMailItem {
  private MailItem mail1;

  /**
   * Constructs a mail item and initializes it.
   */
  @Before
  public void setUp() {
    mail1 = new MailItem(2, 3, 4, new Recipient("Zoe", "Lee", "zoelee@gmail.com"));

  }

  /**
   * Test bad mail which width, height or depth is less than 1 or recipient is null.
   */
  @Test
  public void TestBadMail() {
    // bad width
    try {
      MailItem mail2 = new MailItem(0, 1, 2, new Recipient("Zoe", "Lee", "zoelee@gmail.com"));
    } catch (IllegalArgumentException e) {
      System.out.println(("BadMail caught") + e.getMessage());
    }
    // bad recipient
    try {
      MailItem mail3 = new MailItem(2, 4, 5, null);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadMail caught") + e.getMessage());
    }
    // bad height
    try {
      MailItem mail3 = new MailItem(2, 0, 5, null);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadMail caught") + e.getMessage());
    }
    // bad depth
    try {
      MailItem mail3 = new MailItem(2, 9, 0, null);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadMail caught") + e.getMessage());
    }
  }

  /**
   * Test getWidth method.
   */
  @Test
  public void TestGetWidth() {
    Assert.assertEquals(2, mail1.getWidth());
  }

  /**
   * Test getHeight method.
   */
  @Test
  public void TestGetHeight() {
    Assert.assertEquals(3, mail1.getHeight());
  }

  /**
   * Test getDepth method.
   */
  @Test
  public void TestGetDepth() {
    Assert.assertEquals(4, mail1.getDepth());
  }

  /**
   * Test getRecipient method.
   */
  @Test
  public void TestGetRecipient() {
    Assert.assertEquals("Zoe Lee Email:zoelee@gmail.com", mail1.getRecipient().toString());
  }
}
