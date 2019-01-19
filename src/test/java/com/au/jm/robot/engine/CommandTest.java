package com.au.jm.robot.engine;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the commands
 */
public class CommandTest {

  @Test
  public void testLookUpCommands() {
    // PLACE
    Assert.assertEquals(Command.PLACE, Command.lookUp("PLACE 1,1,NORTH".split(" ")));
    // INVALID
    Assert.assertEquals(Command.INVALID, Command.lookUp("PLCE 1,1".split(" ")));
    // MOVE
    Assert.assertEquals(Command.MOVE, Command.lookUp("MOVE".split(" ")));
    // LEFT
    Assert.assertEquals(Command.LEFT, Command.lookUp("LEFT".split(" ")));
    // RIGHT
    Assert.assertEquals(Command.RIGHT, Command.lookUp("RIGHT".split(" ")));
    // REPORT
    Assert.assertEquals(Command.REPORT, Command.lookUp("REPORT".split(" ")));
    // EXIT
    Assert.assertEquals(Command.EXIT, Command.lookUp("EXIT".split(" ")));
  }
}
