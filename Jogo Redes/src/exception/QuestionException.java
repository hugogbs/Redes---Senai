package exception;

import java.io.Serializable;

public class QuestionException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestionException(String cause) {
		super(cause);
	}

}
