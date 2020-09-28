package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class Increasing {
  //method fun will return true if all numbers are in increasing order
  //method fun will return false if all numbers are not increasing
  public static boolean fun( int[] ann ) {

    for (int i = 0; i < ann.length-1; i++) {
      if (ann[i] > ann[i + 1]) {
        return false;
       }
      }
    return true;
    }


  public static void main(String[] args)
  {
    //client code
    int[] bob = {-10,21,31,4,5,16,7};
    System.out.println( Arrays.toString( bob ) );
    System.out.println(  fun( bob ) );		//false
    System.out.println();

    int[] ted = {1,8,13,41,64,76};
    System.out.println( Arrays.toString( ted ) );
    System.out.println(  fun( ted ) );		//true
    System.out.println();

    int[] sue = {-11117,21,36,42,50989,60,79};
    System.out.println( Arrays.toString( sue ) );
    System.out.println(  fun( sue ) );		//false
    System.out.println();

    int[] ann = {-11117,21,36,42,509898};
    System.out.println( Arrays.toString( ann ) );
    System.out.println(  fun( ann ) );		//true
  }
}
