package collections.hashtablemap;

import java.io.IOException;

public class HashTable {
  private DataItem1[] hashArray; 

  private int arraySize;

  private DataItem1 bufItem; // for deleted items

  public HashTable(int size) {
    arraySize = size;
    hashArray = new DataItem1[arraySize];
    bufItem = new DataItem1(-1); // deleted item key is -1
  }

  public void displayTable() {
    System.out.print("Table: ");
    for (int j = 0; j < arraySize; j++) {
      if (hashArray[j] != null)
        System.out.print(hashArray[j].getKey() + " ");
      else
        System.out.print("#");
    }
    System.out.println("");
  }

  public int hashFunction(int key) {
    return key % arraySize; 
  }

  public void insert(DataItem1 item){
    int key = item.getKey(); 
    int hashVal = hashFunction(key); // hash the key
    // until empty cell or -1,
    while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
      ++hashVal; // go to next cell
      hashVal %= arraySize; // wraparound if necessary
    }
    hashArray[hashVal] = item; // insert item
  }

  public DataItem1 delete(int key) {
    int hashVal = hashFunction(key); 

    while (hashArray[hashVal] != null) // until empty cell,
    { 
      if (hashArray[hashVal].getKey() == key) {
        DataItem1 temp = hashArray[hashVal]; // save item
        hashArray[hashVal] = bufItem; // delete item
        return temp;
      }
      ++hashVal; // go to next cell
      hashVal %= arraySize; // wraparound if necessary
    }
    return null; // can't find item
  }

  public DataItem1 find(int key) // find item with key
  {
    int hashVal = hashFunction(key); // hash the key

    while (hashArray[hashVal] != null) // until empty cell,
    { 
      if (hashArray[hashVal].getKey() == key)
        return hashArray[hashVal]; // found, return item
      ++hashVal; // go to next cell
      hashVal %= arraySize; // wraparound if necessary
    }
    return null; // can't find item
  }

  public static void main(String[] args) throws IOException {
    DataItem1 aDataItem1;
    int aKey, size, initSize, keysPerCell;

    size = 150;
    initSize = 100;
    keysPerCell = 10;
    HashTable theHashTable = new HashTable(size);

    for (int j = 0; j < initSize; j++){
      aKey = (int) (java.lang.Math.random() * keysPerCell * size);
      aDataItem1 = new DataItem1(aKey);
      theHashTable.insert(aDataItem1);
    }

    theHashTable.displayTable();
    aDataItem1 = new DataItem1(100);
    theHashTable.insert(aDataItem1);

    theHashTable.delete(100);
    aDataItem1 = theHashTable.find(100);
    if (aDataItem1 != null) {
      System.out.println("Found " + 100);
    } else
      System.out.println("Could not find " + 100);
  }
}
class DataItem1 { 
  private int data; 

  public DataItem1(int d) {
    data = d;
  }

  public int getKey() {
    return data;
  }
}