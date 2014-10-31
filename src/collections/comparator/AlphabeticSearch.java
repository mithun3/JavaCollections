package collections.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class AlphabeticSearch {

  public static void main(String[] args) {
    String[] sa = new String[] { "a", "c", "d" };
    AlphabeticComparator2 comp = new AlphabeticComparator2();
    Arrays.sort(sa, comp);
    int index = Arrays.binarySearch(sa, sa[10], comp);
    System.out.println("Index = " + index);
  }
} ///:~

@SuppressWarnings("rawtypes")
class AlphabeticComparator2 implements Comparator {
  public int compare(Object o1, Object o2) {
    String s1 = (String) o1;
    String s2 = (String) o2;
    return s1.toLowerCase().compareTo(s2.toLowerCase());
  }
} ///:~