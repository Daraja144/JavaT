package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;
  public double dis;

  public Point(double x, double y) {

    this.x = x;
    this.y = y;
  }

  public double distance(Point b){

    double dx = this.x - b.x;
    double dy = this.y - b.y;
    dis = Math.sqrt(dx*dx + dy*dy);
    return dis;
  }

}
