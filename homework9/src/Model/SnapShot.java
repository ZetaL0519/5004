package Model;

import java.util.List;

import Shape.IShape;

/**
 * This is SnapShot class.
 */
public class SnapShot {
  private String SnapShotID;
  private String Description;
  private List<IShape> ShapeList;

  /**
   * This is the constructor for SnapShot.
   * @param SnapShotID SnapShotID
   * @param Description description for the snapshot
   * @param ShapeList list of IShape objects in the snapshot
   */
  public SnapShot(String SnapShotID, String Description, List<IShape> ShapeList) {
    this.SnapShotID = SnapShotID;
    this.Description = Description;
    this.ShapeList = ShapeList;
  }

  /**
   * Getter method for ShapeList.
   * @return shape list
   */
  public List<IShape> getShapeList() {
    return ShapeList;
  }

  /**
   * Getter method for Snapshot description.
   * @return snapshot description
   */
  public String getDescription() {
    return Description;
  }

  /**
   * Getter method for Snapshot ID.
   * @return Snapshot id
   */
  public String getSnapShotID() {
    return SnapShotID;
  }
}
