package collections.stack;
import java.io.IOException;

public class Triangle {

  public static void main(String[] args) throws IOException {
    int theNumber = 100;
    int theAnswer = triangle(theNumber);
    System.out.println("Triangle=" + theAnswer);
  }

  public static int triangle(int n) {
    if (n == 1)
      return 1;
    else
      return (n + triangle(n - 1));
  }

}