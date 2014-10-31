package collections.array;

import java.lang.reflect.Array;
import java.util.Enumeration;

public class ArrayEnumeration implements Enumeration {
  private final int size;

  private int cursor;

  private final Object array;

  public ArrayEnumeration(Object obj) {
    Class type = obj.getClass();
    if (!type.isArray()) {
      throw new IllegalArgumentException("Invalid type: " + type);
    }
    size = Array.getLength(obj);
    array = obj;
  }

  public boolean hasMoreElements() {
    return (cursor < size);
  }

  public Object nextElement() {
    return Array.get(array, cursor++);
  }

  public static void main(String args[]) {
    Object obj = new int[] { 2, 3, 5, 8, 13, 21 };
    ArrayEnumeration e = new ArrayEnumeration(obj);
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
    try {
      e = new ArrayEnumeration(ArrayEnumeration.class);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
} 
 
 
