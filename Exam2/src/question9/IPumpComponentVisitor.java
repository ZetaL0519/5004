package question9;

import java.util.Map;

public interface IPumpComponentVisitor {
  void visit(Drill drill);
  void visit(Motor motor);
  void visit(Pipe pipe);
  void visit(IntakeValve intakeValve);

  /**
   * Get log information.
   * @return key is the part name, value is the status message
   */
  Map<String, String> getLog();
}
