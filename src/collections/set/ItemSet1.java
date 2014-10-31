package collections.set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ItemSet1 {
  public static void main(String args[]) {
    String names[] = { "Item 1", "Item 2", "Item 3"};
    Set moons = new HashSet();
    int namesLen = names.length;
    int index;
    for (int i = 0; i < 100; i++) {
      index = (int) (Math.random() * namesLen);
      moons.add(names[index]);
    }
    Iterator it = moons.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println("---");
    Set orderedMoons = new TreeSet(moons);
    it = orderedMoons.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}