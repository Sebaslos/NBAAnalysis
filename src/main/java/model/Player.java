package model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Player {

	@Id
	@Expose
	private Long id;

	@Column(nullable = false)
	@Expose
	private String name;

	@Column(nullable = false)
	private String firstPosition;

	@Column
	private String secondPosition = null;

	private Date birthdate;

	private String height;

	private int weight;

	private String school;

	private String country;

	private int seasonExp;

	private int fromYear;

	private int toYear;

	private int draftYear;

	private int draftRound;

	private int draftNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstPosition() {
		return firstPosition;
	}

	public void setFirstPosition(String firstPosition) {
		this.firstPosition = firstPosition;
	}

	public String getSecondPosition() {
		return secondPosition;
	}

	public void setSecondPosition(String secondPosition) {
		this.secondPosition = secondPosition;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSeasonExp() {
		return seasonExp;
	}

	public void setSeasonExp(int seasonExp) {
		this.seasonExp = seasonExp;
	}

	public int getFromYear() {
		return fromYear;
	}

	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}

	public int getToYear() {
		return toYear;
	}

	public void setToYear(int toYear) {
		this.toYear = toYear;
	}

	public int getDraftYear() {
		return draftYear;
	}

	public void setDraftYear(int draftYear) {
		this.draftYear = draftYear;
	}

	public int getDraftRound() {
		return draftRound;
	}

	public void setDraftRound(int draftRound) {
		this.draftRound = draftRound;
	}

	public int getDraftNumber() {
		return draftNumber;
	}

	public void setDraftNumber(int draftNumber) {
		this.draftNumber = draftNumber;
	}
}
