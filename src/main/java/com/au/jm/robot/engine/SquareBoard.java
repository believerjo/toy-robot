package com.au.jm.robot.engine;

public class SquareBoard implements Board {

  private int rows;
  private int columns;

  public SquareBoard(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
  }

  @Override
  public boolean isValidLocation(Location location) {
    return location.x >= 0 && location.x < 5 && location.y >= 0 && location.y < 5;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getColumns() {
    return columns;
  }

  public void setColumns(int columns) {
    this.columns = columns;
  }
}
