package doubledispatch;

/**
 * This is a Mars class implementing IPlanet.
 */
public class Mars implements IPlanet {
  /**
   * Mars accepts when current explorer visits it.
   * @param explorer instance of ISpaceExplorer class.
   */
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
