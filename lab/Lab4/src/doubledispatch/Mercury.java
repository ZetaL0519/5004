package doubledispatch;

/**
 * This is a Mercury class implementing IPlanet.
 */
public class Mercury implements IPlanet {
  /**
   * Mercury accepts when current explorer visits it.
   * @param explorer instance of ISpaceExplorer class.
   */
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
