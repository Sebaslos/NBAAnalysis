package nbadatautils;


import com.google.gson.Gson;
import json.ResponseJson;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

	private Gson gson = new Gson();

	private List<String> scrape(String result, int index) {
		ResponseJson responseJsons = gson.fromJson(result, ResponseJson.class);
		List<String> rowHeaders = responseJsons.resultSets[index].getHeaders();
		List<List<String>> rowSet = responseJsons.resultSets[index].getRowSet();

		List<String> formatResults = new ArrayList<>();
		for (List<String> row : rowSet) {
			String jsonResult = "{";
			for (int i = 0; i < row.size(); i++) {
				jsonResult += "\""+ rowHeaders.get(i) + "\":";
				jsonResult += "\"" + row.get(i) + "\"";
				if (i < row.size() - 1) {
					jsonResult += ",";
				}
			}
			jsonResult += "}";
			formatResults.add(jsonResult);
		}

		return formatResults;
	}

	public List<String> scrape(String result) {
		return scrape(result, 0);
	}

	public <T> List<T> getObjects(String result, Class<T> type) {
		return getObjects(result, type, 0);
	}

	public <T> List<T> getObjects(String result, Class<T> type, int index) {
		List<T> list = new ArrayList<>();
		for (String s : scrape(result, index)) {
			list.add(getObject(s, type));
		}
		return list;
	}

	private <T> T getObject(String json, Class<T> type) {
		return gson.fromJson(json, type);
	}

}
