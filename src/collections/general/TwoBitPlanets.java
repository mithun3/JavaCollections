package collections.general;

import java.util.BitSet;

public class TwoBitPlanets {
  public static void main(String args[]) {
    String names[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter",
        "Saturn", "Uranus", "Neptune", "Pluto" };
    int moons[] = { 0, 0, 1, 2, 16, 18, 17, 8, 1 };
    int namesLen = names.length;
    BitSet bits = new BitSet(namesLen);
    for (int i = 0; i < namesLen; i++) {
      if ((moons[i] % 2) == 0) {
        bits.set(i);
      }
    }
    for (int i = 0; i < namesLen; i++) {
      System.out.println(names[i] + " Even # Moons (" + moons[i] + ")? "
          + bits.get(i));
    }
  }
}