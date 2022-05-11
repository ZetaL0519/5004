package controllers;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import model.ICalculator;

public class DecoupledController implements ICalcController {
  final Readable in;
  final Appendable out;
  public DecoupledController(Readable in, Appendable out) {
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
}
