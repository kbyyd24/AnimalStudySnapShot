package cn.gaoyuexiang.AnimalSnapShot.service;

import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;

import java.util.Map;

public interface SearchService {
	RealSnapShot search(Map<String, RealSnapShot> snapShots, String id);
}
