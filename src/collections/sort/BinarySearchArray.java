package collections.sort;
public class BinarySearchArray {
  private long[] a; 

  private int nElems; 

  public BinarySearchArray(int max) {
    a = new long[max]; // create array
    nElems = 0;
  }

  public int size() {
    return nElems;
  }

  public int find(long searchKey) {
    return recFind(searchKey, 0, nElems - 1);
  }

  private int recFind(long searchKey, int lowerBound, int upperBound) {
    int curIn;

    curIn = (lowerBound + upperBound) / 2;
    if (a[curIn] == searchKey)
      return curIn; // found it
    else if (lowerBound > upperBound)
      return nElems; // can't find it
    else // divide range
    {
      if (a[curIn] < searchKey) // in upper half
        return recFind(searchKey, curIn + 1, upperBound);
      else
        // in lower half
        return recFind(searchKey, lowerBound, curIn - 1);
    }
  }

  public void insert(long value) {
    int j;
    for (j = 0; j < nElems; j++)
      // find where it goes
      if (a[j] > value) // (linear search)
        break;
    for (int k = nElems; k > j; k--)
      // move bigger ones up
      a[k] = a[k - 1];
    a[j] = value; // insert it
    nElems++; // increment size
  }

  public void display() {
    for (int j = 0; j < nElems; j++)
      System.out.print(a[j] + " "); 
    System.out.println("");
  }
  public static void main(String[] args) {
    int maxSize = 100; 
    BinarySearchArray arr = new BinarySearchArray(maxSize); 

    arr.insert(12); 
    arr.insert(20);
    arr.insert(35);
    arr.insert(426);
    arr.insert(54);
    arr.insert(69);
    arr.insert(744);
    arr.insert(87);
    arr.insert(895);
    arr.insert(89);
    arr.insert(8);
    arr.insert(208);
    arr.insert(4);
    arr.insert(617);
    arr.insert(83);
    arr.insert(96);

    arr.display(); // display array

    int searchKey = 27; // search for item
    if (arr.find(searchKey) != arr.size())
      System.out.println("Found " + searchKey);
    else
      System.out.println("Can't find " + searchKey);
  }
}