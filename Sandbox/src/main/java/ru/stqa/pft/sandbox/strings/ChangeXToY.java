package ru.stqa.pft.sandbox.strings;

public class ChangeXToY {
  // return a string where every String x is changed to String y in String s.

  public static String changeXToY(String s, String x, String y) {
    String ret = "";
    for (int i=0; i<=s.length()-1; i++) {
      String subS = s.substring(i, i + 1);
      if (! subS.equals(x)) ret = ret + subS;
      if (subS.equals(x)) ret = ret + y;
    }
    return ret;
  }

  public static void main(String[] args)
  {
    System.out.println( changeXToY("dogcatpig", "a", "*") );  //outs  dogc*tpig
    System.out.println( changeXToY("dogcatpig", "g", "-") );  //outs  do-catpi-
    System.out.println( changeXToY("dogcatpig", "d", "7") );  //outs  7ogcatpig
    System.out.println( changeXToY("dogcatpig", "o", "?") );  //outs  d?gcatpig

    //add more cases to make sure your code works
  }
}
