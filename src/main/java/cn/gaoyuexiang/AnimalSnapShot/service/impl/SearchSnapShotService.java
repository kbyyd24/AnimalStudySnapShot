package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.NoSuchSnapShotException;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.SearchService;

import java.util.Map;

public class SearchSnapShotService implements SearchService {

	@Override
	public RealSnapShot search(Map<String, RealSnapShot> snapShots, String id) {
		RealSnapShot realSnapShot = snapShots.get(id);
		if (realSnapShot == null) {
			throw new NoSuchSnapShotException("Not found " + id);
		}
		return realSnapShot;
	}
}
