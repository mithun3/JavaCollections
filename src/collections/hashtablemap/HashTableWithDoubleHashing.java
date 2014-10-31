package collections.hashtablemap;

import java.io.IOException;

public class HashTableWithDoubleHashing {
  private DataItem[] hashArray; 

  private int arraySize;

  private DataItem bufItem; // for deleted items

  HashTableWithDoubleHashing(int size) {
    arraySize = size;
    hashArray = new DataItem[arraySize];
    bufItem = new DataItem(-1);
  }

  public void displayTable() {
    System.out.print("Table: ");
    for (int j = 0; j < arraySize; j++) {
      if (hashArray[j] != null)
        System.out.print(hashArray[j].getKey() + " ");
      else
        System.out.print("** ");
    }
    System.out.println("");
  }

  public int hashFunc1(int key) {
    return key % arraySize;
  }

  public int hashFunc2(int key) {
    return 6 - key % 6;
  }

  public void insert(int key, DataItem item) {
    int hashVal = hashFunc1(key); // hash the key
    int stepSize = hashFunc2(key); // get step size
    // until empty cell or -1
    while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // for wraparound
    }
    hashArray[hashVal] = item; // insert item
  }

  public DataItem delete(int key) {
    int hashVal = hashFunc1(key); 
    int stepSize = hashFunc2(key); // get step size

    while (hashArray[hashVal] != null) {
      if (hashArray[hashVal].getKey() == key) {
        DataItem temp = hashArray[hashVal]; // save item
        hashArray[hashVal] = bufItem; // delete item
        return temp; // return item
      }
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // for wraparound
    }
    return null; // can't find item
  }

  public DataItem find(int key) {
    int hashVal = hashFunc1(key); // hash the key
    int stepSize = hashFunc2(key); // get step size

    while (hashArray[hashVal] != null) {
      if (hashArray[hashVal].getKey() == key)
        return hashArray[hashVal]; // yes, return item
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // for wraparound
    }
    return null; // can't find item
  }

  public static void main(String[] args) throws IOException {
    int aKey;
    DataItem aDataItem;
    int size, initSize;
    size = 100;
    initSize = 10;
    HashTableWithDoubleHashing theHashTable = new HashTableWithDoubleHashing(
        size);
    for (int i = 0; i < initSize; i++) {
      aKey = (int) (java.lang.Math.random() * 2 * size);
      aDataItem = new DataItem(aKey);
      theHashTable.insert(aKey, aDataItem);
    }

    theHashTable.displayTable();
    aKey = 100;
    aDataItem = new DataItem(aKey);
    theHashTable.insert(aKey, aDataItem);
    aKey = 100;
    theHashTable.delete(aKey);
    aKey = 100;
    aDataItem = theHashTable.find(aKey);
    if (aDataItem != null)
      System.out.println("Found " + aKey);
    else
      System.out.println("Could not find " + aKey);
  }

}

class DataItem {
  private int data;

  public DataItem(int i) {
    data = i;
  }

  public int getKey() {
    return data;
  }

} 
 
 
