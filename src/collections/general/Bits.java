package collections.general;

public class Bits { 
  public static void main(String args[]) { 
    int n = 170; // 10101010 
    System.out.println("Value in binary: 10101010"); 
    System.out.println("Number of one bits: " + 
                       Integer.bitCount(n)); 
    System.out.println("Highest one bit: " + 
                       Integer.highestOneBit(n)); 
    System.out.println("Lowest one bit: " + 
                       Integer.lowestOneBit(n)); 
    System.out.println("Number of leading zeros : " + 
                       Integer.numberOfLeadingZeros(n)); 
    System.out.println("Number of trailing zeros : " + 
                       Integer.numberOfTrailingZeros(n)); 
    System.out.println("\nBeginning with the value 1, " + 
                       "rotate left 16 times."); 
    n = 1; 
    for(int i=0; i < 16; i++) { 
      n = Integer.rotateLeft(n, 1); 
      System.out.println(n); 
    } 
  } 
}