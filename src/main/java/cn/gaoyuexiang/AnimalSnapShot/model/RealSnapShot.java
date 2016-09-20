package cn.gaoyuexiang.AnimalSnapShot.model;

import java.util.ArrayList;
import java.util.List;

public class RealSnapShot {
	private String id;
	private long time;
	private List<RealAnimalSnapShot> animals;

	public RealSnapShot() {}

	public RealSnapShot(String id, long time) {
		this.id = id;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public long getTime() {
		return time;
	}

	public List<RealAnimalSnapShot> getAnimals() {
		return animals;
	}

	public void setAnimalsByAnimalSnapShots(List<AnimalSnapShot> animals) {
		this.animals = new ArrayList<>(animals.size());
		animals.forEach(animal ->
			this.animals.add(new RealAnimalSnapShot(animal.getName(),
							animal.getPreviousX(),
							animal.getPreviousY()))
		);
	}
}
