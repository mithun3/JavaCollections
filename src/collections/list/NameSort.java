package collections.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameSort {
  public static void main(String args[]) {
    String n[] = new String[] { "John", "Lennon", "Karl", "Marx",
        "Groucho", "Marx", "Oscar", "Grouch" };

    List l = Arrays.asList(n);
    Collections.sort(l);
    System.out.println(l);
  }
}