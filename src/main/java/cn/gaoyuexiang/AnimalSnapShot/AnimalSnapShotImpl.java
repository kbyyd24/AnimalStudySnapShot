package cn.gaoyuexiang.AnimalSnapShot;

import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.MapService;
import cn.gaoyuexiang.AnimalSnapShot.service.SearchService;
import cn.gaoyuexiang.AnimalSnapShot.service.SerializeService;
import cn.gaoyuexiang.AnimalSnapShot.service.impl.RealSnapShotMapService;
import cn.gaoyuexiang.AnimalSnapShot.service.impl.SearchSnapShotService;
import cn.gaoyuexiang.AnimalSnapShot.service.impl.SortedSerializeService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalSnapShotImpl implements SnapShotable {

	private SerializeService serializeService;
	private MapService mapService;
	private SearchService searchService;
	private Map<String, RealSnapShot> realSnapShots;

	public AnimalSnapShotImpl(SerializeService serializeService,
	                          MapService mapService,
	                          SearchService searchService) {
		this.serializeService = serializeService;
		this.mapService = mapService;
		this.searchService = searchService;
	}

	public AnimalSnapShotImpl() {
		this.serializeService = new SortedSerializeService();
		this.mapService = new RealSnapShotMapService();
		this.searchService = new SearchSnapShotService();
	}

	@Override
	public String getSnapShot(String historyData, String id) {
		try {
			List<SnapShot> snapShots = serializeService.parseToList(historyData);
			realSnapShots = mapService.map(snapShots)
							.stream()
							.collect(Collectors.toMap(RealSnapShot::getId, snapShot -> snapShot));
			RealSnapShot aimSnapShot = searchService.search(realSnapShots, id);
			return getResult(aimSnapShot);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private String getResult(RealSnapShot aimSnapShot) {
		String ret = aimSnapShot.getResult();
		ret += "\n" + getLongestDistanceAnimal(aimSnapShot);
		return ret;
	}

	private String getLongestDistanceAnimal(RealSnapShot aimSnapShot) {
		aimSnapShot
						.getAnimals()
						.sort((a1, a2) ->
										a2.getDistance() - a1.getDistance());
		return aimSnapShot.getAnimals().get(0).getName();
	}

	@Override
	public String getSnapShot(String id) {
		if (this.realSnapShots == null)
			return "No snapshot data found";
		try {
			RealSnapShot aimSnapShot = searchService.search(realSnapShots, id);
			return getResult(aimSnapShot);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
