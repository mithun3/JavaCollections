package collections.array;

import java.lang.reflect.Array;
import java.util.Enumeration;

final public class ArrayEnumerationFactory {
  static public Enumeration makeEnumeration(final Object obj) {
    Class type = obj.getClass();
    if (!type.isArray()) {
      throw new IllegalArgumentException(obj.getClass().toString());
    } else {
      return (new Enumeration() {
        int size = Array.getLength(obj);

        int cursor;

        public boolean hasMoreElements() {
          return (cursor < size);
        }

        public Object nextElement() {
          return Array.get(obj, cursor++);
        }
      });
    }
  }

  public static void main(String args[]) {
    Enumeration e = makeEnumeration(args);
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
    e = makeEnumeration(new int[] { 1, 3, 4, 5 });
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
    try {
      e = makeEnumeration(new Double(Math.PI));
    } catch (IllegalArgumentException ex) {
      System.err.println("Can't enumerate that: " + ex.getMessage());
    }
  }
}