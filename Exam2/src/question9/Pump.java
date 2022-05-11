package question9;

import java.util.List;
import java.util.LinkedList;

public class Pump {
  private List<IPumpComponent> parts;
  public Pump() { // default constructor
    parts = new LinkedList<>();
    parts.add(new Drill(Drill.Status.BROKEN));
    parts.add(new Pipe(75));
    parts.add(new Motor(true));
    parts.add(new IntakeValve(true));
  }
  public Pump(List<IPumpComponent> parts) {
    this.parts = parts;
  }
  public void inspectParts(IPumpComponentVisitor drone) {
    for(IPumpComponent eachPart : parts) {
      eachPart.accept(drone);
    }
  }
}

