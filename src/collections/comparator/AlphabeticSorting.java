package collections.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class AlphabeticSorting {
  public static void main(String[] args) {
    String[] sa = new String[] { "x", "c", "b" };

    System.out.println("Before sorting: " + Arrays.asList(sa));
    Arrays.sort(sa, new AlphabeticComparator1());
    System.out.println("After sorting: " + Arrays.asList(sa));
  }
} ///:~

@SuppressWarnings("rawtypes")
class AlphabeticComparator1 implements Comparator {
  public int compare(Object o1, Object o2) {
    String s1 = (String) o1;
    String s2 = (String) o2;
    return s1.toLowerCase().compareTo(s2.toLowerCase());
  }
} ///:~