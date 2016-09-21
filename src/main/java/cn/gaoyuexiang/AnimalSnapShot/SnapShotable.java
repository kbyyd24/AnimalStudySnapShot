package cn.gaoyuexiang.AnimalSnapShot;

public interface SnapShotable {
	String getSnapShot(String historyData, String id);

	String getSnapShot(String id);
}
