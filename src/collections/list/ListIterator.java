package collections.list;

import java.io.IOException;

public class ListIterator {
  private Link3 current; 

  private Link3 previous;

  private Link3List ourList;

  public ListIterator(Link3List list) {
    ourList = list;
    reset();
  }
  //   start at 'first'
  public void reset() {
    current = ourList.getFirst();
    previous = null;
  }

  public boolean atEnd() {
    return (current.next == null);
  }

  //   go to next Link3
  public void nextLink3() {
    previous = current;
    current = current.next;
  }

  public Link3 getCurrent() {
    return current;
  }

  public void insertAfter(long dd) {
    Link3 newLink3 = new Link3(dd);

    if (ourList.isEmpty()) {
      ourList.setFirst(newLink3);
      current = newLink3;
    } else // not empty
    {
      newLink3.next = current.next;
      current.next = newLink3;
      nextLink3(); // point to new Link3
    }
  }

  public void insertBefore(long data) {
    Link3 newLink3 = new Link3(data);
    if (previous == null) {
      newLink3.next = ourList.getFirst();
      ourList.setFirst(newLink3);
      reset();
    }// not beginning
    else {
      newLink3.next = previous.next;
      previous.next = newLink3;
      current = newLink3;
    }
  }

  //   delete item at current
  public long deleteCurrent() {
    long value = current.dData;
    //     beginning of list
    if (previous == null) {
      ourList.setFirst(current.next);
      reset();
    }// not beginning
    else {
      previous.next = current.next;
      if (atEnd())
        reset();
      else
        current = current.next;
    }
    return value;
  }

  public static void main(String[] args) throws IOException {
    Link3List theList = new Link3List(); 
    ListIterator iter1 = theList.getIterator(); 
    long value;

    iter1.insertAfter(20); 
    iter1.insertAfter(40);
    iter1.insertAfter(80);
    iter1.insertBefore(60);

    if (!theList.isEmpty())
      theList.displayList();
    else
      System.out.println("List is empty");
  }
}

class Link3List {
  private Link3 first;

  public Link3List() {
    first = null;
  } 

  public Link3 getFirst() {
    return first;
  }

  public void setFirst(Link3 f) {
    first = f;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public ListIterator getIterator() {
    return new ListIterator(this); 
  }

  public void displayList() {

    Link3 current = first;

    while (current != null) {
      current.displayLink3();
      current = current.next; 
    }
    System.out.println("");
  }

}

class Link3 {
  public long dData; 

  public Link3 next; 

  public Link3(long dd) {
    dData = dd;
  }

  public void displayLink3() {
    System.out.print(dData + " ");
  }
}