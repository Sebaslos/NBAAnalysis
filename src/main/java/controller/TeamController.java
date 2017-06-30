package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Team;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

	TeamService teamService = new TeamService();

	@RequestMapping(value = "/all", produces = "application/json")
	public String getTeamList() {
		List<Team> teamList = teamService.findAll();
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
		return gson.toJson(teamList);
	}

}
