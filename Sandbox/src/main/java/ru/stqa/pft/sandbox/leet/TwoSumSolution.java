package ru.stqa.pft.sandbox.leet;

import java.util.*;

public class TwoSumSolution {

  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[] { i, j };
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    int[] result;
    int[] nums = {3,4,3,0,1,5,9,7};
    int target = 6;
    System.out.println(Arrays.toString(nums));
    result = twoSum(nums, target);
    System.out.println(Arrays.toString(result));
  }
}
