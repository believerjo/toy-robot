package com.au.jm.robot.engine;

import java.util.stream.Stream;

/**
 * The Direction enum.
 */
public enum Direction {
  NORTH(0, 3, 1),
  EAST(1, 0, 2),
  SOUTH(2, 1, 3),
  WEST(3, 2, 0);

  // Id
  int id;
  // Id of direction to the left of current
  int left;
  // Id of direction to the right of current
  int right;

  Direction(int id, int left, int right) {
    this.id = id;
    this.left = left;
    this.right = right;
  }

  /**
   * Lookup Direction by Id
   * @param id id
   * @return Direction if match, else null
   */
  public static Direction lookUpById(int id) {
    return Stream.of(Direction.values()).filter(direction -> direction.id == id).findFirst().orElse(null);
  }

  /**
   * Lookup Direction by Id
   * @param name name
   * @return Direction if match, else null
   */
  public static Direction lookUpByName(String name) {
    return Stream.of(Direction.values()).filter(direction -> direction.name().equalsIgnoreCase(name)).findFirst().orElse(null);
  }

  /**
   * Get the left
   * @param input input
   * @return Direction
   */
  public static Direction leftOf(Direction input) {
    return lookUpById(input.left);
  }

  /**
   * Get the right
   * @param input input
   * @return Direction
   */
  public static Direction rightOf(Direction input) {
    return lookUpById(input.right);
  }
}
