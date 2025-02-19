package exceptions;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurException extends Exception{

private static final long serialVersionUID = 1L;
	
	private List<String> messages;
	
	public UtilisateurException() {
		messages = new ArrayList<>();
	}
	
	public UtilisateurException(String message) {
		super(message);
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
}
