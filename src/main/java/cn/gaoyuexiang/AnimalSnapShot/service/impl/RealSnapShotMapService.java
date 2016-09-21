package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.ConflictDataException;
import cn.gaoyuexiang.AnimalSnapShot.model.AnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealAnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.MapService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RealSnapShotMapService implements MapService {
	@Override
	public List<RealSnapShot> map(List<SnapShot> snapShots) {
		List<RealSnapShot> ret = new ArrayList<>(snapShots.size());
		snapShots.forEach(snapShot -> {
			RealSnapShot realSnapShot =
							new RealSnapShot(snapShot.getId(), snapShot.getTime());
			if (ret.isEmpty()) {
				realSnapShot.addAnimalsByAnimalSnapShots(snapShot.getAnimals());
			} else {
				Map<Boolean, List<AnimalSnapShot>> classfiedSnapShots =
								partitioningAnimals(snapShot);
				List<AnimalSnapShot> newAnimals = classfiedSnapShots.get(true);
				List<AnimalSnapShot> existedAnimals = classfiedSnapShots.get(false);
				List<RealAnimalSnapShot> preAnimals =
								ret.get(ret.size() - 1).getAnimals();
				realSnapShot.addAnimalsByAnimalSnapShots(newAnimals);
				mapExistedAnimals(realSnapShot, existedAnimals, preAnimals);
			}
			ret.add(realSnapShot);
		});
		return ret;
	}

	private void mapExistedAnimals(RealSnapShot realSnapShot, List<AnimalSnapShot> existedAnimals, List<RealAnimalSnapShot> preAnimals) {
		preAnimals.forEach(preAnimal -> {
			String name = preAnimal.getName();
			Optional<AnimalSnapShot> matchAnimal = existedAnimals.stream()
							.filter(item -> item.getName().equals(name))
							.findFirst();
			if (matchAnimal.isPresent()) {
				AnimalSnapShot movingAnimal = matchAnimal.get();
				if (preAnimal.isConflicted(movingAnimal)) {
					throw new ConflictDataException("Conflict found at " + realSnapShot.getId());
				}
				realSnapShot.addAnimal(new RealAnimalSnapShot(
								movingAnimal.getName(),
								movingAnimal.getPreviousX() + movingAnimal.getMovingX(),
								movingAnimal.getPreviousY() + movingAnimal.getMovingY()));
			} else {
				realSnapShot.addAnimal(preAnimal);
			}
		});
	}

	private Map<Boolean, List<AnimalSnapShot>> partitioningAnimals(SnapShot snapShot) {
		List<AnimalSnapShot> animals = snapShot.getAnimals();
		return animals
						.stream()
						.collect(Collectors.partitioningBy(animal ->
										animal.getMovingX() == 0 && animal.getMovingY() == 0));
	}
}
