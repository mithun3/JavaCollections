package collections.array;

public class Welcome {
  public static void main(String[] args) {
    String[] greeting = new String[3];
    greeting[0] = "This is the greeting";
    greeting[1] = "from";
    greeting[2] = "Java Source and Support.";

    for (int i = 0; i < greeting.length; i++)
      System.out.println(greeting[i]);
  }
}