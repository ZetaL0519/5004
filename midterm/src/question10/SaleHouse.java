package question10;

public class SaleHouse extends AbstractListing{
  private final static int UNITPRICE = 200;

  public SaleHouse(String ID, int BedRoomNum, int BathRoomNum, PropertyCategory category, double size) {
    super(ID, BedRoomNum, BathRoomNum, category, size);
  }

  @Override
  public double calculatePrice() {
    double basePrice = UNITPRICE * getSize();
    if (getBedRoomNum() > 3) {
      basePrice += 10000;
    }
    if (getCategory() == PropertyCategory.LUXURY) {
      basePrice += 50000;
    }
    return basePrice;
  }
}
