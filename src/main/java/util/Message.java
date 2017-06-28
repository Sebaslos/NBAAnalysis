package util;


public class Message {

	public static final String EMPTY = "empty";
	public static final String INFO = "info";
	public static final String CLOSE = "close";
	public static final String PROCESS = "process";

	private String type;
	private String info;

	public Message(String type) {
		this.type = type;
		this.info = "";
	}

	public Message(String type, String info) {
		this.type = type;
		this.info = info;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
