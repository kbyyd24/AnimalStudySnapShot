package cn.gaoyuexiang.AnimalSnapShot.exception;

public class AnimalStudyException extends RuntimeException {
	public AnimalStudyException() {
		super();
	}

	public AnimalStudyException(String message) {
		super(message);
	}

	public AnimalStudyException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnimalStudyException(Throwable cause) {
		super(cause);
	}

	protected AnimalStudyException(String message, Throwable cause,
	                                boolean enableSuppression,
	                                boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
