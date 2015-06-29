package core;

import java.io.Serializable;

import exception.QuestionException;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String[] answers = new String[5];
	private int idCorrentAnswer;

	public Question(String text, String[] answers, int idCorrect)
			throws QuestionException {
		if (text == null || text.equals(""))
			throw new QuestionException("Invalid Text");
		if (answers == null)
			throw new QuestionException("Invalid Answers");
		if (answers.length != 5)
			throw new QuestionException("Invalid Nunber of Answers");
		for (int i = 0; i < 5; i++) {
			if (answers[i] == null || answers[i].equals(""))
				throw new QuestionException("Invalid Answer");
			for (int j = i + 1; j < 5; j++) {
				if (answers[i].equals(answers[j]))
					throw new QuestionException("Same Answers");
			}
		}

		if (idCorrect < 0 || idCorrect > 4)
			throw new QuestionException("Correct Answer Not Found");

		this.text = text;
		this.answers = answers;
		this.idCorrentAnswer = idCorrect;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) throws QuestionException {
		if (text == null || text.equals(""))
			throw new QuestionException("Invalid Text");
		this.text = text;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) throws QuestionException {
		if (answers == null)
			throw new QuestionException("Invalid Answers");
		if (answers.length != 5)
			throw new QuestionException("Invalid Nunber of Answers");
		for (int i = 0; i < 5; i++) {
			if (answers[i] == null || answers[i].equals(""))
				throw new QuestionException("Invalid Answer");
			for (int j = i + 1; j < 5; j++) {
				if (answers[i].equals(answers[j]))
					throw new QuestionException("Same Answers");
			}
		}
		this.answers = answers;
	}

	public int getIdCorrentAnswer() {
		return idCorrentAnswer;
	}

	public void setIdCorrentAnswer(int idCorrentAnswer)
			throws QuestionException {
		if (idCorrentAnswer < 0 || idCorrentAnswer > 4)
			throw new QuestionException("Correct Answer Not Found");
		this.idCorrentAnswer = idCorrentAnswer;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Question))
			return false;
		Question q = (Question) obj;
		return getText().equals(q.getText())
				&& this.getAnswers().equals(q.getAnswers());
	}
}
