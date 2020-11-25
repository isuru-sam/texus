package com.texus.marsrover.service;

public class MoveRightCommand implements RoverCommand {

	private Rover rover;

	public MoveRightCommand(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.moveRight();
	}
}
