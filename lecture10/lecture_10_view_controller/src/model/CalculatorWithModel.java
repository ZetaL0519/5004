package model;

import java.util.Scanner;

public class CalculatorWithModel {
  public static void main(String [] args) {
    CalculatorModel model = new CalculatorModel();
    int one, two;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter two numbers to add, 'Q' to quit");
    System.out.print(">>> ");
    String value = scanner.next();
    while( !value.equalsIgnoreCase("Q")) {
      one = Integer.parseInt(value);
      two = scanner.nextInt();
      System.out.println(one + " + " + two + " = " + model.add(one, two));
      System.out.println("Memory is " + model.memory());
      System.out.print(">>> ");
      value = scanner.next();
    }
  }
}

