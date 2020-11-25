package com.texus.marsrover.service;

public class MoveUpCommand implements RoverCommand {
	private Rover rover;

	public MoveUpCommand(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void execute() {

		rover.moveUp();
	}

}