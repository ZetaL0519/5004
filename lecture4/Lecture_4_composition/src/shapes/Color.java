package shapes;

public enum Color {
  RED(5), BLUE(10), YELLOW(15), GREEN(20);

  int value;
  Color(int value) {
    this.value = value;
  }
  public int getValue() {return this.value;}
  public static void main(String [] args) {
    Color color = Color.BLUE;
    Color color2 = Color.YELLOW;
    System.out.println(color.getValue());
    System.out.println(color2.getValue());
    System.out.println(color.ordinal());
    System.out.println(color2.ordinal());
  }
}

