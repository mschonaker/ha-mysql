package io.github.mschonaker.hamysql;

public class User {

	private String username;
	private String realname;
	private String password;

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", realname=" + realname + ", password=" + password + "]";
	}
}
