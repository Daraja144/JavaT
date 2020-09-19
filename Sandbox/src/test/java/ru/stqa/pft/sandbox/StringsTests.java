package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringsTests {

  /* Make a string out of text by enclosing it in double quotes "like this",
  and use + to combine strings to make bigger strings. For this example,
  the withNo() method takes in a string and returns a new string with "No:" added at the front. */

  public String withNo(String str) {
    return str + " No";
  }

  @Test
  public void testWithNo() {
    String s = "mama mia";
    String newS = withNo(s);
    System.out.println(newS);
  }

    /* With a string, str.substring(i, j) returns the String that starts at index i and goes up to but not including j.
    The first char in the String is at index 0, so str.substring(0, 2) returns a string of the first two chars.
    The method str.length() returns the length of a string. Compare two strings like this: str1.equals(str2).
    Do not compare two strings with == which looks reasonable but does not work correctly in all cases.
    This twoE() example method returns true if the string contains exactly two 'e' chars. The code:
    "for (int i=0; i<str.length(); i++) { ..." is very standard code to look at each position in a String.
    The "char" type in Java represents a single character and is written in single quotes like this: 'e'.
    Here's a version of the twoE() method which uses str.charAt(i) to access each char of a string.
    Use == to compare chars.*/

  public boolean twoE(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      String sub = str.substring(i, i + 1);
      if (sub.equals("e")) count ++;
    }
    return count == 2;
  }

  @Test
  public void testNotTwoE() {
    String v = "venegret";
    boolean isTwo = twoE(v);
    Assert.assertFalse(isTwo);
  }
  @Test
  public void testTwoE() {
    String v = "venegar";
    boolean isTwo = twoE(v);
    Assert.assertTrue(isTwo);
  }

  public boolean CharTwoE(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'e') count ++;
    }
    return count == 2;
  }
  @Test
  public void testCharTwoE() {
    String v = "venegar";
    boolean isTwo = CharTwoE(v);
    Assert.assertTrue(isTwo);
  }

  int findSmallest(int[] values) {
    int minIndex = 0;  // start with 0th element as min
    for (int i=0; i<values.length; i++) {
      if (values[i] < values[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }
  @Test
  public void testFindSmallest() {
    int[] array = new int[] {-1, -3, -2, 0};
    int smallest = findSmallest(array);
    System.out.println(smallest);
  }

  public int findElement(int[] num, int target) {
    for (int i = 0; i < num.length; i++){
      if (num[i] == target) {
        return i;
      }
    }
    return -1;
  }
  @Test
  public void testFindElement() {
    int[] array = new int[] {-1, -3, -2, 0};
    int i = findElement(array, -2);
    System.out.println(i);
  }



}
