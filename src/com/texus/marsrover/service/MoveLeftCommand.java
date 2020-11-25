package com.texus.marsrover.service;

public class MoveLeftCommand implements RoverCommand {
	private Rover rover;

	public MoveLeftCommand(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.moveLeft();

	}

}
