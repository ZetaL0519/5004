package registration;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This is a Registration class.
 */
public class Registration implements IRegistration {
  private int RegistrationYear;
  private IJurisdiction Jurisdiction;
  private List<Person> owners;
  private IVehicle vehicle;

  /**
   * This is a constructor for Registration.
   *        @param RegistrationYear registration year.
   *        @param Jurisdiction Jurisdiction object.
   *        @param owners List of owners.
   *        @param vehicle Vehicle object.
   *        @throws IllegalArgumentException
   *        If jurisdiction, owners, vehicle is null,
   *        throw illegal exception.
   */
  public Registration(int RegistrationYear, IJurisdiction Jurisdiction,
                      List<Person> owners, IVehicle vehicle) throws IllegalArgumentException {
    if (Jurisdiction == null || owners == null || owners.size() == 0 || vehicle == null) {
      throw new IllegalArgumentException("Info Missing");
    }
    this.RegistrationYear = RegistrationYear;
    this.Jurisdiction = Jurisdiction;
    this.owners = owners;
    this.vehicle = vehicle;
  }

  /**
   * This is a getter method for registration year.
   * @return registration year.
   */
  @Override
  public int getRegistrationYear() {
    return RegistrationYear;
  }

  /**
   * This is a getter method for production year.
   * @return vehicle production year.
   */
  @Override
  public int getProductionYear() {
    return vehicle.getProductionYear();
  }

  /**
   * This is a getter method for Jurisdiction object.
   * @return Jurisdiction object.
   */
  @Override
  public IJurisdiction getJurisdiction() {
    return Jurisdiction;
  }

  /**
   * This is a getter method for owner list.
   * @return List of owners.
   */
  @Override
  public List<Person> getOwners() {
    return owners;
  }

  /**
   * This is a getter method for vehicle passenger number.
   * @return vehicle passenger number.
   */
  @Override
  public int getMaxPassengers() {
    return vehicle.getPasNum();
  }

  /**
   * This a getter method for vehicle excise tax.
   * @return vehicle excise tax.
   */
  @Override
  public double calculateExciseTax() {
    return Jurisdiction.exciseTax(vehicle);
  }

  /**
   * This is an equal method.
   *    @param o Registration object.
   *    @return boolean whether two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Registration that = (Registration) o;
    return RegistrationYear == that.RegistrationYear
            && Objects.equals(owners, that.owners) && Objects.equals(vehicle, that.vehicle);
  }

  /**
   * This is a hashcode method.
   * @return hash code of the Registration object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(RegistrationYear, owners, vehicle);
  }

  /**
   * This is a toString method.
   * @return String form of Registration form.
   */
  @Override
  public String toString() {
    String kind = vehicle.getKind().toUpperCase();
    String brand = vehicle.getBrand();
    String JurisKind = Jurisdiction.toString();
    int productionYear = vehicle.getProductionYear();
    double price = vehicle.getPrice();
    DecimalFormat format = new DecimalFormat("$0.00");
    String formatPrice = format.format(price);
    String tax = format.format(calculateExciseTax());
    String joinedOwners = owners.stream().map(Person::toString)
            .collect(Collectors.joining("; ", " ", " "));
    return "Registration: \n"
            + kind + ": " + brand + " Year("
            + productionYear + ")  "
            + "Price = " + formatPrice + "\n"
            + "Owned By:" + joinedOwners + "\n"
            + "Year: " + getRegistrationYear() + "\n"
            + JurisKind + " Excise Tax: " + tax;
  }
}
