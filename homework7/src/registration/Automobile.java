package registration;

/**
 * This is AutoMobile class.
 */
public class Automobile extends AbstractVehicle implements IVehicle {
  private static final int PasNum = 5;

  /**
   * Constructor for Automobile type vehicle.
   *    @param brand automobile brand.
   *    @param year automobile production year.
   *    @param price automobile price.
   */
  public Automobile(String brand, int year, double price) {
    super(brand, year, price);
  }

  /**
   * Getter method for Passenger number.
   * @return Passenger number.
   */
  public int getPasNum() {
    return PasNum;
  }

  /**
   * Getter method for the kind.
   * @return "auto.
   */
  @Override
  public String getKind() {
    return "auto";
  }
}
