package collections.comparator;

import java.util.*;

public class CompTest {
  public static void main(String args[]) {
    ArrayList u2 = new ArrayList();
    u2.add("Beautiful Day");
    u2.add("Stuck In A Moment You Can't Get Out Of");
    u2.add("Elevation");
    u2.add("Walk On");
    u2.add("Kite");
    u2.add("In A Little While");
    u2.add("Wild Honey");
    u2.add("Peace On Earth");
    u2.add("When I Look At The World");
    u2.add("New York");
    u2.add("Grace");

    Comparator comp = Comparators.stringComparator();
    Collections.sort(u2, comp);
    System.out.println(u2);

    Arrays.sort(args, comp);
    System.out.print("[");
    for (int i=0, n=args.length; i<n; i++) {
      if (i != 0) System.out.print(", ");
      System.out.print(args[i]);
    }
    System.out.println("]");
  }
}
class Comparators {

  public static Comparator stringComparator() {
    return new Comparator() {

      public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        int len1 = s1.length();
        int len2 = s2.length();
        int n = Math.min(len1, len2);
        char v1[] = s1.toCharArray();
        char v2[] = s2.toCharArray();
        int pos = 0;

        while (n-- != 0) {
          char c1 = v1[pos];
          char c2 = v2[pos];
          if (c1 != c2) {
            return c1 - c2;
          }
          pos++;
        }
        return len1 - len2;
      }
    };
  }

  public static Comparator integerComparator() {
    return new Comparator() {

      public int compare(Object o1, Object o2) {
        int val1 = ((Integer)o1).intValue();
        int val2 = ((Integer)o2).intValue();
        return (val1<val2 ? -1 : (val1==val2 ? 0 : 1));
      }
    };
  }

  public static Comparator dateComparator() {
    return new Comparator() {

      public int compare(Object o1, Object o2) {
        long val1 = ((Date)o1).getTime();
        long val2 = ((Date)o2).getTime();
        return (val1<val2 ? -1 : (val1==val2 ? 0 : 1));
      }
    };
  }
} 
 
 
