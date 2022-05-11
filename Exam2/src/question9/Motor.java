package question9;

public class Motor implements IPumpComponent {
  private boolean isRunning;

  public Motor(boolean isRunning) {
    this.isRunning = isRunning;
  }

  public void turnOn() { isRunning = true; }
  public void turnOff() { isRunning = false; }
  public boolean isOn() { return isRunning; }

  @Override
  public void accept(IPumpComponentVisitor repairDrone) {
    repairDrone.visit(this); // ask the drone to visit
  }
}
