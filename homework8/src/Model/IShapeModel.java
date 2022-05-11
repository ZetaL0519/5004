package Model;

/**
 * This is an interface representing ShapeModel.
 */
public interface IShapeModel {

  /**
   * Snapshot the album and save the current timestamp and shape list.
   * @param Description description of the snapshot.
   */
  void SnapShot(String Description);


  /**
   * Print current shape list.
   * @return String form of shape list.
   */
  String printShapeList();

  /**
   * Print out timestamp and shape list.
   * @return string of description and shape list
   */
  String printSnapShapeList();

  /**
   * Print out snapshotID list.
   * @return string of SnapshotID.
   */
  String printSnapShotList();

  /**
   * Create a new IShape object and put it in the shape list.
   * @param name Shape name
   * @param type Shape type
   * @param size1 shape width/x-radius
   * @param size2 shape height/y-radius
   * @param XPosition shape position for x-coordinate
   * @param YPosition shape position for y-coordinate
   * @param ColorR shape Color R value
   * @param ColorG shape Color G value
   * @param ColorB shape Color B value
   */
  void CreateShape(String name, String type, double size1, double size2,
                   double XPosition, double YPosition, double ColorR, double ColorG, double ColorB);

  /**
   * Remove shape
   * @param name String name
   */
  void removeShape(String name);

  /**
   * Change color of existing IShape object.
   * @param name IShape name
   * @param newR new IShape Color R value
   * @param newG new IShape Color G value
   * @param newB new IShape Color B value
   */
  void ChangeColor(String name, double newR, double newG, double newB);

  /**
   * Change position of existing IShape object.
   * @param name IShape name
   * @param newX new IShape X-coordinate
   * @param newY new IShape Y-coordinate
   */
  void ChangePos(String name, double newX, double newY);

  /**
   * Change size of existing IShape object.
   * @param name IShape name
   * @param newSize1 new IShape size one
   * @param newSize2 new IShape size two
   */
  void Resize(String name, double newSize1, double newSize2);

  /**
   * Reset the album and list.
   */
  void reset();

  /**
   * Check if the given string s is already in the shape list.
   * @param s given string IShape name
   * @return boolean true if exists
   */
  boolean checkRepeatName(String s);

}
