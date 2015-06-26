package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List<Question> resolvidos;
	private List<Boolean> acertos;

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
		this.resolvidos = new ArrayList<Question>();
		this.acertos = new ArrayList<Boolean>();
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

	public List<Question> getResolvidos() {
		return resolvidos;
	}

	public void addResolvidos(Question q, boolean acerto) {
		for (int i = 0; i < resolvidos.size(); i++) {
			if (q.equals(resolvidos.get(i))){
					acertos.set(i, acerto);
					return;
					}	
		}
		resolvidos.add(q);
		acertos.add(acerto);
	}

	public List<Boolean> getAcertos() {
		return acertos;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User))
			return false;
		User u = (User) obj;
		return getUserName().equals(u.getUserName());
	}

}
