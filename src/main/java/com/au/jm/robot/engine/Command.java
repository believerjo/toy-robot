package com.au.jm.robot.engine;

import java.util.stream.Stream;

/**
 * The Commands
 */
public enum Command {
  PLACE(2),
  MOVE(1),
  LEFT(1),
  RIGHT(1),
  REPORT(1),
  EXIT(1),
  INVALID(1);

  // Number of args that is required to validate a command
  // Eg: PLACE 0,1,NORTH - arg1 = "PLACE", arg2 = "0,1,NORTH"
  int args;

  Command(int args) {
    this.args = args;
  }

  /**
   * Validate and look up a command
   * @param commandArgs command sent by the user
   * @return Command
   */
  public static Command lookUp(String[] commandArgs) {
    return Stream.of(Command.values())
      .filter(command -> command.name().equalsIgnoreCase(commandArgs[0]) && command.args == commandArgs.length)
      .findAny()
      .orElse(Command.INVALID);
  }
}
