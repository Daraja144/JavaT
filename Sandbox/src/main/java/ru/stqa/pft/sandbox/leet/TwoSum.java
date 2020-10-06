package ru.stqa.pft.sandbox.leet;

import java.util.Arrays;

public class TwoSum {

  public static int [] twoSum(int[] nums, int target) {

    int[] result = new int[2];
    int length = nums.length;
    int n = 0;

    while (n < length) {
      int i = n+1;

      while (i < length) {

        if (nums[n] + nums[i] == target) {
          result[0] = n;
          result[1] = i;
          System.out.println(n + "," + i);
          break;
        }
        i++;
        }
        n++;
      }
    return result;
  }

  public static void main(String[] args) {
    int[] result;
    int[] nums = {2,4,5,3};
    int target = 6;
    System.out.println(Arrays.toString(nums));
    result = twoSum(nums, target);
    System.out.println(Arrays.toString(result));
  }
}
