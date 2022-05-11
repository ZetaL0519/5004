package question8;

import java.util.ArrayList;
import java.util.List;

public class Pair<X, Y> {
  private final X first;
  private final Y second;

  private Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  public static <X, Y> Pair<X, Y> create(X first, Y second) {
    return new Pair<>(first, second);
  }

  public static <X,Y> List<Pair<X,Y>> createListOfPairs(List<X> xs, List<Y> ys) throws IllegalArgumentException {
    if (xs == null || ys == null) {
      throw new IllegalArgumentException("List of Pairs are null");
    }
    if (xs.size() != ys.size()) {
      throw new IllegalArgumentException("Size of pair lists not equal");
    }
    List<Pair<X, Y>> res = new ArrayList<>();
    int size = xs.size();
    for (int i = 0; i < size; i ++) {
      X first = xs.get(i);
      Y second = ys.get(i);
      res.add(create(first, second));
    }
    return res;
  }

  public X getFirst() {
    return this.first;
  }

  public Y getSecond() {
    return this.second;
  }
}
