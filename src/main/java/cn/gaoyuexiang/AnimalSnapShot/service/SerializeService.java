package cn.gaoyuexiang.AnimalSnapShot.service;

import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;

import java.util.List;

public interface SerializeService {
	List<SnapShot> parseToList(String historyData);
}
