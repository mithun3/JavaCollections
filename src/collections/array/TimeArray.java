package collections.array;

public class TimeArray {
  public static void main(String args[]) {
    long startTime = System.currentTimeMillis();
    for (int i = 0, n = Integer.MAX_VALUE; i < n; i++) {
      ;
    }
    long midTime = System.currentTimeMillis();
    for (int i = Integer.MAX_VALUE - 1; i >= 0;) {
      ;
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Increasing: " + (midTime - startTime));
    System.out.println("Decreasing: " + (endTime - midTime));
  }
} 
 
 
