package ru.stqa.pft.sandbox;

public class HelloWorld {

  public static void main(String[] args) {

      hello("world");
      hello("Daria");
      hello("Pavel");
      hello("Vita");
      hello("Vania");



      Square s = new Square(5);

    System.out.println("Площадь со стороной квадрата " + s.l + " = " + s.area());

      Rectangle r = new Rectangle(7,9);

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p = new Point(2, 4, 6, 8);

    System.out.println("Расстояние между точками p1 и p2 = " + p.distance());
    }
    public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");

  }


}