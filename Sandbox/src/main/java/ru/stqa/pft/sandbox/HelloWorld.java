package ru.stqa.pft.sandbox;

public class HelloWorld {

  public static void main(String[] args) {

      hello("world");
      hello("Daria");
      hello("Pavel");
      hello("Vita");
      hello("Vania");

      double len = 5;
      double a = 7;
      double b = 9;
    System.out.println("Площадь со стороной квадрата " + len + " = " + area(len));
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));
    }
    public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");

  }

  public static double area(double f) {
    return f * f;
  }

  public static double area(double a, double b) {
    return a * b;
  }

}