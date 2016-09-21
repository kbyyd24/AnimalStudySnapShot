package cn.gaoyuexiang.AnimalSnapShot.exception;

public class NoSuchSnapShotException extends AnimalStudyException {
	public NoSuchSnapShotException() {
		super();
	}

	public NoSuchSnapShotException(String message) {
		super(message);
	}

	public NoSuchSnapShotException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchSnapShotException(Throwable cause) {
		super(cause);
	}

	protected NoSuchSnapShotException(String message, Throwable cause,
	                               boolean enableSuppression,
	                               boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
