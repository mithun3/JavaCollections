package collections.hashtablemap;

import java.util.Map;
import java.util.WeakHashMap;

public class Weak {

  public static void main(String args[]) {
    final Map map = new WeakHashMap();
    map.put(new String("Java2s"), "www.java2s.com");
    Runnable runner = new Runnable() {
      public void run() {
        while (map.containsKey("Java2s")) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException ignored) {
          }
          System.out.println("Waiting");
          System.gc();
        }
      }
    };
    Thread t = new Thread(runner);
    t.start();
    System.out.println("Main waiting");
    try {
      t.join();
    } catch (InterruptedException ignored) {
    }
  }
}