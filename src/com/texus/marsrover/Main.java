package com.texus.marsrover;

import java.util.Scanner;

import com.texus.marsrover.model.Direction;
import com.texus.marsrover.model.Position;
import com.texus.marsrover.service.CommandFactory;
import com.texus.marsrover.service.Rover;
import com.texus.marsrover.service.RoverCommand;
import com.texus.marsrover.service.RoverCommandInvoker;
import com.texus.marsrover.service.RoverImpl;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Upper Right Coordinates of Plateau:");
		String upperRightCordinates = in.nextLine().trim();
		System.out.println("Enter Start Position of Rover 1:");
		String startPositionRover1 = in.nextLine().trim();
		System.out.println("Enter Rover 1 Commands:");
		String rover1Commands = in.nextLine().trim();

		System.out.println("Enter Start Position of Rover 2:");
		String startPositionRover2 = in.nextLine().trim();
		System.out.println("Enter Rover 2 Commands:");
		String rover2Commands = in.nextLine().trim();

		String upperRightStr[] = upperRightCordinates.split(" ");
		int upperRightInt[] = { Integer.parseInt(upperRightStr[0]), Integer.parseInt(upperRightStr[1]) };

		String startPostRover1Str[] = startPositionRover1.split(" ");
		Position rover1StartPosition = new Position(Integer.parseInt(startPostRover1Str[0]),
				Integer.parseInt(startPostRover1Str[1]), Direction.valueOf(startPostRover1Str[2]));

		char[] rover1CommandArray = rover1Commands.toCharArray();
		Rover rover1 = new RoverImpl.RoverBuilder().topRightXCoordinate(upperRightInt[0])
				.topRightYCoordinate(upperRightInt[1]).currentPosition(rover1StartPosition).build();

		String startPostRover2Str[] = startPositionRover2.split(" ");
		Position rover2StartPosition = new Position(Integer.parseInt(startPostRover2Str[0]),
				Integer.parseInt(startPostRover2Str[1]), Direction.valueOf(startPostRover2Str[2]));

		char[] rover2CommandArray = rover2Commands.toCharArray();
		Rover rover2 = new RoverImpl.RoverBuilder().topRightXCoordinate(upperRightInt[0])
				.topRightYCoordinate(upperRightInt[1]).currentPosition(rover2StartPosition).build();

		RoverCommandInvoker invoker = new RoverCommandInvoker();

		for (char c : rover1CommandArray) {
			RoverCommand command = CommandFactory.getCommand(c, rover1);
			invoker.acceptRoverCommand(command);
		}

		for (char c : rover2CommandArray) {
			RoverCommand command = CommandFactory.getCommand(c, rover2);
			invoker.acceptRoverCommand(command);
		}

		// execute commands

		invoker.executeCommands();

		rover1.printRoverPosition();
		rover2.printRoverPosition();

	}

}
