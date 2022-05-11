package Model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Shape.Color;
import Shape.IShape;
import Shape.Oval;
import Shape.Position;
import Shape.Rectangle;

/**
 * This is a ShapeModel class.
 */
public class ShapeModel implements IShapeModel{
  private List<IShape> shapeList;
  private List<SnapShot> SnapshotList;

  /**
   * This is a constructor for ShapeModel.
   */
  public ShapeModel() {
    SnapshotList = new ArrayList<>();
    shapeList = new ArrayList<>();
  }

  /**
   * Getter method for Snapshot list.
   * @return List of Snapshot.
   */
  public List<SnapShot> getSnapshotList() {
    return this.SnapshotList;
  }

  /**
   * SnapShot the current timestamp and save the description and shape list to the album.
   * @param Description description of the snapshot.
   */
  @Override
  public void SnapShot(String Description) {
    if (Description == null) {
      Description = "";
    }
    Instant now = Instant.now();

    SnapShot snapShot = new SnapShot(now.toString(), Description, new ArrayList<>(shapeList));

    SnapshotList.add(snapShot);
  }

  /**
   * Print Shape List of all snapshots.
   * @return String of concatenating shape information.
   */
  @Override
  public String printSnapShapeList() {
    StringBuilder ShapeListInfo = new StringBuilder();
    for (SnapShot snapShot: SnapshotList) {
      ShapeListInfo.append(snapShot.getSnapShotID() + "\n");
      List<IShape> shapes = snapShot.getShapeList();
      for (IShape shape: shapes) {
        ShapeListInfo.append(shape.toString() + "\n\n");
      }
    }
    return ShapeListInfo.toString();
  }

  /**
   * Print out the current shape list.
   * @return String form of shape information
   */
  @Override
  public String printShapeList() {
    StringBuilder shapeListInfo = new StringBuilder();
    for (IShape shape: shapeList) {
      shapeListInfo.append(shape.toString() + "\n");
    }
    return shapeListInfo.toString();
  }

  /**
   * all Print SnapShot timestamps.
   * @return list of all snapshots.
   */
  @Override
  public String printSnapShotList() {
    StringBuilder SnapShotList = new StringBuilder();
    SnapShotList.append("List of SnapShot taken before reset: \n");
    for (SnapShot snapShot: SnapshotList) {
      SnapShotList.append(snapShot.getSnapShotID()).append(" ");
    }
    return SnapShotList.toString();
  }

  /**
   * Create new IShape object and add it to the shape list.
   *
   * @param name Shape name
   * @param type Shape type
   * @param size1 shape width/x-radius
   * @param size2 shape height/y-radius
   * @param XPosition shape position for x-coordinate
   * @param YPosition shape position for y-coordinate
   * @param ColorR shape Color R value
   * @param ColorG shape Color G value
   * @param ColorB shape Color B value
   *
   * @throws IllegalArgumentException
   * If name or type is null, throw exception.
   */
  @Override
  public void CreateShape(String name, String type, double XPosition
          , double YPosition,double size1, double size2, double ColorR, double ColorG, double ColorB) throws IllegalArgumentException{
    if (name == null || type == null) {
      throw new IllegalArgumentException("Add Shape null");
    }

    if (!type.equalsIgnoreCase("oval")
            && !type.equalsIgnoreCase("rectangle")) {
      throw new IllegalArgumentException("Type nonexistent");
    }

    checkRepeatName(name);

    Color ShapeColor = new Color(ColorR, ColorG, ColorB);
    Position ShapePos = new Position(XPosition, YPosition);
    IShape shape = null;
    if (type.equalsIgnoreCase("rectangle")) {
      shape = new Rectangle(name, ShapePos, ShapeColor, size1, size2);
    }
    else if (type.equalsIgnoreCase("oval")) {
      shape = new Oval(name, ShapePos, ShapeColor, size1, size2);
    }
    shapeList.add(shape);
  }

  /**
   * Remove existing Shape object.
   * @param name String name
   */
  @Override
  public void removeShape(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Remove shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        shapeList.remove(each);
        return;
      }
    }
  }

  /**
   * Change color for the shape object.
   * @param name IShape name
   * @param newR new IShape Color R value
   * @param newG new IShape Color G value
   * @param newB new IShape Color B value
   */
  @Override
  public void ChangeColor(String name, double newR, double newG, double newB) {
    if (name == null) {
      throw new IllegalArgumentException("Change Shape is null");
    }
    for (int i = 0; i < shapeList.size(); i ++) {
      if (name.equals(shapeList.get(i).getName())) {
        shapeList.set(i, shapeList.get(i).changeColor((int) newR, (int) newG, (int) newB));
        return;
      }
    }
  }

  /**
   * Change position for the shape object.
   * @param name IShape name
   * @param newX new IShape X-coordinate
   * @param newY new IShape Y-coordinate
   */
  @Override
  public void ChangePos(String name, double newX, double newY) {
    if (name == null) {
      throw new IllegalArgumentException("Change shape is null");
    }
    for (int i = 0; i < shapeList.size(); i ++) {
      if (shapeList.get(i).getName().equals(name)) {
        shapeList.set(i, shapeList.get(i).move(new Position(newX, newY)));
      }
    }
  }

  /**
   * resize shape object.
   * @param name IShape name
   * @param newSize1 new IShape size one
   * @param newSize2 new IShape size two
   */
  @Override
  public void Resize(String name, double newSize1, double newSize2) {
    if (name == null) {
      throw new IllegalArgumentException("Change shape is null");
    }
    for (int i = 0; i < shapeList.size(); i ++) {
      if (shapeList.get(i).getName().equals(name)) {
        shapeList.set(i, shapeList.get(i).changeSize(newSize1, newSize2));
      }
    }
  }

  /**
   * Reset shape model.
   */
  @Override
  public void reset() {
    shapeList.clear();
    SnapshotList.clear();
  }

  /**
   * Check if the given string already exists.
   * @param s given string IShape name
   * @return whether repeated name exists
   */
  @Override
  public boolean checkRepeatName(String s) {
    for (IShape shape: shapeList) {
      if (s.equals(shape.getName())) {
        return true;
      }
    }
    return false;
  }

  /**
   * ToString method.
    * @return text form of instructions
   */
  @Override
  public String toString() {
    return "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)";
  }

}
