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

	@Override
	public String toString() {
		return name + " " + x + " " + y;
	}

	public boolean isConflicted(AnimalSnapShot movingAnimal) {
		return movingAnimal.getPreviousX() != this.x
						|| movingAnimal.getPreviousY() != this.y;
	}
}
