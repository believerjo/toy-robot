package com.au.jm.robot.engine;

import com.au.jm.robot.engine.exception.ToyRobotAppException;
import com.au.jm.robot.engine.utils.Constants;

public class Controller {

  private Board board;
  private Robot robot;

  private static final String INVALID_COMMAND = "That was an invalid command. Enter a valid command";
  private static final String EXIT_MESSAGE = "Exiting... See you later";

  public Controller(Board board, Robot robot) {
    this.board = board;
    this.robot = robot;
  }

  /**
   * Process the commands
   *
   * @param commandLine cli commands issued by the user
   * @return true to exit
   * @throws ToyRobotAppException on any error/invalid command
   */
  public boolean run(String commandLine) throws ToyRobotAppException {

    String[] commandArgs = commandLine.split(Constants.SINGLE_SPACE);
    Command command = Command.lookUp(commandArgs);

    switch (command) {
      case EXIT:
        System.out.println(EXIT_MESSAGE);
        return false;

      case INVALID:
        throw new ToyRobotAppException(INVALID_COMMAND);

      case PLACE:
        Location location = getLocation(commandArgs[1].split(Constants.COMMA));
        // PLACE only if location is a valid location on board, else ignore command
        if (board.isValidLocation(location)) {
          robot.place(location);
        }
        break;

      case MOVE:
        Location currentLocation = robot.getLocation() == null ? null : new Location(robot.getLocation());
        robot.move();
        // If the new location is invalid, place the robot back to current position
        if (!board.isValidLocation(robot.getLocation())) {
          robot.place(currentLocation);
        }
        break;

      case LEFT:
        robot.left();
        break;

      case RIGHT:
        robot.right();
        break;

      case REPORT:
        if (robot.getLocation() != null) {
          System.out.println(robot.report());
        }
        break;
    }
    return true;
  }

  /**
   * Get the location from cli params
   *
   * @param args cli params for PLACE command
   * @return location on the board
   * @throws ToyRobotAppException on invalid location syntax
   */
  private Location getLocation(final String[] args) throws ToyRobotAppException {
    Location location;
    try {
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      Direction direction = Direction.lookUpByName(args[2]);

      location = new Location(x, y, direction);

    } catch (Exception e) {
      throw new ToyRobotAppException(INVALID_COMMAND);
    }
    return location;
  }

  public Robot getRobot() {
    return robot;
  }
}
