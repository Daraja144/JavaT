package ru.stqa.pft.sandbox.arrays;

import java.util.*;

public class LeastFrequent {
  //return the value in the array that occurs the least number of times
  //if there are multiple least values, return the first least value
  public static int fun( int[] array ) {

    //create the map like this: <Element,Count>
    Map<Integer, Integer> counts = new HashMap<>();

    for (Integer i : array) {
      counts.merge(i, 1, Integer::sum);
      System.out.println(counts);
    }
    //find min value by sorting values and taking top element
    List<Integer> cs = new ArrayList<Integer>(counts.values());
    Collections.sort(cs);
    int minVal = cs.get(0);

    //find elements with minVal as their count
    List<Integer> minElements = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (entry.getValue() == minVal) {
        minElements.add(entry.getKey());
      }
    }
    return minElements.get(0);
  }



  //make helper methods if that would make it easier
  //a count method could be useful

  public static void main ( String[] args )
  {
    int[] stuff = {3, 4, 5, 5, 6, 6, 6, 6, 3, 3, 3, 3, -6};
    System.out.println( fun(stuff) );   //outs 4

    stuff = new int[]{3, 3, 3, 3, 3, 7, 7, 7, 7 ,7 ,7, 7, 7};
    System.out.println( fun(stuff) );   //outs 3

    stuff = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println( fun(stuff) );   //outs 1
  }
}
