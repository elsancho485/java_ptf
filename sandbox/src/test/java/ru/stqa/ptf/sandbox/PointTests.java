package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPoint() {

    Point p = new Point(16,20,24,14);
    Assert.assertEquals(p.distance(),  10 );

  }
}
