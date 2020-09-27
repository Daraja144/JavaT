package ru.stqa.pft.sandbox.strings;

public class Missing {
  //make a new string that contains only the
  //letters not shared between s and x
  public static String missing(String s, String x)
  {
    String ret = "";
      for (int i=0; i<=x.length()-1; i++) {
        String subX = x.substring(i,i+1);
        if (! s.contains(subX)) ret = ret + subX;
      }
      for (int n=0; n<=s.length()-1; n++) {
        String subS = s.substring(n,n+1);
        if (! x.contains(subS)) ret = ret + subS;
      }
    return ret;
  }

  public static void main(String[] args)
  {
    System.out.println( missing("dog", "dig") );  //outs  oi
    System.out.println( missing("piggy", "pig") );  //outs  y
    System.out.println( missing("dogcatpig", "d") );  //outs  ogcatpig
    System.out.println( missing("doom", "do") );  //outs  m

    //add more cases to make sure your code works
  }

}
