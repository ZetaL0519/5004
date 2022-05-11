package registration;

/**
 * This is a class for Person.
 */
public class Person {
  private String name;
  private String address;

  /**
   * This is a constructor for Person.
   *    @param name Person name.
   *    @param address Person address.
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * This is a getter method for Name.
   * @return name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * This is a getter method for address.
   * @return person address.
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * This is a toString method.
   * @return String form of Person.
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }
}