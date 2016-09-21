package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.InvalidDataFormatException;
import cn.gaoyuexiang.AnimalSnapShot.model.AnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.SerializeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SortedSerializeService implements SerializeService {
	@Override
	public List<SnapShot> parseToList(String historyData) {
		String[] split = historyData.split("\n");
		List<SnapShot> ret = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			SnapShot snapShot = new SnapShot();
			snapShot.setId(split[i++]);
			setTime(split[i++], snapShot);
			while (!split[i].isEmpty()) {
				snapShot.addAnimal(new AnimalSnapShot(split[i++]));
				if (i >= split.length) break;
			}
			ret.add(snapShot);
		}
		ret.sort((s1, s2) -> s1.getTime().compareTo(s2.getTime()));
		return ret;
	}

	private void setTime(String time, SnapShot snapShot) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		try {
			snapShot.setTime(dateFormat.parse(time).getTime());
		} catch (ParseException e) {
			throw new InvalidDataFormatException("Invalid format");
		}
	}
}
