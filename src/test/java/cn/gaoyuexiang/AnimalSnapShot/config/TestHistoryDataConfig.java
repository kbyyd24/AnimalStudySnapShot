package cn.gaoyuexiang.AnimalSnapShot.config;

public class TestHistoryDataConfig {
	public final static String VALID_HISTORY_DATA =
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

	public final static String INVALID_FORMAT_ANIMAL_HISTORY_DATA =
					"e4e87cb2-8e9a-4749-abb6-26c59344dfee\n" +
									"2016/09/02 22:30:46\n" +
									"cat1 10 9\n\n" +
									"351055db-33e6-4f9b-bfe1-16f1ac446ac1\n" +
									"2016/09/02 22:30:52\n" +
									"cat1 10 9 2\n" +
									"cat2 2 3\n\n" +
									"dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n" +
									"2016/09/02 22:31:02\n" +
									"cat1 12 8 3 4";

	public final static String INVALID_FORMAT_TIME_HISTORY_DATA =
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

	public final static String CONLICT_DATA_AT_LAST_HISTORY_DATA=
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
}
