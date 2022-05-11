package question11;

public class Temperature {
  private static final double trans = 32;
  private static final double ABS_ZERO_C = 273.1;

  public double toCelsius(double fahrenheit) {
    return (fahrenheit - trans) * 5 / 9;
  }

  public double toFahrenheit(double celsius) {
    return celsius * 9 / 5 + trans;
  }

  public double toKelvin(double celsius) {
    return celsius - ABS_ZERO_C;
  }
}
