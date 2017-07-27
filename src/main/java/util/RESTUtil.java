package util;


import json.ResultSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
					v = "Sum";
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

	public void convertMonthAndSort(ResultSet resultSet, int columnIndex) {
		List<String> monthList = Arrays.asList("Jan", "Feb", "Mar",
				"Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		List<List<String>> rowSet = resultSet.getRowSet();

		int octIndex = -1;
		int index = 0;
		for (List<String> row : rowSet) {
			if (!row.get(columnIndex).equals("Sum")) {
				int month = Integer.parseInt(row.get(columnIndex));
				row.set(columnIndex, monthList.get(month - 1));

				if (month == 10 && octIndex == -1) {
					octIndex = index;
				}
				index++;

				// convert data format
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
					if (!row.get(1).equals("Sum")) {
						row.set(1, dateFormat.format(dateFormat.parse(row.get(1))));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		// sort list
		List<String> sumRow = rowSet.remove(rowSet.size() - 1);

		for (int i = 0; i < octIndex; i++) {
			List<String> row = rowSet.remove(0);
			rowSet.add(row);
		}

		rowSet.add(sumRow);
	}
}
