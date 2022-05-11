package registration;

/**
 * This is a class for BlueJurisdiction.
 */
public class BlueJurisdiction implements IJurisdiction {
  private static double taxPct = 0.03;

  /**
   * This is a method for calculating tax.
   *    @param vehicle IVehicle object.
   *    @return the tax amount of the Vehicle.
   */
  @Override
  public double exciseTax(IVehicle vehicle) {

    if (vehicle == null) {
      return 0.0;
    }
    if (vehicle.getProductionYear() < 2000) {
      return 99 + taxPct * vehicle.getPrice();
    }
    return taxPct * vehicle.getPrice();
  }

  /**
   * This is an overriding method of toString.
   * @return String of Jurisdiction kind.
   */
  @Override
  public String toString() {
    return "BlueJurisdiction";
  }
}
