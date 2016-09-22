package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.NoSuchSnapShotException;
import cn.gaoyuexiang.AnimalSnapShot.model.RealAnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.SearchService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SearchSnapShotServiceTest {

	private SearchService service;
	private Map<String, RealSnapShot> source;

	@Before
	public void setUp() throws Exception {
		service = new SearchSnapShotService();

		List<RealSnapShot> snapShots = new ArrayList<>(3);
		RealSnapShot realSnapShot = new RealSnapShot("1a", 1L);
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat1", 10, 9));
		snapShots.add(realSnapShot);

		realSnapShot = new RealSnapShot("2b", 2L);
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat1", 12, 8));
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat2", 2, 3));
		snapShots.add(realSnapShot);

		realSnapShot = new RealSnapShot("3c", 3L);
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat1", 15, 12));
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat2", 2, 3));
		snapShots.add(realSnapShot);

		 source = snapShots
						 .stream()
						 .collect(Collectors.toMap(RealSnapShot::getId, s -> s));
	}

	@Test
	public void should_return_a_RealAnimalSnapShot() throws Exception {
		String id = "3c";
		RealSnapShot result = service.search(source, id);
		assertEquals(result.getId(), id);
		assertEquals(result.getResult(), source.get(id).getResult());
	}

	@Test
	public void should_throw_NoSuchSnapShotException() throws Exception {
		String id = "4d";
		try {
			service.search(source, id);
		} catch (NoSuchSnapShotException nsssException) {
			assertEquals(nsssException.getMessage(), "Not found " + id);
		}
	}
}