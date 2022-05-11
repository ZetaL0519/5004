package doubledispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * This is SimulationBuilder class managing planets and explorers.
 */
public class SimulationBuilder {
  private static final List<String> log = new ArrayList<>();

  /**
   * factory method that returns an instance.
   * of the concrete planet requested by (case-insensitive) name.
   * @param name name of the planet.
   * @return IPlanet object.
   */
  public static IPlanet createPlanet(String name) {
    if (name.toUpperCase().equals("MARS")) {
      return new Mars();
    }
    if (name.toUpperCase().equals("MERCURY")) {
      return new Mercury();
    }
    if (name.toUpperCase().equals("VENUS")) {
      return new Venus();
    }
    return null;
  }

  /**
   * Creates an instance of one of the concrete space explorers.
   * @param name name of the space explorers.
   * @return Space Explorer object.
   */
  public static ISpaceExplorer createExplorer(String name) {
    if (name.toUpperCase().equals("LIFEEXPLORER")) {
      return new LifeExplorer();
    }
    if (name.toUpperCase().equals("TERRAINEXPLORER")) {
      return new TerrainExplorer();
    }
    return null;
  }

  /**
   * Add the message to the log list.
   * @param message String form of visiting log.
   */
  public static void addToLog(String message) {
    log.add(message);
  }

  /**
   * Returns a String List with logs of all planetary exploration.
   * @return log List of Strings.
   */
  public static List<String> getSimulationLog() {
    return log;
  }
}
