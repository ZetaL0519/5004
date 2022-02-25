package hw2;

/**
 * This class represents a Locker class with maxWidth, maxHeight, maxDepth.
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  public MailItem inMail;

  /**
   * Constructs a Locker object with maxWidth, maxHeight and maxDepth.
   *      @param maxWidth This is the max Width of locker object.
   *      @param maxHeight This is the max Height of locker object.
   *      @param maxDepth This is the max Depth of locker object.
   *      @throws IllegalArgumentException
   *      If any of those parameters is less than 1, IllegalArgumentException would be raised.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws IllegalArgumentException {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException("Max length cannot be less than 1");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    inMail = null;
  }

  /**
   * This method stores the mail item in a locker if the locker is not occupied.
   * and the mail item within the dimensions of the locker.
   * @param mail Mail item that is added to the locker
   */
  public void addMail(MailItem mail) {
    if (mail.getDepth() <= maxDepth && mail.getHeight() <= maxHeight
            && mail.getWidth() <= maxWidth && inMail == null) {
      inMail = mail;
    }
  }

  public MailItem getMail() {
    return inMail;
  }

  /**
   *  This method remove and returns the mail item from the locker under the following conditions:
   *  IF there is a mail item in the locker,
   *  AND the recipient passed to pickupMail matches the recipient of the mail item.
   * @param recipient the recipient passed to pickupMail.
   * @return MailItem
   */
  public MailItem pickupMail(Recipient recipient) {
    if (inMail != null && inMail.getRecipient() == recipient) {
      MailItem mail = inMail;
      inMail = null;
      return mail;
    } else {
      return null;
    }
  }
}
