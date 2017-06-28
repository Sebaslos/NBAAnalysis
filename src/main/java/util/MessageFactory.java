package util;


import java.util.ArrayList;
import java.util.List;

public class MessageFactory {

	private static List<Message> messages = new ArrayList<>();

	public static synchronized void write(Message message) {
		messages.add(message);
	}

	public static synchronized Message read() {
		if (messages.isEmpty()) {
			return new Message(Message.EMPTY);
		} else {
			return messages.remove(0);
		}
	}

	public static synchronized int size() {
		return messages.size();
	}

}