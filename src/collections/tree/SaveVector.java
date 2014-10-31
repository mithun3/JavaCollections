package collections.tree;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class SaveVector {
  public static void main(String args[]) throws Exception {
    String data[] = { "Java", "Source", "and", "Support", "."};
    Vector v = new Vector(Arrays.asList(data));
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    ObjectOutputStream o = new ObjectOutputStream(b);
    o.writeObject(v);
    o.close();
    ByteArrayInputStream bb = new ByteArrayInputStream(b.toByteArray());
    ObjectInputStream oo = new ObjectInputStream(bb);
    Vector v2 = (Vector) oo.readObject();
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
  }
}