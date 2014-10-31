package collections.array;

import java.util.Random;

public class ArrayNew {
  static Random rand = new Random();

  public static void main(String[] args) {
    int[] a;
    a = new int[rand.nextInt(20)];
    System.out.println("length of a = " + a.length);
    for (int i = 0; i < a.length; i++)
      System.out.println("a[" + i + "] = " + a[i]);
  }
} ///:~