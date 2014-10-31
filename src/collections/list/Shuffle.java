package collections.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shuffle {
  public static void main(String args[]) {
    String[] strArray = new String[] { "Java", "Source", "And", "and",
        "Support", "java2s" };

    List l = Arrays.asList(strArray);
    Collections.shuffle(l);
    System.out.println(l);
  }
} 
 
 
