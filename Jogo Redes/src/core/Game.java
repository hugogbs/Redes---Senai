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
		users = new ArrayList<User>();
		questions = new ArrayList<Question>();
	}
	
	public List<User> getUsers() {
		return users;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question q){
		for (int i = 0; i < questions.size(); i++) {
			if (q.equals(questions.get(i)))
				return;
		}
		questions.add(q);		
	}
	
	public void removeUser(String userName) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName)){
				users.remove(i);
				return;
			}
		}
	}
	
	public void addUser(User u) {
		for (int i = 0; i < users.size(); i++) {
			if (u.equals(users.get(i)))
				return;
		}
		users.add(u);
	}

}
