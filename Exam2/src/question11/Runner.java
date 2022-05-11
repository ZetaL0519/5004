package question11;

import java.util.List;

public class Runner implements Comparable<Runner>{
  private String name;
  private List<Double> fiveKRaceTimes;
  private List<Double> tenKRaceTimes;
  private List<Double> halfMarathonTimes;
  public Runner(String name, List<Double> fiveKRaceTimes, List<Double> tenKRaceTimes,
                List<Double> halfMarathonTimes) {
    this.name = name;
    this.fiveKRaceTimes = fiveKRaceTimes;
    this.tenKRaceTimes = tenKRaceTimes;
    this.halfMarathonTimes = halfMarathonTimes;
  }
  public String getName() {
    return name;
  }
  public List<Double> getFiveKRaceTimes() {
    return fiveKRaceTimes;
  }
  public List<Double> getTenKRaceTimes() {
    return tenKRaceTimes;
  }
  public List<Double> getHalfMarathonTimes() {
    return halfMarathonTimes;
  }

  public boolean QualifyHalfMarathon() {
    for (double t: this.getHalfMarathonTimes()) {
      if (t < 100.00) {
        return true;
      }
    }
    return false;
  }

  public double getAvgFiveKRaceTimes() {
    double sum = 0.0;
    int count = 0;
    for (Double time: this.getFiveKRaceTimes()) {
      sum += time;
      count += 1;
    }
    return sum / count;
  }

  @Override
  public int compareTo(Runner otherRunner) {
    return (int) (this.getAvgFiveKRaceTimes() - otherRunner.getAvgFiveKRaceTimes());
  }


}
