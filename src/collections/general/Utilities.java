package collections.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Utilities {

  public static void main(String[] args) {
    List list = Arrays.asList("one Two three Four five six one".split(" "));
    System.out.println(list);
    System.out.println("max: " + Collections.max(list));
    System.out.println("min: " + Collections.min(list));
    AlphabeticComparator comp = new AlphabeticComparator();
    System.out.println("max w/ comparator: " + Collections.max(list, comp));
    System.out.println("min w/ comparator: " + Collections.min(list, comp));
    List sublist = Arrays.asList("Four five six".split(" "));
    System.out.println("indexOfSubList: "
        + Collections.indexOfSubList(list, sublist));
    System.out.println("lastIndexOfSubList: "
        + Collections.lastIndexOfSubList(list, sublist));
    Collections.replaceAll(list, "one", "Yo");
    System.out.println("replaceAll: " + list);
    Collections.reverse(list);
    System.out.println("reverse: " + list);
    Collections.rotate(list, 3);
    System.out.println("rotate: " + list);
    List source = Arrays.asList("in the matrix".split(" "));
    Collections.copy(list, source);
    System.out.println("copy: " + list);
    Collections.swap(list, 0, list.size() - 1);
    System.out.println("swap: " + list);
    Collections.fill(list, "pop");
    System.out.println("fill: " + list);
    List dups = Collections.nCopies(3, "snap");
    System.out.println("dups: " + dups);
    // Getting an old-style Enumeration:
    Enumeration e = Collections.enumeration(dups);
    Vector v = new Vector();
    while (e.hasMoreElements())
      v.addElement(e.nextElement());
    // Converting an old-style Vector
    // to a List via an Enumeration:
    ArrayList arrayList = Collections.list(v.elements());
    System.out.println("arrayList: " + arrayList);

  }
} ///:~

class AlphabeticComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    String s1 = (String) o1;
    String s2 = (String) o2;
    return s1.toLowerCase().compareTo(s2.toLowerCase());
  }
} ///:~