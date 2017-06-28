package json;


import com.google.gson.annotations.SerializedName;

public class TeamInfo {

	@SerializedName("TEAM_ID")
	private String teamId;

	@SerializedName("SEASON_YEAR")
	private String seasonYear;

	@SerializedName("TEAM_CITY")
	private String city;

	@SerializedName("TEAM_NAME")
	private String name;

	@SerializedName(value = "TEAM_ABBREVIATION", alternate = "ABBREVIATION")
	private String abbreviation;

	@SerializedName("TEAM_CONFERENCE")
	private String conference;

	@SerializedName("TEAM_DIVISION")
	private String division;

	@SerializedName("TEAM_CODE")
	private String teamcode;

	@SerializedName("W")
	private String win;

	@SerializedName("L")
	private String loss;

	@SerializedName("MIN_YEAR")
	private String minYear;

	@SerializedName("MAX_YEAR")
	private String maxYear;

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getSeasonYear() {
		return seasonYear;
	}

	public void setSeasonYear(String seasonYear) {
		this.seasonYear = seasonYear;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTeamcode() {
		return teamcode;
	}

	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public String getLoss() {
		return loss;
	}

	public void setLoss(String loss) {
		this.loss = loss;
	}

	public String getMinYear() {
		return minYear;
	}

	public void setMinYear(String minYear) {
		this.minYear = minYear;
	}

	public String getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(String maxYear) {
		this.maxYear = maxYear;
	}

	@Override
	public String toString() {
		return "TeamInfo{" +
				"teamId='" + teamId + '\'' +
				", seasonYear='" + seasonYear + '\'' +
				", city='" + city + '\'' +
				", name='" + name + '\'' +
				", abbreviation='" + abbreviation + '\'' +
				", conference='" + conference + '\'' +
				", division='" + division + '\'' +
				", teamcode='" + teamcode + '\'' +
				", win='" + win + '\'' +
				", loss='" + loss + '\'' +
				", minYear='" + minYear + '\'' +
				", maxYear='" + maxYear + '\'' +
				'}';
	}
}
