package core;

import java.io.Serializable;

import exception.QuestionException;

public class CEQuestion extends Question implements Serializable {

	public CEQuestion(String text, String[] answers, int idCorrect)
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
		if (!(obj instanceof CEQuestion))
			return false;
		Question q = (CEQuestion) obj;
		return getText().equals(q.getText()) && this.getAnswers().equals(q.getAnswers());
	}

}
