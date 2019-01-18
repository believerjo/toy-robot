package com.au.jm.robot.engine;

import com.au.jm.robot.engine.enums.Direction;
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
    Assert.assertEquals(robot.getLocation().getX(), 3);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.NORTH);

    robot.place(new Location(2, 3, Direction.WEST));
    robot.move();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.WEST);

    robot.place(new Location(4, 2, Direction.SOUTH));
    robot.move();
    Assert.assertEquals(robot.getLocation().getX(), 3);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.SOUTH);

    robot.place(new Location(2, 3, Direction.EAST));
    robot.move();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 4);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.EAST);
  }

  @Test
  public void testLeft() {
    robot.left();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.WEST);

    robot.left();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.SOUTH);

    robot.left();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.EAST);

    robot.left();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.NORTH);

  }

  @Test
  public void testRight() {
    robot.right();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.EAST);

    robot.right();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.SOUTH);

    robot.right();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.WEST);

    robot.right();
    Assert.assertEquals(robot.getLocation().getX(), 2);
    Assert.assertEquals(robot.getLocation().getY(), 2);
    Assert.assertEquals(robot.getLocation().getDirection(), Direction.NORTH);
  }

  @Test
  public void testReport() {
    String expected = Robot.REPORT_TEXT.concat("2, 2, NORTH");
    Assert.assertEquals(robot.report(), expected);
  }
}
