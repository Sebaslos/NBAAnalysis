package json;


import com.google.gson.annotations.SerializedName;

public class GameLog {

	@SerializedName("SEASON_ID")
	private String seasonId;

	@SerializedName("Player_ID")
	private String playerId;

	@SerializedName("Team_ID")
	private String teamId;

	@SerializedName("Game_ID")
	private String gameId;

	@SerializedName("GAME_DATE")
	private String gameDate;

	@SerializedName("MATCHUP")
	private String matchup;

	@SerializedName("WL")
	private String wl;     // win/loss

	@SerializedName("MIN")
	private String min;       // minutes played

	@SerializedName("PTS")
	private String pts;       // points

	@SerializedName("FGM")
	private String fgm;		// Field Goals Made

	@SerializedName("FGA")
	private String fga;		// Field Goals Attempted

	@SerializedName("FG_PCT")
	private String fgPct;		// Field Goal Percentage

	@SerializedName("FG3M")
	private String fg3m;		// 3 Point Field Goals Made

	@SerializedName("FG3A")
	private String fg3a;		// 3 Point Field Goals Attempted

	@SerializedName("FG3_PCT")
	private String fg3Pct;		// 3 Point Field Goals Percentage

	@SerializedName("FTM")
	private String ftm;		// Free Throws Made

	@SerializedName("FTA")
	private String fta;		// Free Throws Attempted

	@SerializedName("FT_PCT")
	private String ftPct;		// Free Throw Percentage

	@SerializedName("OREB")
	private String oreb;		// Offensive Rebounds

	@SerializedName("DREB")
	private String dreb;		// Defensive Rebounds

	@SerializedName("REB")
	private String reb;		// Rebounds

	@SerializedName("AST")
	private String ast;		// Assists

	@SerializedName("STL")
	private String stl;		// Steals

	@SerializedName("BLK")
	private String blk;		// Blocks

	@SerializedName("TOV")
	private String tov;		// Turnovers

	@SerializedName("PF")
	private String pf;		// Personal Fouls

	@SerializedName("PLUS_MINUS")
	private String plus_minus;		// Plus-Minus

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getMatchup() {
		return matchup;
	}

	public void setMatchup(String matchup) {
		this.matchup = matchup;
	}

	public String getWl() {
		return wl;
	}

	public void setWl(String wl) {
		this.wl = wl;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getPts() {
		return pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	public String getFgm() {
		return fgm;
	}

	public void setFgm(String fgm) {
		this.fgm = fgm;
	}

	public String getFga() {
		return fga;
	}

	public void setFga(String fga) {
		this.fga = fga;
	}

	public String getFgPct() {
		return fgPct;
	}

	public void setFgPct(String fgPct) {
		this.fgPct = fgPct;
	}

	public String getFg3m() {
		return fg3m;
	}

	public void setFg3m(String fg3m) {
		this.fg3m = fg3m;
	}

	public String getFg3a() {
		return fg3a;
	}

	public void setFg3a(String fg3a) {
		this.fg3a = fg3a;
	}

	public String getFg3Pct() {
		return fg3Pct;
	}

	public void setFg3Pct(String fg3Pct) {
		this.fg3Pct = fg3Pct;
	}

	public String getFtm() {
		return ftm;
	}

	public void setFtm(String ftm) {
		this.ftm = ftm;
	}

	public String getFta() {
		return fta;
	}

	public void setFta(String fta) {
		this.fta = fta;
	}

	public String getFtPct() {
		return ftPct;
	}

	public void setFtPct(String ftPct) {
		this.ftPct = ftPct;
	}

	public String getOreb() {
		return oreb;
	}

	public void setOreb(String oreb) {
		this.oreb = oreb;
	}

	public String getDreb() {
		return dreb;
	}

	public void setDreb(String dreb) {
		this.dreb = dreb;
	}

	public String getReb() {
		return reb;
	}

	public void setReb(String reb) {
		this.reb = reb;
	}

	public String getAst() {
		return ast;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	public String getStl() {
		return stl;
	}

	public void setStl(String stl) {
		this.stl = stl;
	}

	public String getBlk() {
		return blk;
	}

	public void setBlk(String blk) {
		this.blk = blk;
	}

	public String getTov() {
		return tov;
	}

	public void setTov(String tov) {
		this.tov = tov;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getPlus_minus() {
		return plus_minus;
	}

	public void setPlus_minus(String plus_minus) {
		this.plus_minus = plus_minus;
	}

	@Override
	public String toString() {
		return "GameLog{" +
				"seasonId='" + seasonId + '\'' +
				", playerId='" + playerId + '\'' +
				", teamId='" + teamId + '\'' +
				", gameId='" + gameId + '\'' +
				", gameDate='" + gameDate + '\'' +
				", matchup='" + matchup + '\'' +
				", wl='" + wl + '\'' +
				", min='" + min + '\'' +
				", pts='" + pts + '\'' +
				", fgm='" + fgm + '\'' +
				", fga='" + fga + '\'' +
				", fgPct='" + fgPct + '\'' +
				", fg3m='" + fg3m + '\'' +
				", fg3a='" + fg3a + '\'' +
				", fg3Pct='" + fg3Pct + '\'' +
				", ftm='" + ftm + '\'' +
				", fta='" + fta + '\'' +
				", ftPct='" + ftPct + '\'' +
				", oreb='" + oreb + '\'' +
				", dreb='" + dreb + '\'' +
				", reb='" + reb + '\'' +
				", ast='" + ast + '\'' +
				", stl='" + stl + '\'' +
				", blk='" + blk + '\'' +
				", tov='" + tov + '\'' +
				", pf='" + pf + '\'' +
				", plus_minus='" + plus_minus + '\'' +
				'}';
	}
}
