package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private List<Question> geralQuestions;
	private List<ARQuestion> arquiteturaQuestions;
	private List<CEQuestion> cabeamentoQuestions;
	private List<Question> allQuestions;

	public Game() {
		users = new ArrayList<User>();
		geralQuestions = new ArrayList<>();
		arquiteturaQuestions = new ArrayList<>();
		cabeamentoQuestions = new ArrayList<>();
		allQuestions = new ArrayList<>();
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Question> getAllQuestions() {
		return allQuestions;
	}

	public List<Question> getGeralQuestions() {
		return geralQuestions;
	}

	public void addGeneralQuestion(Question q) {
		for (int i = 0; i < geralQuestions.size(); i++) {
			if (q.equals(geralQuestions.get(i)))
				return;
		}
		geralQuestions.add(q);
		allQuestions.add(q);
	}

	public void removeUser(String userName) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName)) {
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

	public List<ARQuestion> getArquiteturaQuestions() {
		return arquiteturaQuestions;
	}

	public void addArquiteturaQuestions(ARQuestion q) {
		for (int i = 0; i < arquiteturaQuestions.size(); i++) {
			if (q.equals(arquiteturaQuestions.get(i)))
				return;
		}
		arquiteturaQuestions.add(q);
		allQuestions.add(q);
	}

	public List<CEQuestion> getCabeamentoQuestions() {
		return cabeamentoQuestions;
	}

	public void addCabeamentoQuestion(CEQuestion q) {
		for (int i = 0; i < cabeamentoQuestions.size(); i++) {
			if (q.equals(cabeamentoQuestions.get(i)))
				return;

		}
		cabeamentoQuestions.add(q);
		allQuestions.add(q);
	}

}
