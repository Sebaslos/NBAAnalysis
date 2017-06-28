package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.ResultSet;
import model.Player;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.PlayerService;
import util.RESTUtil;

import java.util.List;

@RestController()
@RequestMapping("/player")
public class PlayerController {

	RESTUtil restUtil = new RESTUtil();

	PlayerService playerService = new PlayerService();

	@RequestMapping(value = "/all", produces = "application/json")
	public String getPlayerList() {
		List<Player> playerList = playerService.findAll();
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
		return gson.toJson(playerList);
	}

	@RequestMapping("/shotzone")
	public ResultSet shotzone(@RequestParam("playerName") String playerName, @RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		String name = "playerShotZoneQuote";
		String[] headers = {"zone", "FGM", "FGA", "FG%"};

		List<Object[]> rows = playerService.getZoneShotQuote(playerName, season, seasonType);
		return restUtil.buildResultSet(name, headers, rows);
	}


	@RequestMapping("/shottype")
	public ResultSet shottype(@RequestParam("playerName") String playerName, @RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		String name = "playerShotTypeQuote";
		String[] headers = {"type", "FGM", "FGA", "FG%"};

		List<Object[]> rows = playerService.getTypeShotQuote(playerName, season, seasonType);
		return restUtil.buildResultSet(name, headers, rows);
	}

	@RequestMapping("/shottypeinzone")
	public ResultSet shottypeinzone(@RequestParam("playerName") String playerName, @RequestParam("season") String season, @RequestParam("seasonType") String seasonType) {
		String name = "playerShotTypeInZone";
		String[] headers = {"zone", "type", "FGM", "FGA"};

		List<Object[]> rows = playerService.getTypeShotQuoteInZone(playerName, season, seasonType);
		return restUtil.buildResultSet(name, headers, rows);
	}

}
