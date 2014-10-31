package collections.array;

import java.lang.reflect.Array;

public class ArrayGrowTest {
  public static void main(String[] args) {
    int[] a = { 1, 2, 3 };
    a = (int[]) arrayGrow(a);
    arrayPrint(a);
  }

  static Object arrayGrow(Object a) {
    Class cl = a.getClass();
    if (!cl.isArray())
      return null;
    Class componentType = a.getClass().getComponentType();
    int length = Array.getLength(a);
    int newLength = length + 10;

    Object newArray = Array.newInstance(componentType, newLength);
    System.arraycopy(a, 0, newArray, 0, length);
    return newArray;
  }

  static void arrayPrint(Object a) {
    Class cl = a.getClass();
    if (!cl.isArray())
      return;
    Class componentType = a.getClass().getComponentType();
    int length = Array.getLength(a);
    System.out.println(componentType.getName() + "[" + length + "]");
    for (int i = 0; i < length; i++)
      System.out.println(Array.get(a, i));
  }
}