package com.au.jm.robot.engine;

import com.au.jm.robot.engine.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the robot
 */
public class RobotTest {

  private Robot robot;

  @Before
  public void makeTheRobot() {
    robot = new Robot();
    robot.place(new Location(2, 2, Direction.NORTH));
  }

  @Test
  public void testPlace() {
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.NORTH, robot.getLocation().getDirection());
  }

  @Test
  public void testMove() {
    robot.move();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(3, robot.getLocation().getY());
    Assert.assertEquals(Direction.NORTH, robot.getLocation().getDirection());

    robot.place(new Location(2, 3, Direction.WEST));
    robot.move();
    Assert.assertEquals(1, robot.getLocation().getX());
    Assert.assertEquals(3, robot.getLocation().getY());
    Assert.assertEquals(Direction.WEST, robot.getLocation().getDirection());

    robot.place(new Location(4, 2, Direction.SOUTH));
    robot.move();
    Assert.assertEquals(4, robot.getLocation().getX());
    Assert.assertEquals(1, robot.getLocation().getY());
    Assert.assertEquals(Direction.SOUTH, robot.getLocation().getDirection());

    robot.place(new Location(2, 3, Direction.EAST));
    robot.move();
    Assert.assertEquals(3, robot.getLocation().getX());
    Assert.assertEquals(3, robot.getLocation().getY());
    Assert.assertEquals(Direction.EAST, robot.getLocation().getDirection());
  }

  @Test
  public void testLeft() {
    robot.left();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.WEST, robot.getLocation().getDirection());

    robot.left();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.SOUTH, robot.getLocation().getDirection());

    robot.left();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.EAST, robot.getLocation().getDirection());

    robot.left();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.NORTH, robot.getLocation().getDirection());

  }

  @Test
  public void testRight() {
    robot.right();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.EAST, robot.getLocation().getDirection());

    robot.right();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.SOUTH, robot.getLocation().getDirection());

    robot.right();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.WEST, robot.getLocation().getDirection());

    robot.right();
    Assert.assertEquals(2, robot.getLocation().getX());
    Assert.assertEquals(2, robot.getLocation().getY());
    Assert.assertEquals(Direction.NORTH, robot.getLocation().getDirection());
  }

  @Test
  public void testReport() {
    String expected = "2,2,NORTH";
    Assert.assertEquals(expected, robot.report());

    // Unplaced robot
    robot.setLocation(null);
    Assert.assertEquals(Constants.EMPTY_STRING, robot.report());
  }
}
