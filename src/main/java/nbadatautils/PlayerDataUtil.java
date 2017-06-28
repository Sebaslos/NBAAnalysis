package nbadatautils;


import json.GameLog;
import json.PlayerInfo;
import json.Shotchart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerDataUtil {

	private String endpoint;

	private NBADataUtil dataUtil = new NBADataUtil();
	private JsonUtil jsonUtil = new JsonUtil();

	public PlayerInfo getPlayerInfo(String playerId) {
		endpoint = "commonplayerinfo";

		Map<String, String> vars = new HashMap<>();
		vars.put("PlayerID", playerId);

		List<PlayerInfo> playerInfo = dataUtil.getObjects(endpoint, vars, PlayerInfo.class);

		// playerInfo.size() > 1 ||
		if (playerInfo.isEmpty()) {
			throw new RuntimeException("false Player Information");
		}

		return playerInfo.get(0);
	}

	public List<GameLog> getPlayerGameLogs(String playerId, String season, String seasonType) {
		endpoint = "playergamelog";

		Map<String, String> vars = new HashMap<>();
		vars.put("PlayerID", playerId);
		vars.put("LeagueID", "00");
		vars.put("Season", season);
		vars.put("SeasonType", seasonType);

		return dataUtil.getObjects(endpoint, vars, GameLog.class);
	}

	public List<String> getPlayerList(String season) {
		endpoint = "commonallplayers";

		Map<String, String> vars = new HashMap<>();
		vars.put("LeagueID", "00");
		vars.put("Season", season);
		vars.put("IsOnlyCurrentSeason", "0");

		return dataUtil.getResultAsString(endpoint, vars);
	}

	public List<Shotchart> getShotcharts(String playerId, String season) {
		endpoint = "shotchartdetail";

		Map<String, String> vars = new HashMap<>();
		vars.put("PlayerID", playerId);
		vars.put("TeamID", "0");
		vars.put("GameID", "");
		vars.put("LeagueID", "00");
		vars.put("Season", season);
		vars.put("SeasonType", "Regular Season");
		vars.put("Outcome", "");
		vars.put("Location", "");
		vars.put("Month", "0");
		vars.put("SeasonSegment", "");
		vars.put("DateFrom", "");
		vars.put("DateTo", "");
		vars.put("OpponentTeamID", "0");
		vars.put("VsConference", "");
		vars.put("VsDivision", "");
		vars.put("PlayerPosition", "");
		vars.put("GameSegment", "");
		vars.put("Period", "0");
		vars.put("LastNGames", "0");
		vars.put("AheadBehind", "");
		vars.put("ContextMeasure", "FGM");
		vars.put("ClutchTime", "");
		vars.put("RookieYear", "");

		return dataUtil.getObjects(endpoint, vars, Shotchart.class);
	}

}
