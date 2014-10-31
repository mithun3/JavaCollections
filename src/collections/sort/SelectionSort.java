package collections.sort;
public class SelectionSort {
  private long[] a;

  private int nElems;

  public SelectionSort(int max) {
    a = new long[max];
    nElems = 0;
  }

  public void insert(long value) {
    a[nElems] = value;
    nElems++;
  }

  public void display() {
    for (int j = 0; j < nElems; j++)
      System.out.print(a[j] + " ");
    System.out.println("");
  }

  public void selectionSort() {
    int out, in, min;

    for (out = 0; out < nElems - 1; out++) // outer loop
    {
      min = out; // minimum
      for (in = out + 1; in < nElems; in++)
        // inner loop
        if (a[in] < a[min]) // if min greater,
          min = in; // a new min
      swap(out, min); // swap them
    }
  }

  private void swap(int one, int two) {
    long temp = a[one];
    a[one] = a[two];
    a[two] = temp;
  }

  public static void main(String[] args) {
    int maxSize = 100;
    SelectionSort arr; // reference to array
    arr = new SelectionSort(maxSize); // create the array

    arr.insert(17); // insert 10 items
    arr.insert(29);
    arr.insert(34);
    arr.insert(45);
    arr.insert(52);
    arr.insert(68);
    arr.insert(71);
    arr.insert(80);
    arr.insert(96);
    arr.insert(33);

    arr.display();

    arr.selectionSort();

    arr.display();
  }

}