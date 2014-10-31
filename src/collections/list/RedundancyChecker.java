package collections.list;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class RedundancyChecker {

  public static void main(String[] a) {
    new RedundancyChecker();
  }

  public RedundancyChecker() {

    Integer[] array = new Integer[5]; // Create and
    // array of
    // Integer
    Integer i0 = new Integer(0);
    array[0] = i0;
    Integer i1 = new Integer(1); // <--------
    array[1] = i1; // |
    Integer i2 = new Integer(2); // |--- redundant
    // values
    array[2] = i2; // |
    Integer i3 = new Integer(1); // <--------
    array[3] = i3;
    Integer i4 = new Integer(4);
    array[4] = i4;

    // transform the array into a List
    List l = Arrays.asList(array);

    // Check the List
    checkForRedundancy(l);
  }

  public boolean checkForRedundancy(List l) {
    ListIterator li1 = l.listIterator(); // Make a
    // general
    // ListIterator
    // on the list

    while (li1.hasNext()) {
      // Store the value of the actual first checked
      // element of the List,
      // it needs to be stored because it calls the
      // .next(), which we can call only once per loop
      // in order to sweep the whole list.
      int check1 = ((Integer) li1.next()).intValue();

      // Make a second ListIterator that will start
      // with the element that is just after the
      // actual first checked one,
      // in order to avoid checking several times the
      // same elements.
      ListIterator li2 = l.listIterator(li1.nextIndex() + 1);

      while (li2.hasNext()) {
        // Store the following elements one by
        // one and check to see if they match
        // the actual one.
        int check2 = ((Integer) li2.next()).intValue();
        if (check1 == check2) {
          System.out.println("Oh no! The value " + check1 + " is redundant.");
          return true;
        }
      }
      // The .next() method has already been called at
      // the beginning of the loop.
    }
    return false;
  }
}