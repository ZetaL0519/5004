package question10;

public class SaleCondo extends AbstractListing{
  private static final int UNITBEDROOM = 50000;
  private static final int UNITBATHROOM = 30000;

  public SaleCondo(String ID, int BedRoomNum, int BathRoomNum, PropertyCategory category, double size) {
    super(ID, BedRoomNum, BathRoomNum, category, size);
  }

  @Override
  public double calculatePrice() {
    double basePrice = UNITBEDROOM * getBedRoomNum() + UNITBATHROOM * getBathRoomNum();
    if (getSize() > 2000) {
      basePrice += 5000;
    }
    if (getCategory() == PropertyCategory.LUXURY) {
      basePrice += 50000;
    }
    return basePrice;
  }
}
