package cn.gaoyuexiang.AnimalSnapShot;

import cn.gaoyuexiang.AnimalSnapShot.model.AnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;

import java.util.ArrayList;
import java.util.List;

public class AnimalSnapShotImpl implements SnapShotable {
	@Override
	public String getSnapShot(String historyData, String id) {
		List<SnapShot> maps = SnapShot.buildList(historyData);
		maps.sort((map1, map2) ->	(int) (map1.getTime() - map2.getTime()));
		// TODO: 16-9-20 reduce map to RealSnapShot list

		return null;
	}
}
