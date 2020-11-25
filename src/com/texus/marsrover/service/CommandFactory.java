package com.texus.marsrover.service;

public class CommandFactory {
	public static RoverCommand getCommand(char c, Rover r) {
		switch (c) {
		case 'L': {
			return new MoveLeftCommand(r);

		}
		case 'R': {
			return new MoveRightCommand(r);
		}
		case 'M': {

			return new MoveUpCommand(r);
		}
		default:
			throw new IllegalArgumentException("Invalid Rover Command" + c);
		}
	}
}
