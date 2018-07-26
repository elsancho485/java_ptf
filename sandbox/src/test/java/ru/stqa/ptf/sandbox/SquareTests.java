package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 25 );
  }
}
