package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class Fibonacci {
  /* 	fun will take an array of ints and sum two consecutive ints
   * 	and put them in a new array, until there are not two consecutive ints.
   *	Hint: the length of the new array will be one less than the array given.
   */
  public static int[] fun(int[] nums){
    int newSum[] = new int[nums.length-1];
    int sum;
    for (int i = 0; i + 1 < nums.length; i++ ) {
      sum = nums[i] + nums[i+1];
      //System.out.println(sum);
      newSum[i] += sum;
    }
    return newSum;
  }

  public static void main(String[] args) {
    int[] x = {0,1,2,3,4,5};
    System.out.println(Arrays.toString(x));
    System.out.println(Arrays.toString(fun(x))); // [1, 3, 5, 7, 9]
    System.out.println();

    int[] y = {6, 13, 21, 34, 47, 52, 68, 75, 89, 90};
    System.out.println(Arrays.toString(y));
    System.out.println(Arrays.toString(fun(y))); // [19, 34, 55, 81, 99, 12, 143, 164, 179]
    System.out.println();

    int[] z = {1, 22, 333, 4444, 55555};
    System.out.println(Arrays.toString(z));
    System.out.println(Arrays.toString(fun(z))); // [23, 355, 4777, 59999]

  }
}
