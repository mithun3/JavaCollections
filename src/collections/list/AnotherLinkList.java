package collections.list;

class Link2 {
  public int key;

  public double data; 

  public Link2 next;

  public Link2(int id, double dd) {
    key = id;
    data = dd;
  }

  public void displayLink2() {
    System.out.print("{" + key + ", " + data + "} ");
  }
}

public class AnotherLinkList {
  private Link2 first;

  public AnotherLinkList() {
    first = null;
  }

  public void insertFirst(int id, double dd) {
    Link2 newLink2 = new Link2(id, dd);
    newLink2.next = first;
    first = newLink2; 
  }

  public Link2 find(int key) 
  {
    Link2 current = first; 
    while (current.key != key)
    {
      if (current.next == null)
        return null; // didn't find it
      else
        // not end of list,
        current = current.next; // go to next Link2
    }
    return current; // found it
  }

  //   delete Link2 with given key
  public Link2 delete(int key) {
    Link2 current = first;
    Link2 previous = first;
    while (current.key != key) {
      if (current.next == null)
        return null; // didn't find it
      else {
        previous = current; // go to next Link2
        current = current.next;
      }
    } // found it
    if (current == first) // if first Link2,
      first = first.next; //    change first
    else
      // otherwise,
      previous.next = current.next; //    bypass it
    return current;
  }

  public void displayList() {
    System.out.print("List (first to last): ");
    Link2 current = first; 
    while (current != null) 
    {
      current.displayLink2(); 
      current = current.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    AnotherLinkList theList = new AnotherLinkList();

    theList.insertFirst(12, 2.59);
    theList.insertFirst(24, 4.69);
    theList.insertFirst(36, 6.79);
    theList.insertFirst(48, 8.89);

    theList.displayList();

    Link2 f = theList.find(44);
    if (f != null)
      System.out.println("Found Link2 with key " + f.key);
    else
      System.out.println("Can't find Link2");

    Link2 d = theList.delete(66); 
    if (d != null)
      System.out.println("Deleted Link2 with key " + d.key);
    else
      System.out.println("Can't delete Link2");

    theList.displayList();
  }
}