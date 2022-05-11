package question9;

public class Pipe implements IPumpComponent {
  private int seal;

  public Pipe(int seal) {
    this.seal = seal;
  }

  public int getSealPct() { return this.seal; }

  @Override
  public void accept(IPumpComponentVisitor repairDrone) {
    repairDrone.visit(this); // ask the drone to visit
  }
}
