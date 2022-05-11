package controllers;

import java.io.IOException;
import model.ICalculator;
/**
 * The controller interface
 */
public interface ICalcController {
  void go(ICalculator calc) throws IOException;
}
