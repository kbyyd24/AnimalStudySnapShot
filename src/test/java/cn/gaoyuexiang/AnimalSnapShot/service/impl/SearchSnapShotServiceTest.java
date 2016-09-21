package cn.gaoyuexiang.AnimalSnapShot.service.impl;

import cn.gaoyuexiang.AnimalSnapShot.exception.NoSuchSnapShotException;
import cn.gaoyuexiang.AnimalSnapShot.model.RealAnimalSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.model.RealSnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.SearchService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchSnapShotServiceTest {

	private SearchService service;
	private List<RealSnapShot> source;

	@Before
	public void setUp() throws Exception {
		service = new SearchSnapShotService();

		source = new ArrayList<>(3);
		RealSnapShot realSnapShot = new RealSnapShot("1a", 1L);
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat1", 10, 9));
		source.add(realSnapShot);

		realSnapShot = new RealSnapShot("2b", 2L);
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat1", 12, 8));
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat2", 2, 3));
		source.add(realSnapShot);

		realSnapShot = new RealSnapShot("3c", 3L);
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat1", 15, 12));
		realSnapShot.addAnimal(new RealAnimalSnapShot("cat2", 2, 3));
		source.add(realSnapShot);
	}

	@Test
	public void should_return_a_RealAnimalSnapShot() throws Exception {
		String id = "3c";
		RealSnapShot result = service.search(source, id);
		assertEquals(result.getId(), id);
		assertEquals(result.getResult(), source.get(2).getResult());
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