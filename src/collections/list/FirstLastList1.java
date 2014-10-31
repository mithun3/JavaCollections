package collections.list;


class Link1 {
  public long dData; 

  public Link1 next; 

  public Link1(long d){
    dData = d;
  }

  public void displayLink1(){
    System.out.print(dData + " ");
  }
}

public class FirstLastList1 {
  private Link1 first; 

  private Link1 last; 

  public FirstLastList1() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void insertLast(long dd){
    Link1 newLink1 = new Link1(dd); 
    if (isEmpty()) 
      first = newLink1; 
    else
      last.next = newLink1;
    last = newLink1; 
  }

  public long deleteFirst(){
    long temp = first.dData;
    if (first.next == null) 
      last = null;
    first = first.next; 
    return temp;
  }

  public void displayList() {
    Link1 current = first;
    while (current != null){
      current.displayLink1();
      current = current.next;
    }
    System.out.println("");
  }
}

class Link1Queue {
  private FirstLastList1 theList;

  public Link1Queue() {
    theList = new FirstLastList1();
  }

  public boolean isEmpty(){
    return theList.isEmpty();
  }

  public void insert(long j){
    theList.insertLast(j);
  }

  public long remove()
  {
    return theList.deleteFirst();
  }

  public void displayQueue() {
    System.out.print("Queue: ");
    theList.displayList();
  }

  public static void main(String[] args) {
    Link1Queue theQueue = new Link1Queue();
    theQueue.insert(20);
    theQueue.insert(40);

    theQueue.displayQueue();

    theQueue.insert(60);
    theQueue.insert(80);

    theQueue.displayQueue();

    theQueue.remove();
    theQueue.remove();

    theQueue.displayQueue();
  }
}