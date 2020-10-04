package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class DigitsInOrder {
  /**
   * fun will take an int > 0, then fill an array with the digits in order.
   *
   *	ex: 1234 --> [1, 2, 3, 4]
   */
  public static int[] fun(int num){
    int j = 0;
    int len = Integer.toString(num).length();
    int[] arr = new int[len];
    while(num!=0)
    {
      arr[len-j-1] = num%10;
      num = num/10;
      j++;
    }
    return arr;
  }


  public static void main(String[] args) {
    System.out.println(Arrays.toString(fun(1234))); // [ 1, 2, 3, 4]
    System.out.println(Arrays.toString(fun(1))); // [ 1 ]
    System.out.println(Arrays.toString(fun(134711))); // [ 1, 3, 4, 7, 1, 1 ]
  }
}
