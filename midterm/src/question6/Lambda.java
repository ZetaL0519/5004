package question6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {
  List<String> words =
          Arrays.asList("straw man", "Straw hat", "last straw", "drinking straw", "Straw", "strah brah");

  public List<String> lambdaFilter(String filterString) {
    Predicate<String> map = i -> (i.substring(0, 5).equalsIgnoreCase("straw"));
    return words.stream()
            .filter(map)
            .collect(Collectors.toList());
  }

  public static void main(String [] args) {
    Lambda lambda = new Lambda();
    List<String> strawsLuv = lambda.lambdaFilter("Straw");
    System.out.println(strawsLuv);
  }
}