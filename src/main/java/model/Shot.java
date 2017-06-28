package model;

import javax.persistence.*;

@Entity
@Table
public class Shot {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private ShotType shotType;

	@ManyToOne
	@JoinColumn(name = "zone_id")
	private ShotZone shotZone;

	@Column(nullable = false)
	private int posX;

	@Column(nullable = false)
	private int posY;

	@Column(nullable = false)
	private int distance;

	@Column(nullable = false)
	private String time;

	@Column(nullable = false)
	private boolean isMade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ShotType getShotType() {
		return shotType;
	}

	public void setShotType(ShotType shotType) {
		this.shotType = shotType;
	}

	public ShotZone getShotZone() {
		return shotZone;
	}

	public void setShotZone(ShotZone shotZone) {
		this.shotZone = shotZone;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isMade() {
		return isMade;
	}

	public void setMade(boolean made) {
		isMade = made;
	}
}
