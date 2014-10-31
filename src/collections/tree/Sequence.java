package collections.tree;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Sequence {
  public static void main(String args[]) throws IOException {
    Vector v = new Vector(3);
    v.add(new FileInputStream("/etc/motd"));
    v.add(new FileInputStream("foo.bar"));
    v.add(new FileInputStream("/temp/john.txt"));
    Enumeration e = v.elements();
    SequenceInputStream sis = new SequenceInputStream(e);
    InputStreamReader isr = new InputStreamReader(sis);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    br.close();
  }
}