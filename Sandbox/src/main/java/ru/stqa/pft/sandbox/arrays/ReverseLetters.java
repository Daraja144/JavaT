package ru.stqa.pft.sandbox.arrays;

import java.util.Arrays;

public class ReverseLetters {

    /*	reverseLetters will take a word and reverse the letters
     *	in the word then return the new word, unless the word begins
     *	or ends with a vowel, then it will return the old word.
     */

    public static String reverseLetters(String word) {
      String reverse = "";
      for (int i = word.length() - 1; i >= 0; i--) {
        if (isVowel(word.charAt(0)) || isVowel(word.charAt(word.length()-1))) {
          return word;
        } else {
          reverse = reverse + word.charAt(i);
        }
      }
      return reverse;
    }

  static boolean isVowel(char ch) {
    return (ch == 'a' || ch == 'e' ||
            ch == 'i' || ch == 'o' ||
            ch == 'u');
  }



  /* fun will take an array of Strings and reverse all the letters
     * in the word. Unless the word begins or ends with a vowel.
     *
     *	MUST call reverseLetters(String)
     */

    public static void fun(String[] starry) {

      for (int x = 0; x < starry.length; x++)
        starry[x] = reverseLetters(starry[x]);
    }


    public static void main(String[] args) {
      String[] words = "alligator baboon elephant gorilla hippo iguana jackal yak zebu".split(" ");
      System.out.println(Arrays.toString(words));
      fun(words);
      System.out.println(Arrays.toString(words));

      String[] words2 = "chevy ford mazda bmw alfa mercedes dodge".split(" ");
      System.out.println(Arrays.toString(words2));
      fun(words2);
      System.out.println(Arrays.toString(words2));
    }
  }

