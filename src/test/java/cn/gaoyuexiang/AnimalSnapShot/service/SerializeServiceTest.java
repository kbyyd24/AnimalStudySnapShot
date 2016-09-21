package cn.gaoyuexiang.AnimalSnapShot.service;

import cn.gaoyuexiang.AnimalSnapShot.exception.InvalidDataFormatException;
import cn.gaoyuexiang.AnimalSnapShot.model.SnapShot;
import cn.gaoyuexiang.AnimalSnapShot.service.impl.SortedSerializeService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static cn.gaoyuexiang.AnimalSnapShot.config.TestHistoryDataConfig.INVALID_FORMAT_ANIMAL_HISTORY_DATA;
import static cn.gaoyuexiang.AnimalSnapShot.config.TestHistoryDataConfig.INVALID_FORMAT_TIME_HISTORY_DATA;
import static cn.gaoyuexiang.AnimalSnapShot.config.TestHistoryDataConfig.VALID_HISTORY_DATA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SerializeServiceTest {

	private SerializeService service;

	@Before
	public void setUp() throws Exception {
		service = new SortedSerializeService();
	}

	@Test
	public void should_return_sortedList() throws Exception {
		List<SnapShot> actual = service.parseToList(VALID_HISTORY_DATA);
		assertNotNull(actual);
		assertEquals(actual.size(), 3);
		assertEquals(actual.get(0).getId(), "e4e87cb2-8e9a-4749-abb6-26c59344dfee");
		assertEquals(actual.get(1).getId(), "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
		assertEquals(actual.get(2).getId(), "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");
		assertEquals(actual.get(0).getAnimals().size(), 1);
		assertEquals(actual.get(1).getAnimals().size(), 2);
		assertEquals(actual.get(2).getAnimals().size(), 1);
	}

	@Test
	public void should_throw_InvalidDataFormatException() throws Exception {
		List<SnapShot> actual;
		try {
			actual = service.parseToList(INVALID_FORMAT_ANIMAL_HISTORY_DATA);
		} catch (InvalidDataFormatException idfException) {
			assertEquals(idfException.getMessage(), "Invalid format");
		}
		try {
			actual = service.parseToList(INVALID_FORMAT_TIME_HISTORY_DATA);
		} catch (InvalidDataFormatException idException) {
			assertEquals(idException.getMessage(), "Invalid format");
		}

	}
}