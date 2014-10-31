package collections.set;
import java.util.HashSet;
import java.util.Set;

public class FindDupsAndUnique {
  public static void main(String args[]) {
    Set uniques = new HashSet();
    Set dups = new HashSet();
    String[] values = new String[] { "java", "java2", "java2s", "javas",
    "java" };
    for (int i = 0; i < values.length; i++)
      if (!uniques.add(values[i]))
        dups.add(values[i]);

    uniques.removeAll(dups); // Destructive set-difference

    System.out.println("Unique words:    " + uniques);
    System.out.println("Duplicate words: " + dups);
  }
}