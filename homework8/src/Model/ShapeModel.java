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
  private Map<String, String> DescriptionMap;
  private Map<String, List<IShape>> ShapeMap;
  private static final SimpleDateFormat TimeStampFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  /**
   * This is a constructor for ShapeModel.
   */
  public ShapeModel() {
    ShapeMap = new HashMap<>();
    DescriptionMap = new HashMap<>();
    shapeList = new ArrayList<>();
  }

  /**
   * SnapShot the current timestamp and save the description and shape list to the album.
   * @param Description description of the snapshot.
   */
  @Override
  public void SnapShot(String Description) {
    Instant now = Instant.now();
    Date date = new Date();
    // key is timestamp, value is list of shape.
    ShapeMap.put(now.toString(), new ArrayList<>(shapeList));

    String SnapInfo = "\nSnapShot ID: " + now
            + "\n" + "TimeStamp: " + TimeStampFormat1.format(date)
            + "\n" + "Description: " + Description + "\n"
            + "Shape Information:";
    // key is timestamp, value is Information
    DescriptionMap.put(now.toString(), SnapInfo);
  }

  /**
   * Print Shape List of all snapshots.
   * @return String of concatenating shape information.
   */
  @Override
  public String printSnapShapeList() {
    StringBuilder ShapeListInfo = new StringBuilder();
    for (String time: DescriptionMap.keySet()) {
      ShapeListInfo.append(DescriptionMap.get(time) + "\n");
      List<IShape> shapes = ShapeMap.get(time);
      for (IShape shape: shapes) {
        ShapeListInfo.append(shape.toString() + "\n\n");
      }
    }
    return ShapeListInfo.toString();
  }

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
    SnapShotList.append(DescriptionMap.keySet());
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
  public void CreateShape(String name, String type, double size1, double size2, double XPosition
          , double YPosition, double ColorR, double ColorG, double ColorB) throws IllegalArgumentException{
    if (name == null || type == null) {
      throw new IllegalArgumentException("Add Shape null");
    }

    if (!type.equalsIgnoreCase("oval")
            && !type.equalsIgnoreCase("rectangle")) {
      throw new IllegalArgumentException("Type nonexistent");
    }

    for (IShape each: shapeList) {
      if (each.getName().equals(name)) {
        return;
      }
    }

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

  @Override
  public void ChangeColor(String name, double newR, double newG, double newB) {
    if (name == null) {
      throw new IllegalArgumentException("Change Shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        Color newColor = new Color(newR, newG, newB);
        each = each.changeColor(newColor);
        return;
      }
    }
  }

  @Override
  public void ChangePos(String name, double newX, double newY) {
    if (name == null) {
      throw new IllegalArgumentException("Change shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        Position newPos = new Position(newX, newY);
        each = each.move(newPos);
        return;
      }
    }
  }

  @Override
  public void Resize(String name, double newSize1, double newSize2) {
    if (name == null) {
      throw new IllegalArgumentException("Change shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        each = each.changeSize(newSize1, newSize2);
        return;
      }
    }
  }

  @Override
  public void reset() {
    shapeList.clear();
    DescriptionMap.clear();
    ShapeMap.clear();
  }

  @Override
  public boolean checkRepeatName(String s) {
    for (IShape shape: shapeList) {
      if (s.equals(shape.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "This is your Photo Album. \n" +
            "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)";
  }
}
