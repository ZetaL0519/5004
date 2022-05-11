package question9;

import java.util.HashMap;
import java.util.Map;

public class PumpRepairDrone implements IPumpComponentVisitor {
  private Map<String, String> logInfo = new HashMap<>();

  @Override
  public void visit(Drill drill) {
    if (drill.getStatus().equals(Drill.Status.BROKEN)) {
      logInfo.put("Drill", "Broken");
    } else if (drill.getStatus().equals(Drill.Status.GOOD)) {
      logInfo.put("Drill", "Good");
    }
  }

  @Override
  public void visit(Motor motor) {
    if (!motor.isOn()) {
      logInfo.put("Motor", "Off");
    } else {
      if (logInfo.get("Drill").equals("Broken")) {
        motor.turnOff();
        logInfo.put("Motor", "Off");
      }
      else if (logInfo.get("Pipe").equals("No")){
        motor.turnOff();
        logInfo.put("Motor", "Off");
      } else {
        logInfo.put("Motor", "On");
      }
    }
  }

  @Override
  public void visit(Pipe pipe) {
    if (pipe.getSealPct() < 70) {
      logInfo.put("Pipe", "No");
    } else {
      logInfo.put("Pipe", "Ok");
    }
  }

  @Override
  public void visit(IntakeValve intakeValve) {
    if (logInfo.get("Pipe").equals("Ok") && logInfo.get("Drill").equals("Good") && logInfo.get("Motor").equals("On")) {
      intakeValve.open();
      logInfo.put("IntakeValve", "open");
    } else {
      intakeValve.close();
      logInfo.put("IntakeValve", "close");
    }
  }

  @Override
  public Map<String, String> getLog() {
    return logInfo;
  }
}
