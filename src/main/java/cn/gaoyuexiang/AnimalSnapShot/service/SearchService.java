package cn.gaoyuexiang.AnimalSnapShot.service;

import java.util.List;

public interface SearchService {
	<T> T search(List<T> snapShots, String id);
}
