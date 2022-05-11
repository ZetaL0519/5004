package registration;

import java.util.Objects;

/**
 * This is an abstract class for Vehicle.
 */
public abstract class AbstractVehicle implements IVehicle {
  protected String brand;
  protected int year;
  protected double price;

  /**
   * This is the constructor for Vehicle.
   *          @param brand Vehicle brand string.
   *          @param year Vehicle production year.
   *          @param price Vehicle price.
   *          @throws IllegalArgumentException
   *          If brand is empty, throw exception.
   */
  public AbstractVehicle(String brand, int year, double price) throws IllegalArgumentException {
    if (brand == null || brand.isEmpty()) {
      throw new IllegalArgumentException("brand is empty");
    }
    this.brand = brand;
    this.price = price;
    this.year = year;
  }

  /**
   * Get method for brand.
   * @return Vehicle brand string.
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Get method for production year.
   * @return year int.
   */
  public int getProductionYear() {
    return year;
  }

  /**
   * Get method for Vehicle price.
   * @return Vehicle Price double.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Equal method.
   * @param o Vehicle object.
   * @return boolean equal or not.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractVehicle that = (AbstractVehicle) o;
    return year == that.year && Double.compare(that.price, price) == 0 && brand.equals(that.brand);
  }

  /**
   * HashCode method.
   * @return hashcode of an object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(brand, year, price);
  }
}

