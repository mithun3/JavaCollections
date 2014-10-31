package collections.list;

public class FirstLastList {
  private Link first; // ref to first link

  private Link last; // ref to last link

  public FirstLastList() {
    first = null; 
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void insertFirst(long dd) {
    Link newLink = new Link(dd); // make new link

    if (isEmpty()) 
      last = newLink; 
    newLink.next = first; 
    first = newLink; 
  }

  public void insertLast(long dd) {
    Link newLink = new Link(dd); 
    if (isEmpty()) 
      first = newLink; 
    else
      last.next = newLink; 
      last = newLink; 
  }

  public long deleteFirst(){ 
    long temp = first.dData;
    if (first.next == null) // if only one item
      last = null; 
    first = first.next; 
    return temp;
  }

  public void displayList() {
    System.out.print("List: ");
    Link current = first; 
    while (current != null)
    {
      current.displayLink(); 
      current = current.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) { // make a new list
    FirstLastList theList = new FirstLastList();

    theList.insertFirst(22);
    theList.insertFirst(44);

    theList.insertLast(33);
    theList.insertLast(55);

    theList.displayList();

    theList.deleteFirst();
    theList.deleteFirst();

    theList.displayList();
  } 
  class Link {
    public long dData; 
    public Link next; 
    public Link(long d) {
      dData = d;
    }
    public void displayLink() {
      System.out.print(dData + " ");
    }
  }

}