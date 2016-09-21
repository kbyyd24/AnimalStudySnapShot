package cn.gaoyuexiang.AnimalSnapShot.model;

import java.util.ArrayList;
import java.util.List;

public class SnapShot {

	private String id;
	private Long time;
	private List<AnimalSnapShot> animals;

	public SnapShot(String id, long time) {
		this.id = id;
		this.time = time;
	}

	public SnapShot() {}

	public String getId() {
		return id;
	}

	public List<AnimalSnapShot> getAnimals() {
		return animals;
	}

	public Long getTime() {
		return time;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void addAnimal(AnimalSnapShot animal) {
		if (this.animals == null) {
			this.animals = new ArrayList<>();
		}
		this.animals.add(animal);
	}
}
