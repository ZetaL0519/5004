package employee;

/**
 * This is an interface class that declares common methods for Hourly and salaried paycheck.
 */
public interface IPaycheck {

  /**
   * This is a getter method for total pay.
   * @return total pay.
   */
  double getTotalPay();

  /**
   * This is a getter method for pay after taxes.
   * @return pay after taxes.
   */
  double getPayAfterTaxes();

  /**
   * This is a getter method for pay rate.
   * @return pay rate.
   */
  double getPayRate();
}