package json;


import java.util.List;

public class ResultSet {

	private String name;

	private List<String> headers;

	private List<List<String>> rowSet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<List<String>> getRowSet() {
		return rowSet;
	}

	public void setRowSet(List<List<String>> rowSet) {
		this.rowSet = rowSet;
	}
}
