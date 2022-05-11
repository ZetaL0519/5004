import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import controllers.DecoupledController;
import controllers.ICalcController;
import model.CalculatorModel;

import static org.junit.Assert.assertEquals;

public class DecoupledControllerTest {
  @Test
  public void testGo() throws Exception {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("+ 3 4 + 8 9 q");
    ICalcController controller = new DecoupledController(in, out);
    controller.go(new CalculatorModel());
    assertEquals("7\n17\n", out.toString());
  }
}
