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
	private int points;

	public User(String name, String password) throws UserException {
		if (name == null || name.length() < 8)
			throw new UserException("Invalid Name");
		if (password == null || password.length() < 6)
			throw new UserException("Invalid Password");

		this.name = name;
		this.password = password;
		this.points = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws UserException {
		if (name == null || name.length() < 10)
			throw new UserException("Invalid Name");
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UserException {
		if (password == null || password.length() < 6)
			throw new UserException("Invalid Password");
		this.password = password;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
