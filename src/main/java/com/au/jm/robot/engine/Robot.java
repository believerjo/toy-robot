package com.au.jm.robot.engine;

import com.au.jm.robot.engine.enums.Direction;

public class Robot {

  private Location location;

  protected static final String REPORT_TEXT = "Toy Robot is currently at (X, Y, ORIENTATION) : ";

  /**
   * Place the robot in a valid position
   *
   * @param location location of the robot on the board
   */
  public void place(Location location) {
    this.location = location;
  }

  /**
   * Move the robot one step in its current direction
   */
  public void move() {
    switch (location.direction) {
      case NORTH:
        location.x++;
        break;
      case EAST:
        location.y++;
        break;
      case SOUTH:
        location.x--;
        break;
      case WEST:
        location.y--;
        break;
    }
  }

  /**
   * Shift the orientation of robot to the left
   */
  public void left() {
    location.direction = Direction.leftOf(location.direction);
  }

  /**
   * Shift the orientation of robot to the right
   */
  public void right() {
    location.direction = Direction.rightOf(location.direction);
  }

  /**
   * Report the current position of the robot
   *
   * @return report text
   */
  public String report() {
    return toString();
  }

  @Override
  public String toString() {
    return new StringBuilder(REPORT_TEXT).append(location.x).append(", ").append(location.y).append(", ").append(location.direction.name()).toString();
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
