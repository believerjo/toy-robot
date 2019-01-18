package com.au.jm.robot.engine;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for directions
 */

public class DirectionTest {

  @Test
  public void testLeft() {
    Assert.assertEquals(Direction.WEST, Direction.leftOf(Direction.NORTH));
    Assert.assertEquals(Direction.NORTH, Direction.leftOf(Direction.EAST));
    Assert.assertEquals(Direction.EAST, Direction.leftOf(Direction.SOUTH));
    Assert.assertEquals(Direction.SOUTH, Direction.leftOf(Direction.WEST));
  }

  @Test
  public void testRight() {
    Assert.assertEquals(Direction.EAST, Direction.rightOf(Direction.NORTH));
    Assert.assertEquals(Direction.SOUTH, Direction.rightOf(Direction.EAST));
    Assert.assertEquals(Direction.WEST, Direction.rightOf(Direction.SOUTH));
    Assert.assertEquals(Direction.NORTH, Direction.rightOf(Direction.WEST));
  }
}
