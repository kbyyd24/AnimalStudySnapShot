package cn.gaoyuexiang.AnimalSnapShot.exception;

public class ConflictDataException extends RuntimeException {
	public ConflictDataException() {
		super();
	}

	public ConflictDataException(String message) {
		super(message);
	}

	public ConflictDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConflictDataException(Throwable cause) {
		super(cause);
	}

	protected ConflictDataException(String message, Throwable cause,
	                                     boolean enableSuppression,
	                                     boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
