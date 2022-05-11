package frequency;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is an Analytics class to process string sentence.
 */
public class Analytics {
  /**
   * Takes a String message as its input parameter.
   * and returns a frequency count of the words in the message.
   * @param message string of sentence.
   * @return Map with word as key and frequency as value.
   */
  public static Map<String, Double> wordFrequency(String message) {
    if (message == null || message.length() == 0) {
      return null;
    }
    message = message.replaceAll("[\\pP\\p{Punct}]", " ");
    message = message.replaceAll("\\s+", " ");
    String[] messageSplit = message.split(" ");
    int count = messageSplit.length;
    List<String> mapList = Arrays.stream(messageSplit)
            .map(String::toUpperCase).collect(Collectors.toList());
    Map<String, Double> map = new HashMap<>();
    for (String each: mapList) {
      int frequency = Collections.frequency(mapList, each);
      if (!map.containsKey(each)) {
        map.put(each, ((double) frequency / count));
      }
    }
    return map;
  }

  /**
   * Test a sentence.
   * @param args testing string of sentence.
   */
  public static void main(String[] args) {
    System.out.println(wordFrequency("Really? Like, really? I do need another cookie to cook?"));
  }
}
