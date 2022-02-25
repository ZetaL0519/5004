package shapes;

public enum Color {
  RED(5), BLUE(10), YELLOW(15), GREEN(20);

  private int value;
  Color(int value) {
    this.value = value;
  }

  public int getValue(){
    return this.value;
  }
}
