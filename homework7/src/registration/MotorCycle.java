package registration;

/**
 * This is a class for Motorcycle.
 */
public class MotorCycle extends AbstractVehicle implements IVehicle {
  private static final int PasNum = 2;

  /**
   * This is a constructor for MotorCycle.
   *    @param brand Motorcycle brand.
   *    @param year MotorCycle production year.
   *    @param price MotorCycle price.
   */
  public MotorCycle(String brand, int year, double price) {
    super(brand, year, price);
  }

  /**
   * This is a getter method for passenger number.
   * @return PasNum passenger number.
   */
  @Override
  public int getPasNum() {
    return PasNum;
  }

  /**
   * This is a getter method for kind.
   * @return vehicle kind.
   */
  @Override
  public String getKind() {
    return "motorcycle";
  }
}
