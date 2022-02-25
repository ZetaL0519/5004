import hw2.Room;
import hw2.RoomType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Room class.
 */

public class TestRoom {
  private Room room1;
  private Room room2;

  /**
   * Constructs two room objects and initializes them.
   */
  @Before
  public void setUp() {
    RoomType singleRoom = RoomType.SINGLE;
    RoomType doubleRoom = RoomType.DOUBLE;
    room1 = new Room(singleRoom, 150);
    room2 = new Room(doubleRoom, 250);
  }

  /**
   * Test bad room if their price is under or equal to 0.
   */
  @Test
  public void testBadRoom() {
    try {
      RoomType familyRoom = RoomType.FAMILY;
      Room badRoom = new Room(familyRoom, -100);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRoom caught") + e.getMessage());
    }

    try {
      RoomType DoubleRoom = RoomType.DOUBLE;
      Room badRoom = new Room(DoubleRoom, 0);
    } catch (IllegalArgumentException e) {
      System.out.println(("BadRoom caught") + e.getMessage());
    }
  }

  /**
   * Test bookRoom and isAvailable methods.
   *  If the room is available AND the number of guests is within the range [0, maxPeople],
   *  this method sets the room's number of guests to the value of the parameter passed in.
   */
  @Test
  public void testisAvailable() {
    // test isAvailable before booking
    Assert.assertTrue(room1.isAvailable());
    Assert.assertTrue(room2.isAvailable());

    // book a single room with 1 guest.
    room1.bookRoom(1);
    Assert.assertFalse(room1.isAvailable());

    // book a double room with 4 guests.
    room2.bookRoom(4);
    Assert.assertTrue(room2.isAvailable());

    // book a room with -1 guests.
    room2.bookRoom(-1);
    Assert.assertTrue(room2.isAvailable());

    // book a room after it is booked.
    room2.bookRoom(1);
    Assert.assertFalse(room2.isAvailable());
  }

  /**
   * Test BookRoom and getNumberOfGuests method.
   * if number of guests is smaller than maximum number of room and room is unavailable,
   * Room can be booked.
   */
  @Test
  public void testBookRoom() {
    // test getter before booked
    Assert.assertEquals(0, room1.getNumberOfGuests());
    Assert.assertEquals(0, room2.getNumberOfGuests());

    // book room with 1 guest
    room1.bookRoom(1);
    Assert.assertEquals(1, room1.getNumberOfGuests());

    // book room with -1 guest
    room2.bookRoom(-1);
    Assert.assertEquals(0, room2.getNumberOfGuests());

    // book room with 3 guests
    room2.bookRoom(3);
    Assert.assertEquals(0, room2.getNumberOfGuests());

    // book room with 1 guest
    room2.bookRoom(1);
    Assert.assertEquals(1, room2.getNumberOfGuests());
  }

  /**
   * Test getGuestOfRoom method.
   */
  @Test
  public void testGetGuestOfRoom() {
    Assert.assertEquals(0, room1.getNumberOfGuests());
    Assert.assertEquals(0, room2.getNumberOfGuests());
  }
}
