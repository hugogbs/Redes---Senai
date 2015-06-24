package core;

import java.io.Serializable;

import exception.UserException;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String userName;
	private int points;

	public User(String username, String name, String password) throws UserException {
		if (username == null || username.length() < 5)
			throw new UserException("Invalid Username");
		if (name == null || name.length() < 5)
			throw new UserException("Invalid Name");
		if (password == null || password.length() < 5)
			throw new UserException("Invalid Password");

		this.name = name;
		this.password = password;
		this.setUserName(username);
		this.points = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws UserException {
		if (name == null || name.length() < 5)
			throw new UserException("Invalid Name");
		else this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UserException {
		if (password == null || password.length() < 5)
			throw new UserException("Invalid Password");
		else this.password = password;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) throws UserException {
		if (userName == null || userName.length() < 5)
			throw new UserException("Invalid Username");
		else this.userName = userName;
	}
	@Override
	public String toString() {
		return "Name: " + name + "\nUsername: " + userName +  "\nPassword: " + password;
	}

}
