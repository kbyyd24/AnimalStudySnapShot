package cn.gaoyuexiang.AnimalSnapShot;

import cn.gaoyuexiang.AnimalSnapShot.exception.ConflictDataException;
import cn.gaoyuexiang.AnimalSnapShot.model.AnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealAnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnimalSnapShotImpl implements SnapShotable {
	@Override
	public String getSnapShot(String historyData, String id) {
		//split historyData and save into a list
		List<SnapShot> maps = SnapShot.buildList(historyData);
		//sort the list by time
		maps.sort((map1, map2) ->	(int) (map1.getTime() - map2.getTime()));
		//map the list to be a list of RealSnapShot
		List<RealSnapShot> snapShots = new ArrayList<>(maps.size());
		mapAnimalsList(maps, snapShots);
		return null;
	}

	private void mapAnimalsList(List<SnapShot> maps, List<RealSnapShot> snapShots) {
		maps.forEach(map -> {
			RealSnapShot snapShot = new RealSnapShot(map.getId(), map.getTime());
			List<AnimalSnapShot> animals = map.getAnimals();
			if (snapShots.size() > 0) {
				List<RealAnimalSnapShot> preAnimals =
								snapShots.get(snapShots.size() - 1).getAnimals();
				Predicate<AnimalSnapShot> predicate = animal ->
								animal.getMovingX() == 0 && animal.getMovingY() == 0;
				Map<Boolean, List<AnimalSnapShot>> classifiedLists = animals
								.stream()
								.collect(Collectors.partitioningBy(predicate));
				List<AnimalSnapShot> newAnimals = classifiedLists.get(true);
				List<AnimalSnapShot> existedAnimals = classifiedLists.get(false);
				snapShot.setAnimalsByAnimalSnapShots(newAnimals);
				mapExistedAnimals(snapShots, map, snapShot, preAnimals, existedAnimals);
			} else {
				setFirstSnapShot(snapShots, snapShot, animals);
			}
		});
	}

	private void mapExistedAnimals(List<RealSnapShot> snapShots,
	                               SnapShot map,
	                               RealSnapShot snapShot,
	                               List<RealAnimalSnapShot> preAnimals,
	                               List<AnimalSnapShot> existedAnimals) {
		preAnimals.forEach(animal -> {
			String name = animal.getName();
			AnimalSnapShot movingAnimal = existedAnimals.stream()
							.filter(item -> item.getName().equals(name))
							.findFirst()
							.orElseThrow(ConflictDataException::new);
			if (animal.isConflicted(movingAnimal))
				throw new ConflictDataException("Conflict found at " + map.getId());
			snapShot.addAnimal(new RealAnimalSnapShot(animal.getName(),
							movingAnimal.getPreviousX() + movingAnimal.getMovingX(),
							movingAnimal.getPreviousY() + movingAnimal.getMovingY()));
			snapShots.add(snapShot);
		});
	}

	private void setFirstSnapShot(List<RealSnapShot> snapShots, RealSnapShot snapShot, List<AnimalSnapShot> animals) {
		snapShot.setAnimalsByAnimalSnapShots(animals);
		snapShots.add(snapShot);
	}
}
