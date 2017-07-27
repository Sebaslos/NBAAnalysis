package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.ResultSet;
import model.Team;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.TeamService;
import util.RESTUtil;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

	RESTUtil restUtil = new RESTUtil();

	TeamService teamService = new TeamService();

	@RequestMapping(value = "/all", produces = "application/json")
	public String getTeamList() {
		List<Team> teamList = teamService.findAll();
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
		return gson.toJson(teamList);
	}

	@RequestMapping("/3ptrend")
	public ResultSet team3point(@RequestParam("teamName") String teamName, @RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		String name = "Team3PointShotTrend";
		String[] headers = {"month", "date", "3PA", "FGA"};

		TeamService teamService = new TeamService();
		List<Object[]> rows = teamService.get3PointShotTrend(teamName, season, seasonType);

		ResultSet resultSet = restUtil.buildResultSet(name, headers, rows);
		restUtil.convertMonthAndSort(resultSet, 0);
		return resultSet;
	}

	@RequestMapping("/3pzone")
	public ResultSet team3pointshotzone(@RequestParam("teamName") String teamName, @RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		String name = "Team3PointShotZone";
		String[] headers = {"zone", "3PM", "3PA", "3P%"};

		TeamService teamService = new TeamService();
		List<Object[]> rows = teamService.get3PointShotZone(teamName, season, seasonType);

		return restUtil.buildResultSet(name, headers, rows);
	}

}
