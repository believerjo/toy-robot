package com.au.jm.robot.engine;

/**
 * The SquareBoard class
 */
public class SquareBoard implements Board {

  private int rows;
  private int columns;

  public SquareBoard(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
  }

  @Override
  public boolean isValidLocation(Location location) {
    return location != null && location.x >= 0 && location.x < rows && location.y >= 0 && location.y < columns;
  }
}
