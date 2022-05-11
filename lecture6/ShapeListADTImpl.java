import java.util.Comparator;

public class ShapeListADTImpl implements ShapeListADT {
  private IListShape head;

  public ShapeListADTImpl() {
    head = new EmptyNode();
  }

  @Override
  public void addToFront(IShape shape) {
    this.head = new ElementNode(shape, this.head); // head.addToFront(d);
  }

  @Override
  public void addToBack(IShape shape) {
    this.head = this.head.addToBack(shape);
  }

  @Override
  public void sort(Comparator<IShape> comparator) {
    this.head = this.head.sort(comparator);
  }

  @Override
  public int count() {
    return head.count();
  }

  @Override
  public IShape get(int i) {
    return head.get(i);
  }

  @Override
  public void remove(int i) {
    head = head.remove(i);
  }

}
