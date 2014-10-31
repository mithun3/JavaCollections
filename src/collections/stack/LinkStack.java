package collections.stack;
public class LinkStack {
  private LinkList list;

  public LinkStack() {
    list = new LinkList();
  }

  public void push(long j) {
    list.insertFirst(j);
  }

  public long pop() {
    return list.deleteFirst();
  }

  public boolean isEmpty() {
    return (list.isEmpty());
  }

  public void displayStack() {
    System.out.print("Stack: ");
    list.displayList();
  }

  public static void main(String[] args) {
    LinkStack theStack = new LinkStack();

    theStack.push(20);
    theStack.push(40);

    theStack.displayStack();

    theStack.push(60);
    theStack.push(80);

    theStack.displayStack();

    theStack.pop();
    theStack.pop();

    theStack.displayStack();
  }

  class LinkList {
    private Link first;

    public LinkList() {
      first = null;
    }

    public boolean isEmpty() {
      return (first == null);
    }

    public void insertFirst(long d) {
      Link newLink = new Link(d);
      newLink.next = first;
      first = newLink;
    }

    public long deleteFirst() {
      Link buf = first;
      first = first.next;
      return buf.data;
    }

    public void displayList() {
      Link current = first;
      while (current != null) {
        current.displayLink();
        current = current.next;
      }
      System.out.println("");
    }

    class Link {
      public long data; // data item

      public Link next; // next link in list

      public Link(long d) {
        data = d;
      }

      public void displayLink() {
        System.out.print(data + " ");
      }
    }

  }
}