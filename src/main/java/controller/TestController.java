package controller;

import json.ResultSet;
import json.TeamInfo;
import nbadatautils.TeamDataUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.PlayerService;
import service.TeamService;
import util.Message;
import util.MessageFactory;
import util.RESTUtil;

import java.util.List;

@RestController
public class TestController {

	TeamDataUtil teamDataUtil = new TeamDataUtil();
	RESTUtil util = new RESTUtil();

	@RequestMapping("/")
	public String index() {
		return "hallo, poi";
	}

	@RequestMapping("/teaminfo")
	public TeamInfo teamInfo() {
		return teamDataUtil.getTeamInfo("1610612739", "2014-15", "Regular Season");
	}

	@RequestMapping("/teaminfos")
	public List<TeamInfo> teamInfos() {
		return teamDataUtil.getTeamList();
	}

/*	@RequestMapping("/zonequote")
	public ResultSet zonequote() {
		String name = "PlayerZoneShotQuote";
		String[] headers = {"zone", "FGM", "FGA", "FG%"};

		PlayerService service = new PlayerService();
		List<Object[]> rows = service.getZoneShotQuote();

		ResultSet resultSet = util.buildResultSet(name, headers, rows);

		return resultSet;
	}*/

/*	@RequestMapping("/typequote")
	public ResultSet typequote() {
		String name = "PlayerTypeShotQuote";
		String[] headers = {"type", "FGM", "FGA", "FG%"};

		PlayerService playerService = new PlayerService();
		List<Object[]> rows = playerService.getTypeShotQuote();

		return util.buildResultSet(name, headers, rows);
	}*/

	@RequestMapping("/team3point")
	public ResultSet team3point() {
		String name = "Team3PointShotTrend";
		String[] headers = {"team", "month", "date", "3PA", "FGA"};

		TeamService teamService = new TeamService();
		List<Object[]> rows = teamService.get3PointShotTrend();

		return util.buildResultSet(name, headers, rows);
	}

	@RequestMapping("/team3points")
	public ResultSet team3point(@RequestParam("teamName") String teamName, @RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		String name = "Team3PointShotTrend";
		String[] headers = {"team", "month", "date", "3PA", "FGA"};

		TeamService teamService = new TeamService();
		List<Object[]> rows = teamService.get3PointShotTrend(teamName, season, seasonType);

		return util.buildResultSet(name, headers, rows);
	}

	@RequestMapping(value = "/alldata", method = RequestMethod.POST)
	public ResponseEntity importData(@RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		System.out.println(season + " " +seasonType);
		for (int i = 0; i < 60; i++) {
			Message message = new Message(Message.INFO, "lol " + i + 1);
			System.out.println("message: " + message.getInfo() + " size: " + MessageFactory.size());
			MessageFactory.write(message);
			MessageFactory.writeProcess();
			try {
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MessageFactory.write(new Message(Message.CLOSE));
		System.out.println("message: close");

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
