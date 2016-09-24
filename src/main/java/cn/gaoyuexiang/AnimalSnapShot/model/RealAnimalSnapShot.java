package cn.gaoyuexiang.AnimalSnapShot.model;

public class RealAnimalSnapShot {
	private String name;
	private int x;
	private int y;
	private int startX;
	private int startY;

	public RealAnimalSnapShot(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
	}

	public RealAnimalSnapShot(String name, int x, int y, int startX, int startY) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.startX = startX;
		this.startY = startY;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " " + x + " " + y + " " + startX + " " + startY;
	}

	public boolean isConflicted(AnimalSnapShot movingAnimal) {
		return movingAnimal.getPreviousX() != this.x
						|| movingAnimal.getPreviousY() != this.y;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}
}
