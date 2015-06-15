package exception;

import java.io.Serializable;

public class UserException extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException(String cause) {
		super(cause);
	}

}
