package io.github.mschonaker.hamysql.api;

public class UserAlreadyExistsException extends UserException {

	private static final long serialVersionUID = -3055108301078617125L;

	public UserAlreadyExistsException(String username) {
		super(username);
	}
}
