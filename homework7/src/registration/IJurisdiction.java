package registration;

/**
 * This is an interface for Jurisdiction.
 */
public interface  IJurisdiction {

  /**
   * This is a method for calculating excise tax.
   *    @param vehicle Vehicle object.
   *    @return 0.0.
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}