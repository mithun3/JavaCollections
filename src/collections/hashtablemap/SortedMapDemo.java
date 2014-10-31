package collections.hashtablemap;

import java.util.Iterator;
import java.util.TreeMap;

public class SortedMapDemo {

  public static void main(String[] args) {
    TreeMap sortedMap = new TreeMap();
    sortedMap.put("Adobe", "Mountain View, CA");
    sortedMap.put("IBM", "White Plains, NY");
    sortedMap.put("Learning Tree", "Los Angeles, CA");
    sortedMap.put("Microsoft", "Redmond, WA");
    sortedMap.put("Netscape", "Mountain View, CA");
    sortedMap.put("O'Reilly", "Sebastopol, CA");
    sortedMap.put("Sun", "Mountain View, CA");
    System.out.println(sortedMap);
    Object low = sortedMap.firstKey(), high = sortedMap.lastKey();
    System.out.println(low);
    System.out.println(high);
    Iterator it = sortedMap.keySet().iterator();
    for (int i = 0; i <= 6; i++) {
      if (i == 3)
        low = it.next();
      if (i == 6)
        high = it.next();
      else
        it.next();
    }
    System.out.println(low);
    System.out.println(high);
    System.out.println(sortedMap.subMap(low, high));
    System.out.println(sortedMap.headMap(high));
    System.out.println(sortedMap.tailMap(low));
  }
} ///:~