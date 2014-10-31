package collections.array;

public class ChangeArrayLength {
  public static void main(String[] argv) {
    //+
    int[] a = new int[4];
    System.out.println(a.length);
    //a.length = 5;  // EXPECT COMPILE ERROR
    //-
  }
}