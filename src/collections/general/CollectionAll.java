package collections.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionAll {
  public static void main(String[] args) {
    List list1 = new LinkedList();
    list1.add("list");
    list1.add("dup");
    list1.add("x");
    list1.add("dup");
    traverse(list1); 
    List list2 = new ArrayList();
    list2.add("list");
    list2.add("dup");
    list2.add("x");
    list2.add("dup");
    traverse(list2); 
    Set set1 = new HashSet();
    set1.add("set");
    set1.add("dup");
    set1.add("x");
    set1.add("dup");
    traverse(set1); 
    SortedSet set2 = new TreeSet();
    set2.add("set");
    set2.add("dup");
    set2.add("x");
    set2.add("dup");
    traverse(set2); 
    LinkedHashSet set3 = new LinkedHashSet();
    set3.add("set");
    set3.add("dup");
    set3.add("x");
    set3.add("dup");
    traverse(set3); 
    Map m1 = new HashMap();
    m1.put("map", "Java2s");
    m1.put("dup", "Kava2s");
    m1.put("x", "Mava2s");
    m1.put("dup", "Lava2s");
    traverse(m1.keySet()); 
    traverse(m1.values()); 
    SortedMap m2 = new TreeMap();
    m2.put("map", "Java2s");
    m2.put("dup", "Kava2s");
    m2.put("x", "Mava2s");
    m2.put("dup", "Lava2s");
    traverse(m2.keySet()); 
    traverse(m2.values()); 
    LinkedHashMap /* from String to String */m3 = new LinkedHashMap();
    m3.put("map", "Java2s");
    m3.put("dup", "Kava2s");
    m3.put("x", "Mava2s");
    m3.put("dup", "Lava2s");
    traverse(m3.keySet()); 
    traverse(m3.values()); 
  }

  static void traverse(Collection coll) {
    Iterator iter = coll.iterator();
    while (iter.hasNext()) {
      String elem = (String) iter.next();
      System.out.print(elem + " ");
    }
    System.out.println();
  }

}