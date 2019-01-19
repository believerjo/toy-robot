package com.au.jm.robot.engine;

import com.au.jm.robot.engine.utils.Constants;

public class Robot {

  private Location location;

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
    if (location != null) {
      switch (location.direction) {
        case NORTH:
          location.y++;
          break;
        case EAST:
          location.x++;
          break;
        case SOUTH:
          location.y--;
          break;
        case WEST:
          location.x--;
          break;
        default:
      }
    }
  }

  /**
   * Shift the orientation of robot to the left
   */
  public void left() {
    if (location != null) {
      location.direction = Direction.leftOf(location.direction);
    }
  }

  /**
   * Shift the orientation of robot to the right
   */
  public void right() {
    if (location != null) {
      location.direction = Direction.rightOf(location.direction);
    }
  }

  /**
   * Report the current position of the robot
   *
   * @return report text
   */
  public String report() {
    if (location == null) {
      return Constants.EMPTY_STRING;
    }
    return new StringBuffer(Constants.EMPTY_STRING)
            .append(location.x)
            .append(Constants.COMMA)
            .append(location.y)
            .append(Constants.COMMA)
            .append(location.direction.name()).toString();
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
