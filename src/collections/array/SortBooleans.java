package collections.array;

import java.util.Arrays;

/**
 * Demonstrate use of Arrays.sort on Booleans(!). Try it, you'll get a
 * ClassCastException, as there is no ordering of Booleans
 * 
 * @version $Id: SortBooleans.java,v 1.2 2003/06/22 23:19:13 ian Exp $
 */
public class SortBooleans {
  public static void main(String[] unused) {
    Boolean[] data = { new Boolean(true), new Boolean(false),
        new Boolean(false), new Boolean(true), };
    Arrays.sort(data); // EXPECT RUNTIME ERROR
    for (int i = 0; i < data.length; i++)
      System.out.println(data[i]);
  }
}