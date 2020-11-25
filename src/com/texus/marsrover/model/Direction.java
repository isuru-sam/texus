package com.texus.marsrover.model;

public enum Direction {
	N {
		@Override
		public Direction moveLeft() {
			return Direction.W;
		}

		@Override
		public Direction moveRight() {
			return Direction.E;
		}

		@Override
		public int[] moveUp(Position current) {

			return new int[]{current.getX(),current.getY()+1};
		}

	},
	E {
		@Override
		public Direction moveLeft() {
			return Direction.N;
		}

		@Override
		public Direction moveRight() {
			return Direction.S;
		}

		@Override
		public int[]  moveUp(Position current) {

			return new int[]{current.getX()+1,current.getY()};
		}
	}

	,
	S {
		@Override
		public Direction moveLeft() {
			return Direction.E;
		}

		@Override
		public Direction moveRight() {
			return Direction.W;
		}

		@Override
		public int[]  moveUp(Position current) {

			return new int[]{current.getX(),current.getY()-1};
		}
	},
	W {
		@Override
		public Direction moveLeft() {
			return Direction.S;
		}

		@Override
		public Direction moveRight() {
			return Direction.N;
		}

		@Override
		public int[]  moveUp(Position current) {

			return new int[]{current.getX()-1,current.getY()};
		}
	};

	public abstract Direction moveLeft();

	public abstract Direction moveRight();

	public abstract int[] moveUp(Position current);
}
