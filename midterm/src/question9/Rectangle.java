package question9;

import javax.print.attribute.standard.MediaSize;

public class Rectangle {
  private int x;
  private int y;
  private int width;
  private int height;

  public Rectangle(int x, int y, int width, int height) throws IllegalArgumentException{
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Coordinates cannot be negative");
    }
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width or height cannot be non-positive");
    }
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean overlap(Rectangle other) {
    int RightX = this.x + this.width;
    int UpperY = this.y + this.height;
    int OtherRightX = other.getX() + other.getWidth();
    int OtherUpperY = other.getY() + other.getHeight();

    if (RightX <= other.getX() ||
        UpperY <= other.getY() ||
        this.x >= OtherRightX ||
        this.y >= OtherUpperY) {
      return false;
    }
    return true;
  }

  public String toString() {
    return "x:" + getX() + ", " + "y:" + getY()
            + ", " + "w:" + getWidth()
            + ", " + "h:" + getHeight();
  }
}
