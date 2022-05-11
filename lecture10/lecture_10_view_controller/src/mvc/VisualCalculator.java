package mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.ICalculator;
import model.CalculatorModel;

import javax.swing.*;

public class VisualCalculator {
  public static void main(String[] args) throws IOException {
    ICalculator model = new CalculatorModel();
    SwingView view = new SwingView("Keith's Calculator");
    CalcMVCControllerVisual controller = new CalcMVCControllerVisual(model, view);
    controller.go();
  }
}

class SwingView extends JFrame {
  private JButton btnAdd;
  private JButton btnSubtract;
  private JLabel result;
  private JTextField one, two;

  public SwingView(String caption) {
    super(caption);
    setSize(250, 125);
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridLayout(0,2));  // grid with 2 columns & as many rows as we need
    this.add(new JLabel("Number 1"));
    this.add(new JLabel("Number 2"));

    one = new JTextField(10);
    two = new JTextField(10);
    this.add(one);
    this.add(two);

    btnAdd = new JButton(" + ");
    btnAdd.setActionCommand("Add");
    this.add(btnAdd);

    result = new JLabel("");
    this.add(result);

    // Add subtract functionality
    btnSubtract= new JButton(" - ");
    btnSubtract.setActionCommand("Subtract");
    this.add(btnSubtract);
  }

  String getNumber1() { return one.getText(); }
  String getNumber2() { return two.getText(); }

  void updateResult(String answer ) {
    result.setText(answer);
  }

  public void setActionListener(ActionListener listener) {
    // for this simple example, we'll have one action listener: our controller
    btnAdd.addActionListener(listener);
    btnSubtract.addActionListener(listener); // NEW: add for subtract button
  }
}

class CalcMVCControllerVisual implements ActionListener {
  int one, two;
  ICalculator model;
  SwingView view;

  public CalcMVCControllerVisual(ICalculator model, SwingView view) {
    this.model = model;
    this.view = view;
    this.view.setActionListener(this);
  }

  public void go() throws IOException {
    this.view.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
      case "Add":
        int one = Integer.parseInt(this.view.getNumber1());
        int two = Integer.parseInt(this.view.getNumber2());
        int result = model.add(one, two);
        this.view.updateResult(Integer.toString(result));
        break;
      case "Subtract":  // NEW added functionality. We needed to enhance our model to do this
        one = Integer.parseInt(this.view.getNumber1());
        two = Integer.parseInt(this.view.getNumber2());
        result = model.subtract(one, two);
        this.view.updateResult(Integer.toString(result));
    }
  }
}
