package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;
import java.util.Collections;

public class DescSort {
  /*
   *	fun will return a new array with the values of
   *	mary in descending order.
   *	Post-condition: mary is not changed!
   *
   */

  public static int[] fun( int[] mary) {
    Integer maryToInteger[] = new Integer [mary.length];
    int newMary[] = new int [mary.length];

    for (int i = 0; i < mary.length; i++) {
      maryToInteger[i] = Integer.valueOf(mary[i]);
    }
    Arrays.sort(maryToInteger, Collections.reverseOrder());
    for (int y = 0; y < maryToInteger.length; y++) {
      newMary[y] += maryToInteger[y];
    }

    return newMary;
  }


  public static void main(String[] args) {
    //client code
    int[] bob = {123,213,3,43,51,6,7};
    System.out.println( Arrays.toString( bob ) );
    System.out.println( Arrays.toString( fun(bob) ) ); // [213, 123, 51, 43, 7, 6, 3]
    System.out.println();

    int[] ted = {11,12,13,41,52,64,76};
    System.out.println( Arrays.toString( ted ) );
    System.out.println( Arrays.toString( fun(ted) ) ); //[76, 64, 52, 41, 13, 12, 11]
    System.out.println();

    int[] sue = {1701,21034,36074,4243,5000,6023,7991};
    System.out.println( Arrays.toString( sue ) );
    System.out.println( Arrays.toString( fun(sue) ) ); // [36074, 21034, 7991, 6023, 5000, 4243, 1701]
  }
}
