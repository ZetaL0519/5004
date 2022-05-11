package registration;

import java.util.List;

/**
 * This is an interface for Registration.
 */
public interface IRegistration {
  /**
   * This is a getter method for Registration year.
   * @return int registration year.
   */
  public int getRegistrationYear();

  /**
   * This is a getter method for production year.
   * @return int production year.
   */
  public int getProductionYear();

  /**
   * This is a getter method for Jurisdiction object.
   * @return IJurisdiction object.
   */
  public IJurisdiction getJurisdiction();

  /**
   * This is a getter method for List of Owners.
   * @return List of owners.
   */
  public List<Person> getOwners();      // return NON-MUTABLE list

  /**
   * This is a getter method for Max passengers.
   * @return passenger number.
   */
  public int getMaxPassengers();

  /**
   * This is a method for calculating tax.
   * @return int Excise tax.
   */
  public double calculateExciseTax();
}