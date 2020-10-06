package ru.stqa.pft.sandbox.strings;

public class Chicken1 {
  /*	fun will take a word and remove all the letters
   *	in the word that are in the letters array.
   *	then return the new word.
   */

  public static String fun(String word, String[] letters) {
    return removeChar(word);
    }


  public static String removeChar(String src){
    char[] srcArr = src.toCharArray();
    String sb = "";
    for (int i = 0; i < srcArr.length; i++) {
      char foundChar = isFound(srcArr[i]);
      if(foundChar!='\0')
        sb+=foundChar;
    }
    return sb;
  }

  public static char isFound(char src){
    char[] letters = {'a','e','i','o','u'};
    for (int i = 0; i < letters.length; i++) {
      if(src==letters[i]){
        return '\0';
      }
    }
    return src;
  }

  public static void main(String[] args)
  {

    String[] vowels = {"a","e","i","o","u"};

    System.out.println(fun("chicken", vowels));  //outs chckn

    String[] words = ("alligator baboon camel elephant fish gorilla hippo iguana jackal kangaroo " +
            "lion monkey newt octopus pig quail rooster snail turtle urial viper walrus xenops yak zebu").split(" ");
    for(String word: words)
      System.out.println(word + " >> " + fun(word, vowels));
  }
}
