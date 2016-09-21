package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.NoSuchSnapShotException;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.SearchService;

import java.util.List;
import java.util.Optional;

public class SearchSnapShotService implements SearchService {

	@Override
	public RealSnapShot search(List<RealSnapShot> snapShots, String id) {
		Optional<RealSnapShot> matchSnapShot = snapShots
						.stream()
						.filter(item -> item.getId().equals(id))
						.findFirst();
		if (matchSnapShot.isPresent()) {
			return matchSnapShot.get();
		}
		throw new NoSuchSnapShotException("Not found " + id);
	}
}
