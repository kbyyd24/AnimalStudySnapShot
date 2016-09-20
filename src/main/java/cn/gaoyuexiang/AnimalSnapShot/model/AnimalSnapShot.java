package cn.gaoyuexiang.AnimalSnapShot.model;

import cn.gaoyuexiang.AnimalSnapShot.exception.InvalidDataFormatException;

public class AnimalSnapShot {
	private String name;
	private int previousX;
	private int previousY;
	private int movingX;
	private int movingY;

	public AnimalSnapShot(String snapshot) {
		String[] split = snapshot.split(" ");
		int length = split.length;
		if (length != 3 && length != 5) {
			throw new InvalidDataFormatException("Invalid format");
		}
		this.name = split[0];
		this.previousX = Integer.parseInt(split[1]);
		this.previousY = Integer.parseInt(split[2]);
		if (length == 5) {
			this.movingX = Integer.parseInt(split[3]);
			this.movingY = Integer.parseInt(split[4]);
		}
	}

	public String getName() {
		return name;
	}

	public int getPreviousX() {
		return previousX;
	}

	public int getPreviousY() {
		return previousY;
	}

	public int getMovingX() {
		return movingX;
	}

	public int getMovingY() {
		return movingY;
	}
}
