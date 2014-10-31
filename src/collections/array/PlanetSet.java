package collections.array;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetSet {
  public static void main(String args[]) {
    String names[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter",
        "Saturn", "Uranus", "Neptune", "Pluto" };
    Collection planets = new ArrayList();
    for (int i = 0, n = names.length; i < n; i++) {
      planets.add(names[i]);
    }
    String s[] = (String[]) planets.toArray(new String[0]);
    for (int i = 0, n = s.length; i < n; i++) {

      System.out.println(s[i]);
    }
    planets.remove(names[3]);
    System.out.println(names[1] + " " + planets.contains(names[1]));
    System.out.println(names[3] + " " + planets.contains(names[3]));
  }
}