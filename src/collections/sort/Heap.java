package collections.sort;
import java.io.IOException;

class MyNode {
  private int iData; 

  public MyNode(int key) {
    iData = key;
  }

  public int getKey() {
    return iData;
  }

}

public class Heap {
  private MyNode[] heapArray;

  private int maxSize;

  private int currentSize; // number of items in array

  public Heap(int mx) {
    maxSize = mx;
    currentSize = 0;
    heapArray = new MyNode[maxSize];
  }

  public MyNode remove() 
  { 
    MyNode root = heapArray[0];
    heapArray[0] = heapArray[--currentSize];
    trickleDown(0);
    return root;
  }

  public void trickleDown(int index) {
    int largerChild;
    MyNode top = heapArray[index]; 
    while (index < currentSize / 2)
    {
      int leftChild = 2 * index + 1;
      int rightChild = leftChild + 1;
      // find larger child
      if (rightChild < currentSize
          && 
          heapArray[leftChild].getKey() < heapArray[rightChild]
              .getKey())
        largerChild = rightChild;
      else
        largerChild = leftChild;

      if (top.getKey() >= heapArray[largerChild].getKey())
        break;

      heapArray[index] = heapArray[largerChild];
      index = largerChild; 
    }
    heapArray[index] = top;
  }

  public void displayHeap() {
    int nBlanks = 32;
    int itemsPerRow = 1;
    int column = 0;
    int currentIndex = 0; 
    while (currentSize > 0)
    {
      if (column == 0) 
        for (int k = 0; k < nBlanks; k++)
          System.out.print(' ');
      System.out.print(heapArray[currentIndex].getKey());

      if (++currentIndex == currentSize) // done?
        break;

      if (++column == itemsPerRow) // end of row?
      {
        nBlanks /= 2; 
        itemsPerRow *= 2; 
        column = 0; 
        System.out.println(); 
      } else
        for (int k = 0; k < nBlanks * 2 - 2; k++)
          System.out.print(' '); // interim blanks
    } 
  }

  public void displayArray() {
    for (int j = 0; j < maxSize; j++)
      System.out.print(heapArray[j].getKey() + " ");
    System.out.println("");
  }

  public void insertAt(int index, MyNode newNode) {
    heapArray[index] = newNode;
  }

  public void incrementSize() {
    currentSize++;
  }

  public static void main(String[] args) throws IOException {
    int size, i;

    size = 100;
    Heap theHeap = new Heap(size);

    for (i = 0; i < size; i++) {
      int random = (int) (java.lang.Math.random() * 100);
      MyNode newNode = new MyNode(random);
      theHeap.insertAt(i, newNode);
      theHeap.incrementSize();
    }

    System.out.print("Random: ");
    theHeap.displayArray();
    for (i = size / 2 - 1; i >= 0; i--)
      theHeap.trickleDown(i);

    System.out.print("Heap:   ");
    theHeap.displayArray();
    theHeap.displayHeap();
    for (i = size - 1; i >= 0; i--) {
      MyNode biggestNode = theHeap.remove();
      theHeap.insertAt(i, biggestNode);
    }
    System.out.print("Sorted: ");
    theHeap.displayArray();
  }
}