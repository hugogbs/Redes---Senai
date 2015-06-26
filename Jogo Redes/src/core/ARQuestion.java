package core;

import java.io.Serializable;

import exception.QuestionException;

public class ARQuestion extends Question implements Serializable{

	public ARQuestion(String text, String[] answers, int idCorrect)
			throws QuestionException {
		super(text, answers, idCorrect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ARQuestion))
			return false;
		Question q = (ARQuestion) obj;
		return getText().equals(q.getText()) && this.getAnswers().equals(q.getAnswers());
	}

}
