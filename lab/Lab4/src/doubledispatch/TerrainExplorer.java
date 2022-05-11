package doubledispatch;

/**
 * This is a TerrainExplorer class implementing ISpaceExplorer.
 */
public class TerrainExplorer implements ISpaceExplorer {
  /**
   * Terrain Explorer visits Mercury and adds it to the log.
   * @param mercury instance of Mercury planet.
   */
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Navigating and mapping Mercury");
  }

  /**
   * Terrain Explorer visits Mars and adds it to the log.
   * @param mars instance of Mars planet.
   */
  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Navigating and mapping Mars");
  }

  /**
   * Terrain Explorer visits Venus and adds it to the log.
   * @param venus instance of Mars planet.
   */
  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Navigating and mapping Venus");
  }
}
