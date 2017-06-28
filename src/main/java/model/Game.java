package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Game {

	@Id
	private Long id;

	@Column(nullable = false)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "season_id")
	private Season season;

	@ManyToOne
	@JoinColumn(name = "htm_id")
	private Team htm;

	@ManyToOne
	@JoinColumn(name = "vtm_id")
	private Team vtm;

	@Column
	private int htmPoints;

	@Column
	private int vtmPoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Team getHtm() {
		return htm;
	}

	public void setHtm(Team htm) {
		this.htm = htm;
	}

	public Team getVtm() {
		return vtm;
	}

	public void setVtm(Team vtm) {
		this.vtm = vtm;
	}

	public int getHtmPoints() {
		return htmPoints;
	}

	public void setHtmPoints(int htmPoints) {
		this.htmPoints = htmPoints;
	}

	public int getVtmPoints() {
		return vtmPoints;
	}

	public void setVtmPoints(int vtmPoints) {
		this.vtmPoints = vtmPoints;
	}
}
