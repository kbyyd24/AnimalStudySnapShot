package cn.gaoyuexiang.AnimalSnapShot.service;

import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;

import java.util.List;

public interface SearchService {
	RealSnapShot search(List<RealSnapShot> snapShots, String id);
}
