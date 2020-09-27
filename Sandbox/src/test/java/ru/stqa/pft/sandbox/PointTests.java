package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.stuff.Point;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(2, 4);
    Point p2 = new Point (6, 8);

    Assert.assertEquals(p1.distance(p2), 5.656854249492381);

  }
}
