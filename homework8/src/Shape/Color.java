package Shape;

import java.text.DecimalFormat;

/**
 * This is a helper class representing Color using RGB.
 */
public class Color {
  private double r;
  private double g;
  private double b;

  /**
   * This is a color constructor.
   *
   * @param r double R
   * @param g double G
   * @param b double B
   * @throws IllegalArgumentException if RGB values are invalid.
   */
  public Color(double r, double g, double b) throws IllegalArgumentException {
    if (outOfBound(r, g, b)) {
      throw new IllegalArgumentException("Color RGB value must be between 0 and 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * outOfBound checks if the RGB values are valid.
   *
   * @param r double R.
   * @param g double G.
   * @param b double B.
   * @return boolean whether the values are valid.
   */
  private boolean outOfBound(double r, double g, double b) {
    return r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255;
  }

  /**
   * ToString method.
   * @return String form of color.
   */
  @Override
  public String toString() {
    String pattern = "##0.0";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String formatR = decimalFormat.format(this.r);
    String formatG = decimalFormat.format(this.g);
    String formatB = decimalFormat.format(this.b);
    return "(" + formatR
            + "," + formatG + ","
            + formatB + ")";
  }
}
