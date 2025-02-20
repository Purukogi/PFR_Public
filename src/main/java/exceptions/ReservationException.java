package exceptions;

import java.util.ArrayList;
import java.util.List;

public class ReservationException extends Exception {

private static final long serialVersionUID = 1L;
	
	private List<String> messages;
	
	public ReservationException() {
		messages = new ArrayList<>();
	}
	
	public ReservationException(String message) {
		super(message);
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
}
