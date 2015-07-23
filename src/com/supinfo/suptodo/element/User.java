package com.supinfo.suptodo.element;

public class User {
	private String login;
	private String password;
	private boolean isAdmin;
	
	public User( String login, String password , boolean isAdmin ) {
		this.setLogin(login);
		this.setPassword(password);
		this.setAdmin(isAdmin);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
