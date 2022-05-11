package doubledispatch;

/**
 * This is the interface class for space explorer.
 */
public interface ISpaceExplorer {
  /**
   * Space Explorer visit Mercury.
   * @param mercury instance of Mercury planet.
   */
  void visit(Mercury mercury);

  /**
   * Space Explorer visit Mars.
   * @param mars instance of Mars planet.
   */
  void visit(Mars mars);

  /**
   * Space Explorer visit Venus.
   * @param venus instance of Venus planet.
   */
  void visit(Venus venus);

  /**
   * Space Explorer visit other planet object.
   * @param aPlanet instance of IPlanet class.
   */
  default void visit(IPlanet aPlanet) {
    SimulationBuilder.addToLog("Visiting an unknown planet");
  }
}