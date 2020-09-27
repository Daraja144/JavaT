package ru.stqa.pft.sandbox.strings;

public class Chicken {
  /*	fun will take a word and remove all the letters
   *	in the word that are in the letters array.
   *	then return the new word.
   */

  public static String fun(String word, String[] letters) {
    String result = "";
    String temp = "";

      for (int i = 0; i < word.length(); i++)
        for (int y= 0; y < letters.length; y++)
        if (word.contains(letters[y]))
          temp += letters[i];

    return temp;
  }

  public static void main(String[] args)
  {

    String[] vowels = {"a","e","i","o","u"};

    System.out.println(fun("chicken", vowels));  //outs chckn

    /*String[] words = ("alligator baboon camel elephant fish gorilla hippo iguana jackal kangaroo " +
            "lion monkey newt octopus pig quail rooster snail turtle urial viper walrus xenops yak zebu").split(" ");
    for(String word: words)
      System.out.println(word + " >> " + fun(word, vowels));*/
  }
}
