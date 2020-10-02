package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class SummOfDigits1 {
  //sumOfDigits will sum all of the digits of a positive integer
  public static int sumOfDigits(int n) {
    int sum = 0;
    while (n != 0)
    {
      sum += n % 10;
      n = n/10;
    }
    return sum;
  }

  /*	fun will take the average of all of the integers in
   *	arty whose sum of digits is a multiple of 3
   *	MUST call sumOfDigits in fun
   */

  public static double fun(int[] arty) {
    int count = 0;
    int multi3 = 0;
    //List<Integer> multi3 = new ArrayList<>();
    for (int i = 0; i < arty.length; i++) {
      if (sumOfDigits(arty[i]) % 3 == 0) {
        count++;
        System.out.println(arty[i]);
        multi3+=arty[i];
      }
    }
    //Double average = multi3.stream().mapToDouble(val -> val).average().orElse(0.0);
    System.out.println(multi3);
    return (double) multi3/count;
  }

  public static void main(String[] args) {
    //client code
    int[] bob = {123,213,3,43,51,6,7};
    System.out.println( Arrays.toString( bob ) );
    System.out.println(sumOfDigits(bob[0])); // 6
    System.out.println( "AVG = " + fun( bob ) ); //79.2
    System.out.println();

    int[] ted = {11,12,13,41,52,64,76};
    System.out.println( Arrays.toString( ted ) );
    System.out.println(sumOfDigits(ted[0])); // 2
    System.out.println( "AVG = " + fun( ted ) ); //12.0
    System.out.println();

    int[] sue = {17,21,36,42,50,60,79};
    System.out.println( Arrays.toString( sue ) );
    System.out.println(sumOfDigits(sue[0])); // 8
    System.out.println( "AVG = " + fun( sue ) ); // 39.75

  }
}
