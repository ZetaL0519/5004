package question10;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
  public List<String> flatten(List<List<String>> stringList) {
    List<String> res = new ArrayList<>();
    for (List<String> strings: stringList) {
      for (String s: strings) {
        if (!ExistCheck(res, s)) {
          res.add(s);
        }
      }
    }
    return res;
  }

  public boolean ExistCheck(List<String> stringList, String s) {
    for (String string: stringList) {
      if (s.equals(string)) {
        return true;
      }
    }
    return false;
  }
}
