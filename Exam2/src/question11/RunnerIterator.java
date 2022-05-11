package question11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RunnerIterator implements Iterator<Runner> {
  private int count;
  private int size;
  private List<Runner> runners;


  public RunnerIterator(List<Runner> runners) {
    this.count = 0;
    this.runners = runners.stream().filter((a) -> a.getFiveKRaceTimes().size() >= 5
            && a.getHalfMarathonTimes().size() >= 1
            && a.QualifyHalfMarathon()).collect(Collectors.toList());
    size = this.runners.size();
  }


  @Override
  public boolean hasNext() {
    return count < size;
  }

  @Override
  public Runner next() throws NoSuchElementException {
    if (count >= size) {
      throw new NoSuchElementException("Index out of range");
    }
    return runners.get(count++);
  }

  public static void main(String[] args) {
    List<Runner> runners = new ArrayList<>();
    List<Double> fiveKRaceTimes1 = new ArrayList<>();
    fiveKRaceTimes1.add(100.0);
    fiveKRaceTimes1.add(30.0);
    List<Double> fiveKRaceTimes2 = new ArrayList<>();
    fiveKRaceTimes2.add(40.0);
    fiveKRaceTimes2.add(50.0);
    fiveKRaceTimes2.add(80.0);
    fiveKRaceTimes2.add(100.0);
    fiveKRaceTimes2.add(30.0);
    List<Double> halfMa1 = new ArrayList<>();
    halfMa1.add(90.0);
    List<Double> halfMa2 = new ArrayList<>();
    halfMa2.add(100.0);
    halfMa2.add(80.0);
    List<Double> tenK = new ArrayList<>();
    Runner runner1 = new Runner("Joe", fiveKRaceTimes1, tenK, halfMa1);
    Runner runner2 = new Runner("Koe", fiveKRaceTimes2, tenK, halfMa2);
    runners.add(runner1);
    runners.add(runner2);
    RunnerIterator iterator = new RunnerIterator(runners);
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
