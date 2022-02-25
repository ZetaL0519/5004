package hw2;

/**
 * This class represents a MailItem class with width, height, depth and recipient.
 */
public class MailItem {
  private int width;
  private int height;
  private int depth;
  private Recipient Recipient;

  /**
   * Constructs a MailItem object with width, height, depth and recipient.
   *      @param width This is the width of mail item.
   *      @param height This is the height of mail item.
   *      @param depth This is the depth of mail item.
   *      @param Recipient This is the recipient of mail item.
   *      @throws IllegalArgumentException
   *      If width, height or depth is less than 1, IllegalArgumentException will be raised.
   */
  public MailItem(int width, int height, int depth, Recipient Recipient)
          throws IllegalArgumentException {
    if (width < 1 || height < 1 || depth < 1 || Recipient == null) {
      throw new IllegalArgumentException("Length cannot be less than 1.");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.Recipient = Recipient;
  }

  /**
   * Return the recipient of mail item.
   * @return recipient The recipient of mail item.
   */
  public Recipient getRecipient() {
    return Recipient;
  }

  /**
   * Return the width of mail item.
   * @return width The width of mail item.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Return the height of mail item.
   * @return height The height of mail item.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Return the depth of mail item.
   * @return height The depth of mail item.
   */
  public int getDepth() {
    return depth;
  }
}
