package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class CountO {
  //method fun will return the count of all the numbers with a 0 digit
  //you MUST call contains0
  public static int fun( int[] ann ) {
    int count=0;
    for (int i=0; i<ann.length; i++) {
      if (contains0(ann[i])) count++;
    }
    return count;
  }

  //use a while loop and % 10 and / 10
  public static boolean contains0( int num ) {
    {
     if (num ==0) return true;
      while (num != 0)
      {
        if (num % 10 == 0)
          return true;
        num /= 10;
      }
      return false;
    }
  }


  public static void main(String[] args)
  {
    //client code
    int[] bob = {-102,212,31,4,5,16,7,10101,212,212,212,10123};
    System.out.println( Arrays.toString( bob ) );
    System.out.println(  fun( bob ) );		//3
    System.out.println();

    int[] ted = {212,81982,13,41,64,76,12234566};
    System.out.println( Arrays.toString( ted ) );
    System.out.println(  fun( ted ) );		//0
    System.out.println();

    int[] sue = {20102,212,36,911034,42,1011111};
    System.out.println( Arrays.toString( sue ) );
    System.out.println(  fun( sue ) );		//3
    System.out.println();

    int[] ann = {-192,1,2,3,4,5,6,7,8,9999999};
    System.out.println( Arrays.toString( ann ) );
    System.out.println(  fun( ann ) );		//0
    System.out.println();

    int[] sam = {0,110,1011,10101010};
    System.out.println( Arrays.toString( sam ) );
    System.out.println(  fun( sam ) );		//4
  }
}
