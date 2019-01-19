package com.au.jm.robot.engine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the square board
 */
public class SquareBoardTest {

  private Board squareBoard;

  private static final int ROWS = 5;

  private static final int COLUMNS = 5;

  @Before
  public void setUp() {
    squareBoard = new SquareBoard(ROWS, COLUMNS);
  }

  @Test
  public void testIsValidLocation() {
    // Valid location
    Location location = new Location(2, 2, Direction.EAST);
    Assert.assertTrue(squareBoard.isValidLocation(location));

    // Valid location
    location = new Location(4, 4, Direction.EAST);
    Assert.assertTrue(squareBoard.isValidLocation(location));

    // Valid location
    location = new Location(0, 0, Direction.EAST);
    Assert.assertTrue(squareBoard.isValidLocation(location));

    // Valid location
    location = new Location(4, 1, Direction.EAST);
    Assert.assertTrue(squareBoard.isValidLocation(location));

    // Invalid location
    location = new Location(2, 5, Direction.EAST);
    Assert.assertFalse(squareBoard.isValidLocation(location));

    // Invalid location
    location = new Location(5,2, Direction.NORTH);
    Assert.assertFalse(squareBoard.isValidLocation(location));

    // Invalid location
    location = new Location(-1,-1, Direction.NORTH);
    Assert.assertFalse(squareBoard.isValidLocation(location));

    // Invalid location
    location = new Location(5,5, Direction.NORTH);
    Assert.assertFalse(squareBoard.isValidLocation(location));
  }
}
