import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stock.Stock;

/**
 * This class is a Junit test class for Stock class.
 */
public class TestStock {
  private Stock stock1;
  private Stock stock2;

  /**
   * Set up two stock objects and initializes them
   * Set the current price.
   */
  @Before
  public void setUp() {
    stock1 = new Stock("1579229", "Apple", 100);
    stock2 = new Stock("1678942", "Cloud", 200);
    stock1.setCurrentPrice(300);
    stock2.setCurrentPrice(190);
  }

  /**
   * Test the GetSymbol method.
   */
  @Test
  public void TestGetSymbol() {
    Assert.assertEquals("1579229", stock1.getSymbol());
    Assert.assertEquals("1678942", stock2.getSymbol());
  }

  /**
   * Test the GetName method.
   */

  @Test
  public void TestGetName() {
    Assert.assertEquals("Apple", stock1.getName());
    Assert.assertEquals("Cloud", stock2.getName());
  }

  /**
   * Test GetCostBasis method.
   */
  @Test
  public void TestGetCostBasis() {
    Assert.assertEquals(100, stock1.getCostBasis(), 0.0001);
    Assert.assertEquals(200, stock2.getCostBasis(), 0.0001);
  }

  /**
   * Test GetChangePercent method.
   */
  @Test
  public void TestGetChangePercent() {
    Assert.assertEquals(2.0, stock1.getChangePercent(), 0.0001);
    Assert.assertEquals(-0.05, stock2.getChangePercent(), 0.001);
  }

  /**
   * Test GettoString method.
   */
  @Test
  public void TestGettoString() {
    Assert.assertEquals("Apple Current Price: $ 300.00\n"
            + " Gain/Loss: 200.00%", stock1.toString());
    Assert.assertEquals("Cloud Current Price: $ 190.00\n"
            + " Gain/Loss: -5.00%", stock2.toString());
  }
}
