import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import controllers.ControllerMock;
import controllers.ICalcController;

import static org.junit.Assert.assertEquals;

public class MockModelTest {
  @Test
  public void testGo() throws Exception {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("+ 3 4 + 8 9 q");
    ICalcController controller = new ControllerMock(in, out);
    StringBuilder log = new StringBuilder(); //log for mock model
    controller.go(new MockModel(log,1234321));
    assertEquals("Input: 3 4\nInput: 8 9\n", log.toString()); //inputs reached the model correctly
    assertEquals("1234321\n1234321\n",out.toString()); //output of model transmitted correctly

    out = new StringBuffer();
    in = new StringReader("- 5 1 q");
    controller = new ControllerMock(in, out);
    log = new StringBuilder(); //log for mock model
    controller.go(new MockModel(log,111222));
    assertEquals("Input: 5 1\n", log.toString()); //inputs reached the model correctly
    assertEquals("111222\n",out.toString()); //output of model transmitted correctly
  }
}
