package hw2;

/**
 * This class represents a recipient with first name, last name and email.
 */
public class Recipient {
  private String FirstName;
  private String LastName;
  private String Email;

  /**
   * Construct a recipient object with first name, last name and email.
   *      @param FirstName This is the recipient's first name.
   *      @param LastName This is the recipient's last name.
   *      @param Email This is the recipient's email.
   *      @throws IllegalArgumentException
   *      If any of those parameters is null OR if any of those strings is empty,
   *      IllegalArgumentException would be raised.
   */
  public Recipient(String FirstName, String LastName, String Email)
          throws IllegalArgumentException {
    if (FirstName == null || LastName == null || Email == null
            || FirstName.length() == 0 || LastName.length() == 0 || Email.length() == 0) {
      throw new IllegalArgumentException("String cannot be empty.");
    }
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.Email = Email;
  }

  /**
   * Return a string with recipient first and last name and email.
   * @return String form of  recipient first and last name and email.
   */
  public String toString() {
    return this.FirstName + " " + this.LastName + " Email:" + this.Email;
  }
}
