package hw2;

/**
 * This class represents a Room with roomType, price and guestNum.
 */
public class Room {
  private double price;
  private RoomType roomType;
  private int guestNum;

  /**
   * Construct a Room object with price and roomType as parameters.
   * guestNum is initialized to 0.
   * @param price Room price is field of Room object.
   * @param roomType roomType is an object of RoomType.
   * @throws IllegalArgumentException If price smaller than 0, throws exception.
   */
  public Room(RoomType roomType, double price) throws IllegalArgumentException {
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
    this.roomType = roomType;
    guestNum = 0;
  }

  /**
   * Check if the room is available.
   * If the guestNum bigger than 0, then unavailable.
   * @return boolean of availability
   */
  public boolean isAvailable() {
    return guestNum <= 0;
  }

  /**
   * Validate guest number if it is in the range of (0, maxNum] and it is still available.
   * @param guestNum The number of guests assigned to the room (int).
   */
  public void bookRoom(int guestNum) {
    if (this.isAvailable() && guestNum > 0 && guestNum <= roomType.getMaxOccupancy()) {
      this.guestNum = guestNum;
    }
  }

  /**
   * Return the number of guests.
   * @return guestNum The number of guests currently assigned to the room.
   */
  public int getNumberOfGuests() {
    return guestNum;
  }
}
