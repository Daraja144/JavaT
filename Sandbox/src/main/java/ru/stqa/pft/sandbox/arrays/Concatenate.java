package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class Concatenate {
  /*concatenate means to combine Strings,
   * write a method that will concatenate two strings
   * and will return the concatenated string.
   */
  public static String[] fun(String[] words){
    String newWord[] = new String[words.length-1];
    String concatenated = "";
    for (int i = 0; i + 1 < words.length; i++ ) {
      concatenated = words[i] + words[i+1];
      System.out.println(concatenated);
      newWord[i] = concatenated;
    }
    return newWord;
  }

  /* 	wordinacci will take an array of strings and combine two consecutive strings
   * 	and put them in a new array, until there are not two consecutive strings.
   *
   *	must call your method that you created
   */

  public static void main(String[] args) {
    String[] x = "abcd efg hijk lmnop qrs tuv wx yz".split(" ");
    System.out.println(Arrays.toString(x));
    System.out.println(Arrays.toString(fun(x))); // [abcdefg, efghijk, hijklmnop, lmnopqrs, qrstuv, tuvwx, wxyz]
    System.out.println();

    String[] y = "mammals amphibians reptiles birds fish arthropods".split(" ");
    System.out.println(Arrays.toString(y));
    System.out.println(Arrays.toString(fun(y))); // [mammalsamphibians,amphibiansreptiles,reptilesbird,birdsfish,fisharthropods]
    System.out.println();

    String[] z = "cat dog dog cat dog cat cat dog".split(" ");
    System.out.println(Arrays.toString(z));
    System.out.println(Arrays.toString(fun(z))); // [catdog,dogdog,dogcat,catdog,dogcat,catcat,catdog]

  }
}
