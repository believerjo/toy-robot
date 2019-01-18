package com.au.jm.robot;

import com.au.jm.robot.engine.Controller;
import com.au.jm.robot.engine.Robot;
import com.au.jm.robot.engine.SquareBoard;
import com.au.jm.robot.engine.exception.ToyRobotAppException;
import com.au.jm.robot.engine.utils.Constants;

import java.io.Console;

/**
 * App is the bootstrap class for toy robot interface
 */
public class App {
  static Console console;

  public static void main(String[] args) {
    console = System.console();
    if (console == null) {
      System.out.println("No Console");
      System.exit(1);
    }

    System.out.println("Toy Robot Simulator");
    System.out.println("Please enter a command ( PLACE X,Y,[NORTH|EAST|SOUTH|WEST] | MOVE | LEFT | RIGHT | REPORT | EXIT )");

    Robot robot = new Robot();
    SquareBoard squareBoard = new SquareBoard(5, 5);
    Controller controller = new Controller(squareBoard, robot);

    boolean acceptingCommands = true;
    while (acceptingCommands) {
      String consoleString = console.readLine(Constants.SINGLE_COLON);
      try {
        acceptingCommands = controller.run(consoleString);
      } catch (ToyRobotAppException e) {
        System.out.println("Error..." + e.getMessage());
      }
    }
  }
}
