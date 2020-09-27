package ru.stqa.pft.sandbox.strings;

import java.util.ArrayList;
import java.util.List;

public class Fun {
  //find the first uppercase letter
  //return all letters after that letter
  //return "212" if there are no uppercase letters
  //return "212" if there are no letters after the first Uppercase letter
  public static String fun(String s) {
    String result = "";
    String result212 = "212";
    List<Integer> uppers = new ArrayList<Integer>();
    for (int i = 0; i < s.length()-1; i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        uppers.add(i);
        result = s.substring(uppers.get(0) + 1);
      } else if (uppers.isEmpty()) {
        result = result212;
      }
    }
    return result;
  }

  public static void main(String[] args)
  {
    String[] cases = {"dogcaTpig","doGcatpig","dOgcaTpig","DogCaTpig","dogCATpig","dogcatpig","dogcatpiG","dogcatpIG"};
    for(String x : cases)
      System.out.println(fun(x));
  }
}

/*OUTS

pig
catpig
gcaTpig
ogCaTpig
ATpig
212
212
G

*/

