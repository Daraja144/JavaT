package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringsTests {

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

  public String doubleChar(String str) {
    String res = "";
    for(int i=0;i<str.length();i++){
      res = res + str.charAt(i) + str.charAt(i);
    }
    return res;
  }
  @Test
  public void testDoubleChar() {
    String str = "moloko";
    String checkIfDouble = doubleChar(str);
    System.out.println(checkIfDouble);
  }










  public int countCode(String str) {
    int count = 0;
    for (int i = 0; i <= str.length()-4; i++) {
      String sub = str.substring(i,i+4);
      if (sub.matches("co\\we")) count++;
    }
    return count;
  }
  @Test
  public void testCountCode() {
    String str = "acoleaabbb";
    System.out.println(countCode(str));
  }


  public boolean endOther(String a, String b)
  {
    int aLen = a.length();
    int bLen = b.length();
    String end;
    String temp;
    a = a.toLowerCase();
    b = b.toLowerCase();
    if(aLen >= bLen)
    {
      end = a.substring(aLen - bLen);
      temp = b;
    }
    else
    {
      end = b.substring(bLen - aLen);
      temp = a;
    }
    return (end.equals(temp));
  }

  @Test
  public void testEndOther() {
    String a = "coFFeeShop";
    String b = "Shop";
    System.out.println(endOther(a,b));
    //Assert.assertTrue(endOther(a,b));
  }


  public String oneTwo(String str) {
    String result = "";
    for(int i=0; i <str.length()-2; i += 3)
    {
      result = result + str.substring(i+1,i+3) + str.charAt(i);
    }
    return result;
  }
  @Test
  public void testOneTwo() {
    String str = "tcagdou";
    String check = oneTwo(str);
    System.out.println(check);
  }














  public boolean no13(int[] nums)
  {
    for(int i = 0; i < nums.length; i++)
    {
      if(nums[i] == 1 || nums[i] == 3)
        return false;
    }
    return true;
  }
  @Test
  public void testNo13() {
    int[] array = new int[] {0, 4, 7};
    boolean checkIfNo13 = no13(array);
    System.out.println(checkIfNo13);
  }

  public boolean has22or44(int[] nums) {
    for(int i = 0; i < nums.length-1; i++) {
      if(nums[i] == 2 && nums[i+1] == 2 || nums[i] == 4 && nums[i+1] == 4)
        return true;
    }
    return false;
  }
  @Test
  public void testHas22or44() {
    int[] array = new int[] {0, 4, 4, 7};
    boolean hasOrNot = has22or44(array);
    System.out.println(hasOrNot);
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





































  public String oneTwo1(String str) {
    if(str.length()<3)
      return "";
    String three="";
    String two="";
    String one="";
    String neww="";
    int end=str.length()/3;
    //String word=str.substring(str.length()%3,str.length());

    for(int i=0; i<=end; i+=3){
      three=str.substring(i,i+3);
      two=three.substring(i+1,3);
      one=three.substring(i,1);
      neww=neww+two+one;
    }
    return neww;
  }
  @Test
  public void testOneTwo1() {
    String str = "tcagdo";
    String check = oneTwo1(str);
    System.out.println(check);
  }

}
