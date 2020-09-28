package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class Fun {
  public static int fun( double[] ann, double lookFor) {
    for (int i = 0; i < ann.length; i++) {
      if (ann[i]==lookFor) return i;
    }
    //write the code to search ann for lookFor
    //return -1 if lookFor does not exist in ann
    //Use a for loop, since you need to keep track of the positions.

    return -1;
  }


  public static void main(String[] args)
  {
    //client code
    double[] bob = {3.3, 4.5, 3.7, 9.3, 10.5, 1.7, 2.3, 4.5, 6.7 };

    System.out.println( Arrays.toString( bob) );

    System.out.println( "3.3 found at :: " + fun( bob,  3.3 ) );
    System.out.println( "4.5 found at :: " + fun( bob, 4.5 ) );
    System.out.println( "7.1 found at :: " + fun( bob, 7.1 ) );
  }
  
}
