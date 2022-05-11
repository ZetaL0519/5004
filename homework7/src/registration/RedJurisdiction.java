package registration;

/**
 * This is a RedJurisdiction class.
 */
public class RedJurisdiction implements IJurisdiction {
  private static double taxPct = 0.05;

  /**
   * This is a method for calculating tax.
   *    @param vehicle Vehicle object.
   *    @return excise tax.
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    if (vehicle == null) {
      return 0.0;
    }
    return taxPct * vehicle.getPrice();
  }

  /**
   * This is a toString method.
   * @return String form of jurisdiction.
   */
  @Override
  public String toString() {
    return "RedJurisdiction";
  }
}
