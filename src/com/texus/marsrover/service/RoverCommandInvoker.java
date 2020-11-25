package com.texus.marsrover.service;

import java.util.ArrayList;
import java.util.List;

public class RoverCommandInvoker {
	private List<RoverCommand> roverCommands = new ArrayList<>();

	public void acceptRoverCommand(RoverCommand roverCommand) {
		roverCommands.add(roverCommand);
	}

	public void executeCommands() {
		roverCommands.forEach(RoverCommand::execute);
	}

}
