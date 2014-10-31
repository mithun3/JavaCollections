package collections.sort;
public class InsertSort {
  private long[] number;

  private int nElems;

  public InsertSort(int max) {
    number = new long[max];
    nElems = 0;
  }

  public void insert(long value) {
    number[nElems] = value;
    nElems++;
  }

  public void display() {
    for (int j = 0; j < nElems; j++)
      System.out.print(number[j] + " ");
    System.out.println("");
  }

  public void insertionSort() {
    int in, out;
    //     out is dividing line
    for (out = 1; out < nElems; out++) {
      long temp = number[out]; // remove marked item
      in = out; // start shifts at out
      while (in > 0 && number[in - 1] >= temp) // until one is smaller,
      {
        number[in] = number[in - 1]; // shift item to right
        --in; // go left one position
      }
      number[in] = temp; // insert marked item
    }
  }

  public static void main(String[] args) {
    int maxSize = 100; // array size
    InsertSort arr; // reference to array
    arr = new InsertSort(maxSize); // create the array

    arr.insert(47);
    arr.insert(99);
    arr.insert(44);
    arr.insert(35);
    arr.insert(22);
    arr.insert(88);
    arr.insert(41);
    arr.insert(00);
    arr.insert(16);
    arr.insert(33);

    arr.display();

    arr.insertionSort();

    arr.display();
  }

}