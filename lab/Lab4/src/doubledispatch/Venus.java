package doubledispatch;

/**
 * This is a Venus class implementing IPlanet.
 */
public class Venus implements IPlanet {
  /**
   * Venus accepts when current explorer visits it.
   * @param explorer instance of ISpaceExplorer class.
   */
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
