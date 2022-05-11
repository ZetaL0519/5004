package mvc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import model.CalculatorModel;
import model.ICalculator;

public class CalcTextMVC {
  public static void main(String[] args) throws IOException {
    ICalculator model = new CalculatorModel();
    CalcTextView view = new CalcTextView(new InputStreamReader(System.in), System.out);
    CalcMVCController controller = new CalcMVCController(model, view);
    controller.go();
  }
}

class CalcTextView {
  Appendable output;
  Readable input;
  Scanner scanner;
  String result;

  public CalcTextView(Readable input, Appendable output) {
    this.input = input;
    this.output = output;
    this.scanner = new Scanner(input);
  }
  public void show(String result) throws IOException {
    this.output.append(result);
    this.result = result;
  }
  public void repaint() throws IOException {
    this.show(this.result);
  }

  public String getUserInput() throws IOException {
    this.show("Enter two numbers to add, 'Q' to quit");
    this.show(">>> ");
    String value = scanner.next();
    if( value.equalsIgnoreCase("Q")) {
      return "Q";
    }
    return value + " " + scanner.next();
  }
}

class CalcMVCController {
  int one, two;
  ICalculator model;
  CalcTextView view;

  public CalcMVCController(ICalculator model, CalcTextView view) {
    this.model = model;
    this.view = view;
  }

  public void go() throws IOException {
    try {
      String value = view.getUserInput();
      while (!value.equalsIgnoreCase("Q")) {
        String [] params = value.split(" ");
        one = Integer.parseInt(params[0]);
        two = Integer.parseInt(params[1]);

        int result = model.add(one, two);   // get the data from the model
        this.view.show("\nResult = " + Integer.toString(result) + "\n"); // use the view to display
        this.view.show(">>> ");
        value = view.getUserInput();
      }
    }
    catch(IOException e) {
      throw e;
    }
  }
}
