package cn.gaoyuexiang.AnimalSnapShot.exception;

public class InvalidDataFormatException extends AnimalStudyException {

	public InvalidDataFormatException() {
		super();
	}

	public InvalidDataFormatException(String message) {
		super(message);
	}

	public InvalidDataFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDataFormatException(Throwable cause) {
		super(cause);
	}

	protected InvalidDataFormatException(String message, Throwable cause,
	                           boolean enableSuppression,
	                           boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
