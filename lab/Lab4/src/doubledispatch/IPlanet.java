package doubledispatch;

/**
 * This is an IPlanet class.
 */
public interface IPlanet {
  /**
   * The planet would only accept when the explorer visits the planet.
   * @param explorer instance of ISpaceExplorer class.
   */
  void accept(ISpaceExplorer explorer);
}
