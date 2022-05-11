package controllers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Objects;
import java.util.Scanner;

import model.CalculatorModel;
import model.ICalculator;

public class ControllerDecoupled {
  public static void main(String[] args) {
    try {
       new DecoupledController(new InputStreamReader(System.in), System.out).go(new CalculatorModel());
      //new DecoupledController(new StringReader("+ 2 3 - 5 1 q"), System.out).go(new CalculatorModel());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

