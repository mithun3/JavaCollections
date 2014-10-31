package collections.comparator;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class DirList3 {
  public static void main(final String[] args) {
    File path = new File(".");
    String[] list;
    if (args.length == 0)
      list = path.list();
    else
      list = path.list(new FilenameFilter() {
        private Pattern pattern = Pattern.compile(args[0]);

        public boolean accept(File dir, String name) {
          return pattern.matcher(new File(name).getName()).matches();
        }
      });
    Arrays.sort(list, new AlphabeticComparator());
    for (int i = 0; i < list.length; i++)
      System.out.println(list[i]);
  }
} ///:~

class AlphabeticComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    String s1 = (String) o1;
    String s2 = (String) o2;
    return s1.toLowerCase().compareTo(s2.toLowerCase());
  }
} ///:~