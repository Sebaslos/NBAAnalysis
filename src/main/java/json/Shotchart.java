package json;


import com.google.gson.annotations.SerializedName;

public class Shotchart {

	@SerializedName("GAME_ID")
	private String gameId;

	@SerializedName("GAME_EVENT_ID")
	private String gameEventId;

	@SerializedName("PLAYER_ID")
	private String playerId;

	@SerializedName("PLAYER_NAME")
	private String playerName;

	@SerializedName("TEAM_ID")
	private String teamId;

	@SerializedName("TEAM_NAME")
	private String teamName;

	@SerializedName("PERIOD")
	private int period;

	@SerializedName("MINUTES_REMAINING")
	private int remainMinutes;

	@SerializedName("SECONDS_REMAINING")
	private int remainSeconds;

	@SerializedName("ACTION_TYPE")
	private String shotType;

	@SerializedName("SHOT_ZONE_BASIC")
	private String shotZoneBasic;

	@SerializedName("SHOT_ZONE_AREA")
	private String shotZoneArea;

	@SerializedName("SHOT_ZONE_RANGE")
	private String shotZoneRange;

	@SerializedName("SHOT_DISTANCE")
	private int distance;

	@SerializedName("LOC_X")
	private int locX;

	@SerializedName("LOC_Y")
	private int locY;

	@SerializedName("SHOT_MADE_FLAG")
	private int shotMadeFlag;

	@SerializedName("GAME_DATE")
	private String gameDate;

	@SerializedName("HTM")
	private String htm;

	@SerializedName("VTM")
	private String vtm;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameEventId() {
		return gameEventId;
	}

	public void setGameEventId(String gameEventId) {
		this.gameEventId = gameEventId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getRemainMinutes() {
		return remainMinutes;
	}

	public void setRemainMinutes(int remainMinutes) {
		this.remainMinutes = remainMinutes;
	}

	public int getRemainSeconds() {
		return remainSeconds;
	}

	public void setRemainSeconds(int remainSeconds) {
		this.remainSeconds = remainSeconds;
	}

	public String getShotType() {
		return shotType;
	}

	public void setShotType(String shotType) {
		this.shotType = shotType;
	}

	public String getShotZoneBasic() {
		return shotZoneBasic;
	}

	public void setShotZoneBasic(String shotZoneBasic) {
		this.shotZoneBasic = shotZoneBasic;
	}

	public String getShotZoneArea() {
		return shotZoneArea;
	}

	public void setShotZoneArea(String shotZoneArea) {
		this.shotZoneArea = shotZoneArea;
	}

	public String getShotZoneRange() {
		return shotZoneRange;
	}

	public void setShotZoneRange(String shotZoneRange) {
		this.shotZoneRange = shotZoneRange;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public int getShotMadeFlag() {
		return shotMadeFlag;
	}

	public void setShotMadeFlag(int shotMadeFlag) {
		this.shotMadeFlag = shotMadeFlag;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getHtm() {
		return htm;
	}

	public void setHtm(String htm) {
		this.htm = htm;
	}

	public String getVtm() {
		return vtm;
	}

	public void setVtm(String vtm) {
		this.vtm = vtm;
	}

	@Override
	public String toString() {
		return "Shotchart{" +
				"gameId='" + gameId + '\'' +
				", playerId='" + playerId + '\'' +
				", playerName='" + playerName + '\'' +
				", teamId='" + teamId + '\'' +
				", teamName='" + teamName + '\'' +
				", period=" + period +
				", remainMinutes=" + remainMinutes +
				", remainSeconds=" + remainSeconds +
				", shotType='" + shotType + '\'' +
				", shotZoneBasic='" + shotZoneBasic + '\'' +
				", shotZoneArea='" + shotZoneArea + '\'' +
				", shotZoneRange='" + shotZoneRange + '\'' +
				", distance=" + distance +
				", locX=" + locX +
				", locY=" + locY +
				", shotMadeFlag=" + shotMadeFlag +
				", gameDate='" + gameDate + '\'' +
				", htm='" + htm + '\'' +
				", vtm='" + vtm + '\'' +
				'}';
	}
}
