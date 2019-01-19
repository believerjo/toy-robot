package com.au.jm.robot.engine;

import com.au.jm.robot.engine.exception.ToyRobotAppException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test the controller class
 */

public class ControllerTest {

  private Controller controller;

  @Before
  public void setup() {
    controller = new Controller(new SquareBoard(5, 5), new Robot());
  }

  @Test
  public void testRunExit() throws ToyRobotAppException {
    // Test exit - robot is not placed on the board
    controller.run("exit");
    Assert.assertNull(controller.getRobot().getLocation());
  }

  @Test(expected = ToyRobotAppException.class)
  public void testRunInvalid() throws ToyRobotAppException {
    controller.run("invalid");
  }

  @Test
  public void testRunPlace() throws ToyRobotAppException {
    // Valid placement
    controller.run("PLACE 2,2,NORTH");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(2, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.NORTH, controller.getRobot().getLocation().getDirection());
  }

  @Test
  public void testRunReport() throws ToyRobotAppException {
    controller.run("REPORT");

    controller.run("PLACE 2,2,NORTH");
    controller.run("REPORT");
  }

  @Test
  public void testRunMove() throws ToyRobotAppException {
    // MOVE - Before PLACE, ignore
    controller.run("MOVE");
    Assert.assertNull(controller.getRobot().getLocation());

    // MOVE - After PLACE to new postion
    controller.run("PLACE 2,2,NORTH");
    controller.run("MOVE");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(3, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.NORTH, controller.getRobot().getLocation().getDirection());

    // MOVE - After PLACE to an boundary postion - ignore command
    controller.run("PLACE 2,4,NORTH");
    controller.run("MOVE");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(4, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.NORTH, controller.getRobot().getLocation().getDirection());
  }

  @Test
  public void testLeft() throws ToyRobotAppException {
    // LEFT - Before PLACE, ignore
    controller.run("LEFT");
    Assert.assertNull(controller.getRobot().getLocation());

    // LEFT - After PLACE to new postion
    controller.run("PLACE 2,2,NORTH");
    controller.run("LEFT");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(2, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.WEST, controller.getRobot().getLocation().getDirection());
  }

  @Test
  public void testRight() throws ToyRobotAppException {
    // LEFT - Before PLACE, ignore
    controller.run("RIGHT");
    Assert.assertNull(controller.getRobot().getLocation());

    // LEFT - After PLACE to new postion
    controller.run("PLACE 2,2,NORTH");
    controller.run("RIGHT");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(2, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.EAST, controller.getRobot().getLocation().getDirection());
  }

  @Test(expected = ToyRobotAppException.class)
  public void testInvalidPlacement() throws ToyRobotAppException {
    // Invalid placement - location not valid
    controller.run("PLACE 5,5,EAST");
    Assert.assertNull(controller.getRobot().getLocation());

    // Invalid placement - location not valid
    controller.run("PLACE a,3,EAT");
    Assert.assertNull(controller.getRobot().getLocation());
  }

  @Test
  public void testCombinationPlacement() throws ToyRobotAppException {
    // Valid placement
    controller.run("PLACE 2,2,NORTH");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(2, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.NORTH, controller.getRobot().getLocation().getDirection());

    // Invalid placement - location not valid
    controller.run("PLACE 5,5,EAST");
    Assert.assertEquals(2, controller.getRobot().getLocation().getX());
    Assert.assertEquals(2, controller.getRobot().getLocation().getY());
    Assert.assertEquals(Direction.NORTH, controller.getRobot().getLocation().getDirection());
  }

  @Test
  public void testInputFile() {
    // read test from file
    File file = new File(getClass().getClassLoader().getResource("test-data.dat").getFile());

    Scanner scanner = null;
    try {
      scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        try {
          if (line.startsWith("ASSERT-POS:")) {
            Assert.assertEquals(line.split(":")[1], controller.getRobot().report());
          } else {
            controller.run(line);
          }
        } catch (ToyRobotAppException e) {
          System.out.println(e.getMessage());
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }
  }
}
