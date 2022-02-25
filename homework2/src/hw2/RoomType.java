package hw2;

/**
 * This is an enum of RoomType that represents 3 categories:Single, Double and Family rooms.
 */
public enum RoomType {
  SINGLE(1), DOUBLE(2), FAMILY(4);
  private final int maxOccupancy;

  /**
   * Set maxOccupancy as value of RoomType.
   * @param maxOccupancy Max number of people that can stay in the room.
   */
  RoomType(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  /**
   * Return the maxOccupancy of the room.
   * @return maxOccupancy.
   */
  public int getMaxOccupancy() {
    return maxOccupancy;
  }
}
