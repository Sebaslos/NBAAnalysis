package nbadatautils;


import json.GameLog;
import json.PlayerInfo;
import json.Shotchart;
import json.TeamInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TeamDataUtil {

	private String endpoint;

	private NBADataUtil dataUtil = new NBADataUtil();

	public List<TeamInfo> getTeamList() {
		endpoint = "commonteamyears";

		Map<String, String> vars = new HashMap<>();
		vars.put("LeagueID", "00");

		List<TeamInfo> teamInfos = dataUtil.getObjects(endpoint, vars, TeamInfo.class);

		for (Iterator<TeamInfo> iter = teamInfos.listIterator(); iter.hasNext(); ) {
			TeamInfo teamInfo = iter.next();
			if (teamInfo.getAbbreviation().equals("null")) {
				iter.remove();
			}
		}

		return teamInfos;
	}

	public TeamInfo getTeamInfo(String teamId, String season, String seasonType) {
		endpoint = "teaminfocommon";

		Map<String, String> vars = new HashMap<>();
		vars.put("TeamID", teamId);
		vars.put("LeagueID", "00");
		vars.put("Season", season);
		vars.put("SeasonType", seasonType);

		List<TeamInfo> teamInfos = dataUtil.getObjects(endpoint, vars, TeamInfo.class);

		if (teamInfos.size() > 1 || teamInfos.isEmpty()) {
			throw new RuntimeException("false Team Information");
		}

		return teamInfos.get(0);
	}

	public List<PlayerInfo> getRoster(String teamId, String season) {
		endpoint = "commonteamroster";

		Map<String, String> vars = new HashMap<>();
		vars.put("TeamID", teamId);
		vars.put("Season", season);

		return dataUtil.getObjects(endpoint, vars, PlayerInfo.class);
	}

	public List<GameLog> getTeamGameLogs(String teamId, String season, String seasonType) {
		endpoint = "teamgamelog";

		Map<String, String> vars = new HashMap<>();
		vars.put("TeamID", teamId);
		vars.put("Season", season);
		vars.put("SeasonType", seasonType);

		return dataUtil.getObjects(endpoint, vars, GameLog.class);
	}

	public List<Shotchart> getShotcharts(String teamId, String season, String seasonType) {
		endpoint = "shotchartdetail";

		Map<String, String> vars = new HashMap<>();
		vars.put("PlayerID", "0");
		vars.put("TeamID", teamId);
		vars.put("GameID", "");
		vars.put("LeagueID", "00");
		vars.put("Season", season);
		vars.put("SeasonType", seasonType);
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
