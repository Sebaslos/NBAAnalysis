package nbadatautils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class NBADataUtil {

	private String base_url = "http://stats.nba.com/stats/{endpoint}";

	private JsonUtil jsonUtil = new JsonUtil();

	public <T> List<T> getObjects(String endpoint, Map<String, String> params, Class<T> type) {
		return jsonUtil.getObjects(getJson(endpoint, params), type);
	}

	public List<String> getResultAsString(String endpoint, Map<String, String> params) {
		return jsonUtil.scrape(getJson(endpoint, params));
	}

	public String getJson(String endpoint, Map<String, String> params) {
		String url = getUrl(params);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("referer", "http://stats.nba.com/scores/");
		headers.add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) " +
				"AppleWebKit/537.36 (KHTML, like Gecko) " +
				"Chrome/45.0.2454.101 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, endpoint);

		return result.getBody();
	}

	private RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(30 * 1000);
		((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(30 * 1000);

		return restTemplate;
	}

	private String getUrl(Map<String, String> params) {
		if (!params.isEmpty()) {
			StringBuffer url = new StringBuffer();
			url.append(base_url + "/");

			int index = 0;
			for (Map.Entry<String, String> item : params.entrySet()) {
				if (index == 0) {
					url.append("?");
				} else {
					url.append("&");
				}
				url.append(item.getKey() + "=" + item.getValue());
				index++;
			}
			return url.toString();
		} else {
			return base_url;
		}
	}

}
