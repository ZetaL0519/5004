package controllers;

import java.util.Objects;
import java.util.Scanner;

import model.ICalculator;
import model.CalculatorModel;

class HardwiredController implements ICalcController {
  public void go(ICalculator calc) {
    Objects.requireNonNull(calc);
    int num1, num2;
    System.out.println("Enter two numbers to add");
    System.out.print(">>> ");
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.print(calc.add(num1, num2));
  }
}

public class ControllerHardwired {
  public static void main(String[] args) {
    new HardwiredController().go(new CalculatorModel());
  }
}