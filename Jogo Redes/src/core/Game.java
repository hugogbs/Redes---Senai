package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Game implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private List<Question> questions;
	
	public Game() {
		users = new ArrayList();
		questions = new ArrayList();
	}
	
	public List<User> getUsers() {
		return users;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question q){
		questions.add(q);		
	}
	
	public void addUser(User u) {
		users.add(u);
	}

}
