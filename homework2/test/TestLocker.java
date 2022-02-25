import hw2.Locker;
import hw2.MailItem;
import hw2.Recipient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Room class.
 */

public class TestLocker {
  private Locker locker1;
  private MailItem mail1;
  private MailItem mail2;
  private Recipient recipient;
  private Recipient WrongRecipient;

  /**
   * Constructs two locker objects and initializes them.
   */

  @Before
  public void setUp() {
    locker1 = new Locker(2,3, 4);
    recipient = new Recipient("Zoe", "Lee", "zoelee@gmail.com");
    WrongRecipient = new Recipient("Dei", "Dei", "deidei@163.com");
    mail1 = new MailItem(1, 1, 1, recipient);
    mail2 = new MailItem(2, 1, 1, recipient);
  }

  /**
   * Test bad Locker examples.
   * width or length or depth smaller than 1.
   */
  @Test
  public void TestBadLocker() {
    try {
      Locker locker2 = new Locker(0, 1, 2);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadLocker caught") + e.getMessage());
    }
    try {
      Locker locker3 = new Locker(3, 0, 4);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadLocker caught") + e.getMessage());
    }
    try {
      Locker locker4 = new Locker(4, 7, 0);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadLocker caught") + e.getMessage());
    }
  }


  /**
   * Test pickUpMail method.
   */
  @Test
  public void TestpickUpMail() {
    locker1.addMail(mail1);
    // test pickupmail with wrong recipient
    Assert.assertNull(locker1.pickupMail(WrongRecipient));
    // test pickupmail with right recipient
    Assert.assertEquals(mail1, locker1.pickupMail(recipient));
    // test picupmail after the locker is empty
    Assert.assertNull(locker1.pickupMail(recipient));
  }

  /**
   * Test AddMail method.
   */
  @Test
  public void TestAddMail() {
    // check locker empty.
    Assert.assertNull(locker1.getMail());
    // check mail item after mail added.
    locker1.addMail(mail1);
    Assert.assertEquals(locker1.getMail(), mail1);
    // add another mail item and check again
    locker1.addMail(mail2);
    Assert.assertEquals(locker1.getMail(), mail1);
  }
}
