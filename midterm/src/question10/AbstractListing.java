package question10;

public class AbstractListing implements IListing{
  protected String ID;
  protected int BedRoomNum;
  protected int BathRoomNum;
  protected PropertyCategory category;
  protected double size;

  public AbstractListing(String ID, int BedRoomNum, int BathRoomNum,
                   PropertyCategory category, double size) {
    this.ID = ID;
    this.BedRoomNum = BedRoomNum;
    this.BathRoomNum = BathRoomNum;
    this.category = category;
    this.size = size;
  }

  @Override
  public double calculatePrice() {
    return 0;
  }

  @Override
  public double getSize() {
    return size;
  }

  @Override
  public int getBathRoomNum() {
    return BathRoomNum;
  }

  @Override
  public int getBedRoomNum() {
    return BedRoomNum;
  }

  @Override
  public String getID() {
    return ID;
  }

  @Override
  public PropertyCategory getCategory() {
    return category;
  }
}
