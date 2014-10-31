package collections.set;
import java.util.HashSet;
import java.util.Set;

public class FindDups {
  public static void main(String args[]) {
    Set s = new HashSet();
    String[] values = new String[] { "java", "java2", "java2s", "javas",
        "java" };
    for (int i = 0; i < values.length; i++)
      if (!s.add(values[i]))
        System.out.println("Duplicate detected: " + values[i]);

    System.out.println(s.size() + " distinct words detected: " + s);
  }
}