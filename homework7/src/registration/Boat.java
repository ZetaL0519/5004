package registration;

/**
 * This is a class for Boat.
 */
public class Boat extends AbstractVehicle implements IVehicle {
  private static int PasNum = 10;

  /**
   * This is the constructor for Boat.
   *    @param brand Boat brand.
   *    @param year Boat production year.
   *    @param price Boat price.
   */
  public Boat(String brand, int year, double price) {
    super(brand, year, price);
  }

  /**
   * Getter method for Passenger number.
   * @return Passenger number.
   */
  @Override
  public int getPasNum() {
    return PasNum;
  }

  /**
   * Getter method for Vehicle Kind.
   * @return Boat.
   */
  @Override
  public String getKind() {
    return "boat";
  }

}
