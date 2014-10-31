package collections.set;
import java.util.*;
/**
 * Demonstrate the Set interface
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: SetDemo.java,v 1.4 2004/02/09 03:34:04 ian Exp $
 */
public class SetDemo {
  public static void main(String[] argv) {
    //+
    Set h = new HashSet();
    h.add("One");
    h.add("Two");
    h.add("One"); // DUPLICATE
    h.add("Three");
    Iterator it = h.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    //-
  }
}