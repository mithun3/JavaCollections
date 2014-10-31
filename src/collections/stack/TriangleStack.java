package collections.stack;

import java.io.IOException;

public class TriangleStack {
  static int num;

  static int ans;

  static Stack2 theStack2;

  public static void main(String[] args) throws IOException {
    num = 100;
    Stack2Triangle();
    System.out.println("Triangle=" + ans);
  }

  public static void Stack2Triangle() {
    theStack2 = new Stack2(10000); // make a Stack2

    ans = 0; // initialize answer

    while (num > 0) // until n is 1,
    {
      theStack2.push(num); // push value
      --num; // decrement value
    }
    while (!theStack2.isEmpty()) // until Stack2 empty,
    {
      int newN = theStack2.pop(); // pop value,
      ans += newN; // add to answer
    }
  }

}

class Stack2 {
  private int maxSize; // size of Stack2 array

  private int[] data;

  private int top; // top of Stack2

  public Stack2(int s) {
    maxSize = s;
    data = new int[maxSize];
    top = -1;
  }

  public void push(int p) {
    data[++top] = p;
  }

  public int pop() {
    return data[top--];
  }

  public int peek() {
    return data[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }
}