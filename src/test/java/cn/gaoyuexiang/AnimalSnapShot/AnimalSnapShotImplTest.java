package cn.gaoyuexiang.AnimalSnapShot;

import cn.gaoyuexiang.AnimalSnapShot.exception.ConflictDataException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalSnapShotImplTest {

	@Test
	public void should_get_right_answer() throws Exception {
		String historyData =
						"e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
						"2016/09/02 22:30:46\n" +
						"cat1 10 9\n\n" +
						"351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
						"2016/09/02 22:30:52\n" +
						"cat1 10 9 2 -1\n" +
						"cat2 2 3\n\n" +
						"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
						"2016/09/02 22:31:02\n" +
						"cat1 12 8 3 4";
		String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
		String expected =
						"cat1 15 12\n" +
						"cat2 2 3";
		SnapShotable animalMap = new AnimalSnapShotImpl();
		String actual = animalMap.getSnapShot(historyData, id);
		assertEquals(expected, actual);
	}

	@Test
	public void should_throw_InvalidDataFormatException() throws Exception {
		String historyData =
						"e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
										"2016/09/02 22:30:46\n" +
										"cat1 10 9\n\n" +
										"351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
										"2016/09/02-22:30:52\n" +
										"cat1 10 9 2\n" +
										"cat2 2 3\n\n" +
										"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
										"2016/09/02 22:31:02\n" +
										"cat1 12 8 3 4";
		String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
		String expected = "Invalid format";
		AnimalSnapShotImpl animalMap = new AnimalSnapShotImpl();
		String actual = animalMap.getSnapShot(historyData, id);
		assertEquals(expected, actual);
	}

	@Test
	public void should_throw_ConflictDataException() throws Exception {
		String historyData =
						"e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
										"2016/09/02 22:30:46\n" +
										"cat1 10 9\n\n" +
										"351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
										"2016/09/02 22:30:52\n" +
										"cat1 10 9 2 -1\n" +
										"cat2 2 3\n\n" +
										"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
										"2016/09/02 22:31:02\n" +
										"cat1 12 10 3 4";
		String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
		String expected = "Conflict found at " + id;
		AnimalSnapShotImpl animalMap = new AnimalSnapShotImpl();
		try {
			animalMap.getSnapShot(historyData, id);
		} catch (ConflictDataException cdException) {
			String message = cdException.getMessage();
			assertEquals(expected, message);
		}
	}
}