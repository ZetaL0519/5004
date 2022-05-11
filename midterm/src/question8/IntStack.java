package question8;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class IntStack<T> {
  private T data;
  private List<T> stack ;

  private T getData() {
    return this.data;
  }

  public IntStack () {
    stack = new ArrayList<T>();
  }

  public boolean empty () {
    return stack.size() == 0 ;
  }

  // push and pop operations
  public void push (T obj) {
    stack.add(obj);
  }

  public T pop () {
    if (stack.size() <= 0) {
      throw new EmptyStackException();
    }
    return stack.remove(stack.size() - 1);
  }

  public T peek () {
    if (stack.size() == 0) {
      return null;
    }
    return stack.get(stack.size() - 1);
  }

  public boolean hasNext() {
    return ( stack.size() > 0 );
  }

  @Override
  public String toString() { return stack.toString(); }

  public static void main(String [] args) {
    IntStack istack = new IntStack();
    istack.push(1);
    istack.push(2);
    System.out.println(istack);
    System.out.println(istack.pop());
    System.out.println(istack);

  }
}