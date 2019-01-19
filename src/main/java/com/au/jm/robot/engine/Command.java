package com.au.jm.robot.engine;

import java.util.stream.Stream;

public enum Command {
  PLACE(2),
  MOVE(1),
  LEFT(1),
  RIGHT(1),
  REPORT(1),
  EXIT(1),
  INVALID(1);

  int args;

  Command(int args) {
    this.args = args;
  }

  public static Command lookUp(String[] commandArgs) {
    return Stream.of(Command.values())
      .filter(command -> command.name().equalsIgnoreCase(commandArgs[0]) && command.args == commandArgs.length)
      .findAny()
      .orElse(Command.INVALID);
  }
}
