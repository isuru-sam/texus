package com.texus.marsrover.service;

import com.texus.marsrover.model.Position;

public class RoverImpl implements Rover {

	private Position currentPosition;
	private int topRightXCoordinate;
	private int topRightYCoordinate;

	private RoverImpl() {

	}

	public static final class RoverBuilder {

		private Position currentPosition;
		private int topRightXCoordinate;
		private int topRightYCoordinate;

		public RoverBuilder() {
		}

		public RoverBuilder currentPosition(Position currentPosition) {
			this.currentPosition = currentPosition;
			return this;
		}

		public RoverBuilder topRightXCoordinate(int topRightXCoordinate) {
			this.topRightXCoordinate = topRightXCoordinate;
			return this;
		}

		public RoverBuilder topRightYCoordinate(int topRightYCoordinate) {
			this.topRightYCoordinate = topRightYCoordinate;
			return this;
		}

		public Rover build() {
			RoverImpl rover = new RoverImpl();
			validateCurrentPosition(currentPosition);
			validateTopRightStart(topRightXCoordinate, topRightYCoordinate);
			rover.currentPosition = currentPosition;
			rover.topRightXCoordinate = topRightXCoordinate;
			rover.topRightYCoordinate = topRightYCoordinate;
			return rover;
		}

		private void validateTopRightStart(int x, int y) {
			if (x < 0 || y < 0) {
				throw new IllegalArgumentException(" top right x  y cordinates should be >=0");
			}
		}

	}

	private static void validateCurrentPosition(Position current) {
		if (current == null) {
			throw new IllegalArgumentException("Current Position should be a not null start position");
		}
		if (current.getX() < 0 || current.getY() < 0) {
			throw new IllegalArgumentException(
					"Invalid start postion moving the rover outside plateau" + current.getX() + ":" + current.getY());

		}

	}

	@Override
	public void moveRight() {

		currentPosition.setDirection(currentPosition.getDirection().moveRight());
	}

	@Override
	public void moveUp() {
		int[] nextcoordinates = currentPosition.getDirection().moveUp(currentPosition);
		validateCoordinatesAfterMoveUp(nextcoordinates[0], nextcoordinates[1], currentPosition);
		currentPosition.setX(nextcoordinates[0]);
		currentPosition.setY(nextcoordinates[1]);
	}

	@Override
	public void moveLeft() {
		currentPosition.setDirection(currentPosition.getDirection().moveLeft());

	}

	private void validateCoordinatesAfterMoveUp(int x, int y, Position currentPosition) {
		if (x > topRightXCoordinate || y > topRightYCoordinate || x < 0 || y < 0) {
			throw new RuntimeException("Move Up operation caused boundary error" + currentPosition);
		}
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public int getTopRightXCoordinate() {
		return topRightXCoordinate;
	}

	public int getTopRightYCoordinate() {
		return topRightYCoordinate;
	}
	
	public void printRoverPosition() {
		System.out.println(currentPosition.getX()+" "+currentPosition.getY()+" "+currentPosition.getDirection());
	}

}
