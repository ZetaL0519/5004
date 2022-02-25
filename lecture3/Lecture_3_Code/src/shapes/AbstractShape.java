package shapes;

public abstract class AbstractShape {
  protected int x, y;

  public AbstractShape(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {return this.x;}
  public int getY() {return this.y;}

}
