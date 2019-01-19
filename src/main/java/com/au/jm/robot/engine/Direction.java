package com.au.jm.robot.engine;

import java.util.stream.Stream;

public enum Direction {
  NORTH(0, 3, 1),
  EAST(1, 0, 2),
  SOUTH(2, 1, 3),
  WEST(3, 2, 0);

  int id;
  int left;
  int right;

  Direction(int id, int left, int right) {
    this.id = id;
    this.left = left;
    this.right = right;
  }

  public static Direction lookUpById(int id) {
    return Stream.of(Direction.values()).filter(direction -> direction.id == id).findFirst().orElse(null);
  }

  public static Direction lookUpByName(String name) {
    return Stream.of(Direction.values()).filter(direction -> direction.name().equalsIgnoreCase(name)).findFirst().orElse(null);
  }

  public static Direction leftOf(Direction input) {
    return lookUpById(input.left);
  }

  public static Direction rightOf(Direction input) {
    return lookUpById(input.right);
  }
}
