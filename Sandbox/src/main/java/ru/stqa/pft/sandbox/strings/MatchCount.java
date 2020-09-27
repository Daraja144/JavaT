package ru.stqa.pft.sandbox.strings;

public class MatchCount {
  //count each character string s and t
  //that are in the same position
  //return the count
  public static int match(String s, String t) {
    int count = 0;
    if (s.length() <= t.length()) {
      for (int i = 0; i <= s.length() - 1; i++) {
        String subS = s.substring(i, i + 1);
        String subT = t.substring(i, i + 1);
        if (subS.equals(subT)) count++;
      }
    } else {
      for (int i = 0; i <= t.length() - 1; i++) {
        String subS = s.substring(i, i + 1);
        String subT = t.substring(i, i + 1);
        if (subT.equals(subS)) count++;
      }
    }
    return count;
  }

  public static void main(String[] args)
  {
    System.out.println( match("dogcatpig", "dogcatpig") );  //outs  9
    System.out.println( match("dogcatpig", "dogcatpug") );  //outs  8
    System.out.println( match("dogcatpig", "digcotpug") );  //outs  6
    System.out.println( match("dogcatpig", "dog") );  		//outs  3
    System.out.println( match("dog", "doggies") ); 		 //outs  3
    System.out.println( match("abcde", "zyxwvut")); // outs 0

  }
}
