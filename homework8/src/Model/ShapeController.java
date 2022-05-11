package Model;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is a class for Shape Controller.
 */
public class ShapeController implements IShapeController{
  private Readable in;
  private Appendable out;

  /**
   * This is a constructor for shape controller.
   * @param in Readable input user puts
   * @param out System output
   */
  public ShapeController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("in and out cannot be null");
    }
    this.in = in;
    this.out = out;
  }

  /**
   * The main album control function.
   * @param m shape model
   */
  public void ShapeGame(ShapeModel m) {
    // if model is null, throw exception.
    if (m == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    Scanner s = new Scanner(in);

    // Start album iteration.
    while (true) {
      try {
        out.append(m + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Model state Illegal");
      }


      // input is the action user input.
      String input = "";

      try {
        input = s.next();
      } catch (Exception e) {
        e.printStackTrace();
      }

      // if input is remove
      if (input.equalsIgnoreCase("Remove")) {
        try {
          out.append("Enter Shape name: \n");
          String name;
          // If shape does not exist, enter until name is right.
          while (true) {
            name = s.next();
            if (m.checkRepeatName(name)) {
              break;
            } else {
              out.append("Shape does not exist. Please enter again.\n");
            }
          }
          m.removeShape(name);
          out.append(m.printShapeList());
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      // If input is add.
      else if (input.equalsIgnoreCase("Add")) {
        String name;
        String type;
        String XPos;
        String YPos;
        String size1;
        String size2;
        String colorR;
        String colorG;
        String colorB;
        double XPosInt;
        double YPosInt;
        double size1int;
        double size2int;
        double colorRInt;
        double colorGInt;
        double colorBInt;

        try {
          out.append("Enter Shape name: \n");
          // If Shape already exists
          while (true) {
            name = s.next();
            if (!m.checkRepeatName(name)) {
              break;
            } else {
              out.append("Name already exists.Please enter again. \n");
            }
          }

          out.append("Enter Shape type (Oval/Rectangle): \n");

          // if shape type is not oval or rectangle, keep looping.
          while (true) {
            type = s.next();
            if (!type.equalsIgnoreCase("oval")
                    && !type.equalsIgnoreCase("rectangle")) {
              out.append("Type does not exist.Please enter again.\n");
            } else {
              break;
            }
          }

          out.append("Enter Shape position X-Coordinate: \n");
          // If x coordinate is not number, keep looping
          while (true) {
            XPos = s.next();
            try {
              XPosInt = Double.parseDouble(XPos);
              break;
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape position Y-Coordinate: \n");
          // If y coordinate is not number, keep looping
          while (true) {
            YPos = s.next();
            try {
              YPosInt = Double.parseDouble(YPos);
              break;
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape size one: \n");
          // If size is not positive number, keep looping
          while (true) {
            size1 = s.next();
            try {
              size1int = Double.parseDouble(size1);
              if (size1int > 0) {
                break;
              } else {
                out.append("Number negative.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape size two: \n");
          while (true) {
            size2 = s.next();
            try {
              size2int = Double.parseDouble(size2);
              if (size2int > 0) {
                break;
              } else {
                out.append("Number negative.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape Color R Value: \n");
          // If Color value is not number between 0-255, keep looping
          while (true) {
            colorR = s.next();
            try {
              colorRInt = Double.parseDouble(colorR);
              if (colorRInt >= 0 && colorRInt <= 255) {
                break;
              } else {
                out.append("Number out of range.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape Color G Value: \n");
          while (true) {
            colorG = s.next();
            try {
              colorGInt = Double.parseDouble(colorG);
              if (colorGInt >= 0 && colorGInt <= 255) {
                break;
              } else {
                out.append("Number out of range.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape Color B Value: \n");
          while (true) {
            colorB = s.next();
            try {
              colorBInt = Double.parseDouble(colorB);
              if (colorBInt >= 0 && colorBInt <= 255) {
                break;
              } else {
                out.append("Number out of range.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }

        // Create new shape object and add it to album.
        try {
          m.CreateShape(name, type,size1int, size2int, XPosInt, YPosInt, colorRInt, colorGInt,colorBInt);
          out.append("Shape added\n");
          out.append(m.printShapeList());
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      // If input is move
      else if (input.equalsIgnoreCase("Move")) {
        String name;
        String XPos;
        String YPos;
        double XPosInt;
        double YPosInt;

        try {
          out.append("Enter Shape name: \n");
          // If name has already existed in the list
          while (true) {
            name = s.next();
            if (m.checkRepeatName(name)) {
              break;
            } else {
              out.append("Shape does not exist. Please enter again.\n");
            }
          }

          out.append("Enter Shape position X-Coordinate: \n");
          // If XPos is not valid number
          while (true) {
            XPos = s.next();
            try {
              XPosInt = Integer.parseInt(XPos);
              break;
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }
          out.append("Enter Shape position Y-Coordinate: \n");
          // If YPos is not valid number
          while (true) {
            YPos = s.next();
            try {
              YPosInt = Integer.parseInt(YPos);
              break;
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }

        try {
          m.ChangePos(name, XPosInt, YPosInt);
          out.append("Shape position changed \n");
          out.append(m.printShapeList());
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      // If input is resize
      else if (input.equalsIgnoreCase("Resize")) {
        String name;
        String size1;
        String size2;
        double size1int;
        double size2int;

        try {
          out.append("Enter Shape name: \n");
          // check if name already exists in the shape list.
          while (true) {
            name = s.next();
            if (m.checkRepeatName(name)) {
              break;
            } else {
              out.append("Shape does not exist. Please enter again.\n");
            }
          }
          out.append("Enter Shape size one: \n");
          // Check if size is a positive number
          while (true) {
            size1 = s.next();
            try {
              size1int = Integer.parseInt(size1);
              if (size1int > 0) {
                break;
              } else {
                out.append("Number negative.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape size two: \n");
          while (true) {
            size2 = s.next();
            try {
              size2int = Integer.parseInt(size2);
              if (size2int > 0) {
                break;
              } else {
                out.append("Number negative.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }

        try {
          m.Resize(name, size1int, size2int);
          out.append("Shape size changed \n");
          out.append(m.printShapeList());
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      else if (input.equalsIgnoreCase("Color")) {
        String name;
        String colorR;
        String colorG;
        String colorB;
        double colorRInt;
        double colorGInt;
        double colorBInt;

        try {
          out.append("Enter Shape name: \n");
          // check if name already exists in the shape list
          while (true) {
            name = s.next();
            if (m.checkRepeatName(name)) {
              break;
            } else {
              out.append("Shape does not exist. Please enter again.\n");
            }
          }
          out.append("Enter Shape Color R Value: \n");
          // check if color value is number between 0-255
          while (true) {
            colorR = s.next();
            try {
              colorRInt = Double.parseDouble(colorR);
              if (colorRInt >= 0 && colorRInt <= 255) {
                break;
              } else {
                out.append("Number out of range.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape Color G Value: \n");
          while (true) {
            colorG = s.next();
            try {
              colorGInt = Double.parseDouble(colorG);
              if (colorGInt >= 0 && colorGInt <= 255) {
                break;
              } else {
                out.append("Number out of range.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }

          out.append("Enter Shape Color B Value: \n");
          while (true) {
            colorB = s.next();
            try {
              colorBInt = Double.parseDouble(colorB);
              if (colorBInt >= 0 && colorBInt <= 255) {
                break;
              } else {
                out.append("Number out of range.Please enter again.\n");
              }
            } catch (NumberFormatException e) {
              out.append("Number invalid.Please enter again.\n");
            }
          }
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }

        try {
          m.ChangeColor(name, colorRInt, colorGInt, colorBInt);
          out.append("Shape Color changed \n");
          out.append(m.printShapeList());
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      // if input is shapshot
      else if (input.equalsIgnoreCase("SnapShot")) {
        String Description;
        try {
          out.append("Add Description to SnapShot: ");
          Description = s.next();
          m.SnapShot(Description);
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      // If input is print
      else if (input.equalsIgnoreCase("print")) {
        try {
          out.append(m.printSnapShotList() + "\n");
          out.append("Printing SnapShot List\n");
          out.append(m.printSnapShapeList() + "\n");
        } catch (IOException e) {
          throw new IllegalStateException("Model state Illegal");
        }
      }

      // If input is reset
      else if (input.equalsIgnoreCase("reset")) {
        try {
          out.append("Photo Album reset\n");
          m.reset();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      // If input is quit
      else if (input.equalsIgnoreCase("quit")) {
        try {
          out.append("Photo album quit");
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      }

      else {
        try {
          out.append("Input Move Illegal.\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

