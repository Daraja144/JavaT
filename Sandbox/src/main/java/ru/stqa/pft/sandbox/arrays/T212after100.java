package ru.stqa.pft.sandbox.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T212after100 {
  //method fun will return true if nums contains a 212 followed by a 100
  //method fun will return false if there is NOT a 212 followed by a 100
  // try creating more boolean variables...

  public static boolean fun( int[] nums ) {

    int count212 = 0;
    int count100 = 0;
    int indexOf212 = 0;
    int indexOf100 = 0;

    List<Integer> listOfAll = new ArrayList<Integer>();

    for (int i = 0; i <nums.length; i++) {
      listOfAll.add(nums[i]);
    }
    System.out.println(listOfAll);
    for (Integer i : listOfAll) {
      if (i == 212) {
        count212++;
      indexOf212 = listOfAll.indexOf(i);
    }
      if (i == 100) {
        count100++;
        indexOf100 = listOfAll.indexOf(i);
      }
    }
    System.out.println(count212 + ", " + count100);
    return count100 >= count212 && indexOf212 < indexOf100;
  }

  public static void main(String[] args)
  {
    //client code
    int[] bob = {-10,212,31,4,5,16,7,100};
    System.out.println( Arrays.toString( bob ) );
    System.out.println(  fun( bob ) );		//true
    System.out.println();

    int[] bob1 = {-10,212,31,4,5,16,7,100,212,333};
    System.out.println( Arrays.toString( bob ) );
    System.out.println(  fun( bob1 ) );		//true
    System.out.println();

    int[] ted = {100,212,8,13,41,64,76};
    System.out.println( Arrays.toString( ted ) );
    System.out.println(  fun( ted ) );		//false
    System.out.println();

    int[] sue = {-11117,212,36,42,50989,60, 100,79, 212, 212};
    System.out.println( Arrays.toString( sue ) );
    System.out.println(  fun( sue ) );		//false
    System.out.println();

    int[] ann = {212,-11117,21,36,42,509898,100};
    System.out.println( Arrays.toString( ann ) );
    System.out.println(  fun( ann ) );		//true
    System.out.println();

    int[] sam = {212};
    System.out.println( Arrays.toString( sam ) );
    System.out.println(  fun( sam ) );		//false
  }
}
