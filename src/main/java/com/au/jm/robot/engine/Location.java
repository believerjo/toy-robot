package com.au.jm.robot.engine;

import com.au.jm.robot.engine.enums.Direction;

/**
 * Defines the position of the robot on the board
 */
public class Location {
  int x;
  int y;
  Direction direction;

  public Location(int x, int y, Direction direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
