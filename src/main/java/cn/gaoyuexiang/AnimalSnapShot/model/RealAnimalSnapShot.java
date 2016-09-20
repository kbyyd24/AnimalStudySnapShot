package cn.gaoyuexiang.AnimalSnapShot.model;

public class RealAnimalSnapShot {
	private String name;
	private int x;
	private int y;

	public RealAnimalSnapShot(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return name + " " + x + " " + y;
	}
}
