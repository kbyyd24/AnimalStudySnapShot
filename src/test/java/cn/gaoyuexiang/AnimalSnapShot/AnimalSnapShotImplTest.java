package cn.gaoyuexiang.AnimalSnapShot;

import cn.gaoyuexiang.AnimalSnapShot.exception.ConflictDataException;
import org.junit.Test;

import static cn.gaoyuexiang.AnimalSnapShot.config.TestHistoryDataConfig.*;
import static org.junit.Assert.assertEquals;

public class AnimalSnapShotImplTest {

	@Test
	public void should_get_right_answer() throws Exception {
		String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
		String expected =
						"cat1 15 12\n" +
						"cat2 2 3";
		SnapShotable animalMap = new AnimalSnapShotImpl();
		String actual = animalMap.getSnapShot(VALID_HISTORY_DATA, id);
		assertEquals(expected, actual);
	}

	@Test
	public void should_throw_InvalidDataFormatException() throws Exception {
		String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
		String expected = "Invalid format";
		AnimalSnapShotImpl animalMap = new AnimalSnapShotImpl();
		String actual = animalMap.getSnapShot(INVALID_FORMAT_TIME_HISTORY_DATA, id);
		assertEquals(expected, actual);
		actual = animalMap.getSnapShot(INVALID_FORMAT_ANIMAL_HISTORY_DATA, id);
		assertEquals(expected, actual);
	}

	@Test
	public void should_throw_ConflictDataException() throws Exception {
		String id = "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155";
		String expected = "Conflict found at " + id;
		AnimalSnapShotImpl animalMap = new AnimalSnapShotImpl();
		try {
			animalMap.getSnapShot(CONLICT_DATA_AT_LAST_HISTORY_DATA, id);
		} catch (ConflictDataException cdException) {
			String message = cdException.getMessage();
			assertEquals(expected, message);
		}
	}
}