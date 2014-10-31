package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MovingPlanets {
  public static void main(String args[]) {
    String names[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter",
        "Saturn", "Uranus", "Neptune", "Pluto" };
    List planets = new ArrayList();
    for (int i = 0, n = names.length; i < n; i++) {
      planets.add(names[i]);
    }
    ListIterator lit = planets.listIterator();
    String s;
    lit.next();
    lit.next();
    s = (String) lit.next();
    lit.remove();
    lit.next();
    lit.next();
    lit.next();
    lit.add(s);
    lit.next(); // Gets back just added
    lit.previous();
    lit.previous();
    s = (String) lit.previous();
    lit.remove();
    lit.next();
    lit.next();
    lit.add(s);
    Iterator it = planets.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}