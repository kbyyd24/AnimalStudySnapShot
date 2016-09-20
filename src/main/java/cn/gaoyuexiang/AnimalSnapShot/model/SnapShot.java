package cn.gaoyuexiang.AnimalSnapShot.model;

import cn.gaoyuexiang.AnimalSnapShot.exception.InvalidDataFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SnapShot {

	private String id;
	private Long time;
	private List<AnimalSnapShot> animals;

	/**
	 * use for test
	 * @param id
	 * @param time
	 */
	SnapShot(String id, long time) {
		this.id = id;
		this.time = time;
	}

	public SnapShot() {}

	public static List<SnapShot> buildList(String historyData) {
		if (historyData == null || historyData.isEmpty())
			return new ArrayList<>();
		String[] split = historyData.split("\n");
		List<SnapShot> ret = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			SnapShot snapShot = new SnapShot();
			snapShot.animals = new ArrayList<>();
			snapShot.id = split[i++];
			setTime(snapShot, split[i++]);
			while (!split[i].isEmpty()) {
				snapShot.animals.add(new AnimalSnapShot(split[i++]));
			}
		}
		return ret;
	}

	private static void setTime(SnapShot snapShot, String timeStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			snapShot.time = dateFormat.parse(timeStr).getTime();
		} catch (ParseException e) {
			throw new InvalidDataFormatException("Invalid format");
		}
	}

	public String getId() {
		return id;
	}

	public List<AnimalSnapShot> getAnimals() {
		return animals;
	}

	public Long getTime() {
		return time;
	}

	public void setAnimals(ArrayList<AnimalSnapShot> animals) {
		this.animals = animals;
	}
}
