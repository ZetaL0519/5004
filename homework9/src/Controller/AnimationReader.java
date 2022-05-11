package Controller;

import java.util.Objects;
import java.util.Scanner;

/**
 * This is the animation reader class.
 */
public class AnimationReader {

  /**
   * Parse the file and match them with commands.
   * @param readable Input filr
   * @param builder builder method
   * @param <Doc> model
   * @return model
   */
  public static <Doc> Doc ParseFile(Readable readable, AnimationBuilder<Doc> builder) {
    Objects.requireNonNull(readable, "Must have non-null readable source");
    Objects.requireNonNull(builder, "Must provide a non-null AnimationBuilder");
    Scanner s = new Scanner(readable);
    while (s.hasNextLine()) {
      String line = s.nextLine();
      if (line.equals("")) {
        continue;
      }
      String[] wordlist = line.split("\\s+", 2);
      if (wordlist[0].equals("#")) {
        continue;
      }
      if (wordlist[0].equals("")) {
        wordlist = wordlist[1].split("\\s+", 2);
      }
      String word = wordlist[0];

      if (word.equalsIgnoreCase("shape")) {
        readShape(wordlist, builder);
      } else if (word.equalsIgnoreCase("move")) {
        readMove(wordlist, builder);
      } else if (word.equalsIgnoreCase("resize")) {
        readResize(wordlist, builder);
      } else if (word.equalsIgnoreCase("remove")) {
        readRemove(wordlist, builder);
      } else if (word.equalsIgnoreCase("color")) {
        readColor(wordlist, builder);
      } else if (word.equalsIgnoreCase("snapshot")) {
        readSnap(wordlist, builder);
      } else {
        throw new IllegalStateException("Unexpected keyword: " + word + s.nextLine());
      }
    }
    return builder.build();
  }

  /**
   * Process Snapshot command.
   * @param wordlist line of commands.
   * @param builder builder method
   * @param <Doc> model
   */
  private static <Doc> void readSnap(String[] wordlist, AnimationBuilder<Doc> builder) {
    String description = null;
    if (wordlist.length > 1) {
      description = wordlist[1];
    }
    builder.SnapShot(description);
  }

  /**
   * Process the change color command.
   * @param wordlist lines of commands
   * @param builder builder method
   * @param <Doc> model
   */
  private static <Doc> void readColor(String[] wordlist, AnimationBuilder<Doc> builder) {
    wordlist = wordlist[1].split("\\s+");
    String name;

    if (wordlist.length < 4) {
      throw new IllegalArgumentException("Color value missing");
    }
    name = wordlist[0];
    int[] vals = new int[3];
    int j = 1;
    for (int i = 0; i < 3; i ++) {
      try {
        vals[i] = Integer.parseInt(wordlist[j++]);
      } catch (Exception e) {
        throw new NumberFormatException("Should be an Int");
      }
    }
    builder.ColorShape(name, vals[0], vals[1], vals[2]);
  }

  /**
   * Process remove command.
   * @param wordlist lines of commands
   * @param builder builder method
   * @param <Doc> model
   */
  private static <Doc> void readRemove(String[] wordlist, AnimationBuilder<Doc> builder) {
    wordlist = wordlist[1].split("\\s+");
    String name;

    name = wordlist[0];
    builder.RemoveShape(name);
  }

  /**
   * Process resize command.
   * @param wordlist lines of commands
   * @param builder builder method
   * @param <Doc> model
   */
  private static <Doc> void readResize(String[] wordlist, AnimationBuilder<Doc> builder) {
    wordlist = wordlist[1].split("\\s+");
    String name;
    if (wordlist.length < 3) {
      throw new IllegalArgumentException("Size value missing");
    }
    name = wordlist[0];
    int[] vals = new int[2];
    int j = 1;
    for (int i = 0; i < 2; i ++) {
      try {
        vals[i] = Integer.parseInt(wordlist[j++]);
      } catch (Exception e) {
        throw new IllegalArgumentException("Size Not integer");
      }
    }
    builder.ResizeShape(name, vals[0], vals[1]);
  }

  /**
   * Process move commands.
   * @param wordlist lines of commands
   * @param builder builder method
   * @param <Doc> model
   */
  private static <Doc> void readMove(String[] wordlist, AnimationBuilder<Doc> builder) {
    wordlist = wordlist[1].split("\\s+");
    String name;

    if (wordlist.length < 3) {
      throw new IllegalArgumentException("Move value missing");
    }
    name = wordlist[0];
    int[] vals = new int[2];
    int j = 1;
    for (int i = 0; i < 2; i ++) {
      try {
        vals[i] = Integer.parseInt(wordlist[j++]);
      } catch (Exception e) {
        throw new IllegalArgumentException("Position Not integer");
      }
    }
    builder.MoveShape(name, vals[0], vals[1]);
  }

  /**
   * Process create shape commands.
   * @param wordlist lines of commands
   * @param builder builder method
   * @param <Doc> model
   */
  private static <Doc> void readShape(String[] wordlist, AnimationBuilder<Doc> builder) {
    wordlist = wordlist[1].split("\\s+");
    String name;
    String type;

    if (wordlist.length < 9) {
      throw new IllegalArgumentException("Shape Information missing");
    }
    name = wordlist[0];
    type = wordlist[1];
    int[] vals = new int[7];
    int j = 2;
    for (int i = 0; i < 7; i ++) {
      vals[i] = Integer.parseInt(wordlist[j++]);
    }

    builder.createShape(name, type, vals[0], vals[1], vals[2],
            vals[3], vals[4], vals[5], vals[6]);
  }
}
