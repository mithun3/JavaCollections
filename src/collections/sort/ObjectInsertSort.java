package collections.sort;
public class ObjectInsertSort {
  private Person[] a;

  private int nElems;

  public ObjectInsertSort(int max) {
    a = new Person[max];
    nElems = 0;
  }

  // put person into array
  public void insert(String last, String first, int age) {
    a[nElems] = new Person(last, first, age);
    nElems++;
  }

  public void display() {
    for (int j = 0; j < nElems; j++)
      a[j].displayPerson();
  }

  public void insertionSort() {
    int in, out;

    for (out = 1; out < nElems; out++) {
      Person temp = a[out]; // out is dividing line
      in = out; // start shifting at out

      while (in > 0 && // until smaller one found,
          a[in - 1].getLast().compareTo(temp.getLast()) > 0) {
        a[in] = a[in - 1]; // shift item to the right
        --in; // go left one position
      }
      a[in] = temp; // insert marked item
    }
  }

  public static void main(String[] args) {
    int maxSize = 100; // array size
    ObjectInsertSort arr;
    arr = new ObjectInsertSort(maxSize); // create the array

    arr.insert("Jo", "Yin", 24);
    arr.insert("Pengzhou", "Yin", 59);
    arr.insert("James", "Chen", 37);
    arr.insert("Chirs", "Paul", 37);
    arr.insert("Rob", "Tom", 43);
    arr.insert("Carlo", "Sato", 21);
    arr.insert("Al", "Henry", 29);
    arr.insert("Nancy", "Jose", 72);
    arr.insert("Vang", "Minh", 22);

    System.out.println("Before sorting:");
    arr.display(); // display items

    arr.insertionSort(); // insertion-sort them

    System.out.println("After sorting:");
    arr.display(); // display them again
  }
}

class Person {
  private String lastName;

  private String firstName;

  private int age;

  public Person(String last, String first, int a) {
    lastName = last;
    firstName = first;
    age = a;
  }

  public void displayPerson() {
    System.out.print("   Last name: " + lastName);
    System.out.print(", First name: " + firstName);
    System.out.println(", Age: " + age);
  }

  public String getLast() {
    return lastName;
  }
} 
 
 
