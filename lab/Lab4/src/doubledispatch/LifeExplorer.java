package doubledispatch;

/**
 * LifeExplorer class implementing ISpaceExplorer.
 */
public  class LifeExplorer implements ISpaceExplorer {
  /**
   * LifeExplorer visits Mercury and add it to the log.
   * @param mercury instance of Mercury planet.
   */
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Landing on Mercury...exploring for life");
  }

  /**
   * LifeExplorer visits Mars and add it to the log.
   * @param mars instance of Mars planet.
   */
  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Landing on Mars...exploring for life");
  }

  /**
   * LifeExplorer visits Venus and add it to the log.
   * @param venus instance of Venus planet.
   */
  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Landing on Venus...exploring life");
  }
}