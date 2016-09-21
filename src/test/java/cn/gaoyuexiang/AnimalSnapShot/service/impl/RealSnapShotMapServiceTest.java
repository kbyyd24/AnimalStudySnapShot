package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.ConflictDataException;
import cn.gaoyuexiang.AnimalSnapShot.model.AnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RealSnapShotMapServiceTest {

	private RealSnapShotMapService service;
	private List<SnapShot> source;

	@Before
	public void setUp() throws Exception {
		service = new RealSnapShotMapService();

		source = new ArrayList<>(3);
		SnapShot snapShot = new SnapShot("123", 1L);
		snapShot.addAnimal(new AnimalSnapShot("cat1 10 9"));
		source.add(snapShot);

		snapShot = new SnapShot("124", 2L);
		snapShot.addAnimal(new AnimalSnapShot("cat1 10 9 2 -1"));
		snapShot.addAnimal(new AnimalSnapShot("cat2 2 3"));
		source.add(snapShot);

		snapShot = new SnapShot("125", 3L);
		snapShot.addAnimal(new AnimalSnapShot("cat1 12 8 3 4"));
		source.add(snapShot);
	}

	@Test
	public void should_return_real_list() throws Exception {
		List<RealSnapShot> realSnapShots = service.map(source);

		assertEquals(realSnapShots.size(), source.size());

		assertEquals(realSnapShots.get(0).getId(), source.get(0).getId());
		assertEquals(realSnapShots.get(1).getId(), source.get(1).getId());
		assertEquals(realSnapShots.get(2).getId(), source.get(2).getId());

		assertEquals(realSnapShots.get(0).getAnimals().size(), 1);
		assertEquals(realSnapShots.get(1).getAnimals().size(), 2);
		assertEquals(realSnapShots.get(2).getAnimals().size(), 2);
	}

	@Test
	public void should_return_ConflictDataException() throws Exception {
		source.remove(2);
		SnapShot snapShot = new SnapShot("125", 3L);
		snapShot.addAnimal(new AnimalSnapShot("cat1 11 8 3 4"));
		source.add(snapShot);

		try {
			service.map(source);
		} catch (ConflictDataException cdException) {
			assertEquals(cdException.getMessage(), "Conflict found at " + snapShot.getId());
		}

	}
}