package com.au.jm.robot.engine;

/**
 * Defines the position of the robot on the board
 */
public class Location {
  int x;
  int y;
  Direction direction;

  public Location(Location location) {
    if (location != null) {
      this.x = location.x;
      this.y = location.y;
      this.direction = location.direction;
    }
  }

  public Location(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Direction getDirection() {
    return direction;
  }
}
