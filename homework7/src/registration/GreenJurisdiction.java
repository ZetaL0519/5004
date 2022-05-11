package registration;

/**
 * This is a GreenJurisdiction class.
 */
public class GreenJurisdiction implements IJurisdiction {
  private static double taxPct = 0.04;

  /**
   * This is a method for calculating tax.
   *    @param vehicle IVehicle object.
   *    @return tax of the Vehicle.
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    if (vehicle == null) {
      return 0.0;
    }
    return taxPct * vehicle.getPrice() + 100 * vehicle.getPasNum();
  }

  /**
   * ToString method for greenJurisdiction.
   * @return Jurisdiction kind.
   */
  @Override
  public String toString() {
    return "GreenJurisdiction";
  }
}
