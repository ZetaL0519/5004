package registration;

/**
 * This is an interface for Vehicle.
 */
public interface IVehicle {

  /**
   * This is a getter method for Vehicle brand.
   * @return Vehicle brand.
   */
  String getBrand();

  /**
   * This is a getter method for Production year.
   * @return production year.
   */
  int getProductionYear();

  /**
   * This is a getter method for price.
   * @return vehicle price.
   */
  double getPrice();

  /**
   * This is a getter method for Passenger number.
   * @return passenger number.
   */
  int getPasNum();

  /**
   * This is a getter method for Vehicle kind.
   * @return Vehicle kind.
   */
  String getKind();
}
