package io.github.mschonaker.hamysql.api;

public class UserDoesntExistException extends UserException {

	private static final long serialVersionUID = -2431693638076622890L;

	public UserDoesntExistException(String username) {
		super(username);
	}
}
