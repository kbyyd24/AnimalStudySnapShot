package cn.gaoyuexiang.AnimalSnapShot.service;

import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;

import java.util.List;

public interface MapService {
	List<RealSnapShot> map(List<SnapShot> snapShots);
}
