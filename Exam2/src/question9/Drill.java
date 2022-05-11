package question9;

public class Drill implements IPumpComponent {
  public enum Status {GOOD, BROKEN};
  private Status status;

  public Drill(Status status) {
    this.status = status;
  }

  public Status getStatus() { return this.status; }

  @Override
  public void accept(IPumpComponentVisitor repairDrone) {
    repairDrone.visit(this); // ask the drone to visit
  }
}
