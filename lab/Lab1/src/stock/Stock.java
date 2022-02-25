package stock;

import java.text.DecimalFormat;

/**
 * This class represents a Stock class with a symbol, a name, cost and current price.
 */
public class Stock {
  private String symbol;
  private String name;
  private double CostBasis;
  private double CurrPrice;

  /**
   * Construct a stock class.
   * @param symbol symbol of the stock.
   * @param name name of the stock company.
   * @param CostBasis the initial cost basis of the stock.
   */
  public Stock(String symbol, String name, double CostBasis) {
    this.symbol = symbol;
    this.name = name;
    this.CostBasis = CostBasis;
  }

  /**
   * Get symbol of the Stock object.
   * @return symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Get name of the Stock object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the cost basis of the Stock object.
   * @return CostBasis
   */
  public double getCostBasis() {
    return CostBasis;
  }

  /**
   * Get the current price of the Stock object.
   * @return CurrPrice
   */
  public double getCurrentPrice() {
    return CurrPrice;
  }

  /**
   * Set the cost basis of the Stock object.
   * @param costBasis the cost price of the Stock object.
   */
  public void setCostBasis(double costBasis) {
    this.CostBasis = costBasis;
  }

  /**
   * Set the current price of the Stock object.
   * @param currPrice the cost price of the Stock object.
   */
  public void setCurrentPrice(double currPrice) {
    this.CurrPrice = currPrice;
  }

  /**
   * Get the price change percent of the Stock object.
   * @return price change percentage.
   */
  public double getChangePercent() {
    return this.getCurrentPrice() / this.getCostBasis() - 1;
  }

  /**
   * Return the String form of the stock information.
   * @return string form of the stock information.
   */
  public String toString() {
    String pattern = "#.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String curP = decimalFormat.format(this.getCurrentPrice());
    String changePercent = decimalFormat.format(this.getChangePercent() * 100);
    return name + " Current Price: $ " + curP + '\n'
            + " Gain/Loss: " + changePercent + "%" ;
  }
}
