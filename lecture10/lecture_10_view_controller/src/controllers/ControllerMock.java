package controllers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

import model.ICalculator;
import model.CalculatorModel;

public class ControllerMock implements ICalcController {
  final Readable in;
  final Appendable out;
  public ControllerMock(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }
  public void go(ICalculator calc) throws IOException {
    Objects.requireNonNull(calc);
    int num1, num2;
    Scanner scan = new Scanner(this.in);
    while (true) {
      switch (scan.next()) {
        case "+":
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          this.out.append(String.format("%d\n", calc.add(num1, num2)));
          break;
        case "-":
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          this.out.append(String.format("%d\n", calc.subtract(num1, num2)));
          break;
        case "q":
          return;
      }
    }
  }
  public static void main(String[] args) {
    try {
      new ControllerMock(new InputStreamReader(System.in), System.out).go(new CalculatorModel());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
