package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class DobleCube {

  /*
   *	fun will run through an int array if the number is even
   *	it will square it if it is odd it will cube it.
   *	Post-condition: The given array will not be edited!
   */
  public static int[] fun(int[] stars){
    int newStars[] = new int [stars.length];

    for (int i = 0; i < stars.length; i++) {
      if (stars[i]%2==0) {
        int squareIt = stars[i]*stars[i];
        newStars[i] += squareIt;
        System.out.println(squareIt);
      } else {
        int cubeIt = stars[i]*stars[i]*stars[i];
        newStars[i] += cubeIt;
        System.out.println(cubeIt);
      }
    }
    return newStars;
  }


  public static void main(String[] args) {
    int[] money;
    int[] one = new int[]{0, 1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(one));
    money = fun(one);
    System.out.println(Arrays.toString(money)); // [0,1,4,27,16,125,36]
    System.out.println();

    int[] two = new int[]{0, -1, -2, -3, -4, -5, -6, -7};
    System.out.println(Arrays.toString(two));
    money = fun(two);
    System.out.println(Arrays.toString(money)); // [0,-1,4,-27,16,-125,36,-343]
    System.out.println();

  }
}
