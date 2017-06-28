package util;


import json.ResultSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RESTUtil {

	public ResultSet buildResultSet(String name, String[] headers, List<Object[]> rows) {
		ResultSet resultSet = new ResultSet();
		resultSet.setName(name);
		resultSet.setHeaders(Arrays.asList(headers));

		List<List<String>> rowSet = new ArrayList<>();
		for (Object[] row : rows) {
			List<String> values = new ArrayList<>();
			for (Object value : row) {
				String v;
				if (value == null) {
					v = "null";
				} else {
					v = value.toString();
				}
				values.add(v);
			}
			rowSet.add(values);

//			List<String> values = Arrays.stream(row).map(Object::toString).collect(Collectors.toList());
		}
		resultSet.setRowSet(rowSet);

		return resultSet;
	}

}
