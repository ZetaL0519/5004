import java.util.Comparator;

public interface ShapeListADT {

  void addToFront(IShape d);

  void addToBack(IShape d);

  void sort(Comparator<IShape> comp);

  int count();

  IShape get(int i);

  void remove(int i);
}
