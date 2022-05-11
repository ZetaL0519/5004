package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This is a RegistrationSystem class.
 */
public class RegistrationSystem {
  private static RegistrationSystem instance = new RegistrationSystem();
  private List<IRegistration> RegList = new ArrayList<>();
  private List<IRegistration> InfoList;

  /**
   * This is a constructor for registration system.
   */
  private RegistrationSystem() {
    InfoList = new ArrayList<>();
  }

  /**
   *  get an instance of the registration system.
   * @return the single instance of the RegistrationSystem
   */
  public static RegistrationSystem getInstance() {
    return instance;
  }

  /**
   * Create an instance of vehicle.
   *        @param kind a String describing the type of vehicle ("Boat", "Auto", or "Motorcycle").
   *        @param make a String describing the make of vehicle ("BMW", "Mercury Marine", etc.).
   *        @param productionYear an integer describing the production year.
   *        @param purchasePrice a double describing the purchase price.
   *        @return an IVehicle object.
   *        @throws IllegalArgumentException
   *        If make or year or price is not right.
   */
  public IVehicle createVehicle(String kind, String make, int productionYear, double purchasePrice)
          throws  IllegalArgumentException {
    if (kind == null || kind.length() == 0) {
      throw new IllegalArgumentException("king missing");
    }
    if (make == null || make.isEmpty()) {
      throw new IllegalArgumentException("Empty make string");
    }
    if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Wrong production year");
    }
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Negative purchase price");
    }
    if (kind.equalsIgnoreCase("boat")) {
      return new Boat(make, productionYear, purchasePrice);
    }
    if (kind.equalsIgnoreCase("auto")) {
      return new Automobile(make, productionYear, purchasePrice);
    }
    if (kind.equalsIgnoreCase("motorcycle")) {
      return new MotorCycle(make, productionYear, purchasePrice);
    }
    return null;
  }

  /**
   * Adds a new vehicle registration to the system.
   *    @param vehicle IVehicle object.
   *    @param jurisdiction IJurisdiction object.
   *    @param registrationYear registration year.
   *    @param owners list of arrays.
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction,
                       int registrationYear, List<Person> owners) {
    IRegistration newReg = new Registration(registrationYear, jurisdiction, owners, vehicle);

    for (IRegistration each: InfoList) {
      if (each.equals(newReg)) {
        return;
      }
    }
    InfoList.add(newReg);
  }

  /**
   * Return an unmodifiable list of Registrations.
   * @return ArrayList of registrations.
   */
  public List<IRegistration> getAllRegistrations() {
    return Collections.unmodifiableList(new ArrayList<>(this.InfoList));
  }

  /**
   * This is a filter method.
   *    @param query Predicate of filter.
   *    @return an unmodifiable list of registrations.
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    RegList = InfoList.stream().filter(query).collect(Collectors.toList());
    return Collections.unmodifiableList(new ArrayList<>(this.RegList));
  }

  /**
   *  Resets the state of the RegistrationSystem.
   */
  public void reboot() {
    InfoList.clear();
    RegList.clear();
  }
}
