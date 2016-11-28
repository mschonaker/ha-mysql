package io.github.mschonaker.hamysql.api;

public abstract class UserException extends RuntimeException {

	private static final long serialVersionUID = 6407610734374768529L;

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}
}
