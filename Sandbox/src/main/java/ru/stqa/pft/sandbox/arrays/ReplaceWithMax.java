package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class ReplaceWithMax {
  public static void fun(int[] nums) {
    /*	fun finds the smallest value in the array
     *	and replaces it with Integer.MAX_VALUE */
    // remember NO return, this is a void method!!!

    int minIndex = 0;  // start with 0th element as min
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < nums[minIndex]) {
        minIndex = i;
      }
    }
    nums[minIndex] = Integer.MAX_VALUE;
  }

  public static void main(String[] args) {
    //client code
    int[] bob = {123,213,3,43,51,6,7};
    System.out.println( Arrays.toString( bob ) ); // smallest = 3
    fun(bob);
    System.out.println( Arrays.toString( bob ) );
    System.out.println();

    int[] ted = {11,12,13,41,52,64,76};
    System.out.println( Arrays.toString( ted ) ); // smallest = 11
    fun(ted);
    System.out.println( Arrays.toString( ted ) );
    System.out.println();

    int[] sue = {170151,21034,36074,4243,5000,6023,7991};
    System.out.println( Arrays.toString( sue ) );// smallest = 4243
    fun(sue);
    System.out.println( Arrays.toString( sue ) );
  }
}
