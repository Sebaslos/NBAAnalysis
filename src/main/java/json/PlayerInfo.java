package json;


import com.google.gson.annotations.SerializedName;

public class PlayerInfo {

	@SerializedName(value = "PERSON_ID", alternate = "PLAYER_ID")
	private String personId;

	@SerializedName("FIRST_NAME")
	private String firstName;

	@SerializedName("LAST_NAME")
	private String lastName;

	@SerializedName(value = "DISPLAY_FIRST_LAST", alternate = "PLAYER")
	private String name;

	@SerializedName(value = "BIRTHDATE", alternate = "BIRTH_DATE")
	private String birthdate;

	@SerializedName("AGE")
	private String age;

	@SerializedName("SCHOOL")
	private String school;

	@SerializedName("COUNTRY")
	private String country;

	@SerializedName("HEIGHT")
	private String height;

	@SerializedName("WEIGHT")
	private String weight;

	@SerializedName(value = "SEASON_EXP", alternate = "EXP")
	private String seasonExp;

	@SerializedName(value = "JERSEY", alternate = "NUM")
	private String jersey;

	@SerializedName("POSITION")
	private String position;

	@SerializedName(value = "TEAM_ID", alternate = "TeamID")
	private String teamId;

//	private String team_name;

	@SerializedName("PLAYERCODE")
	private String playercode;

	@SerializedName("FROM_YEAR")
	private String fromYear;

	@SerializedName("TO_YEAR")
	private String toYear;

	@SerializedName("DRAFT_YEAR")
	private String draftYear;

	@SerializedName("DRAFT_ROUND")
	private String draftRound;

	@SerializedName("DRAFT_NUMBER")
	private String draftNumber;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSeasonExp() {
		return seasonExp;
	}

	public void setSeasonExp(String seasonExp) {
		this.seasonExp = seasonExp;
	}

	public String getJersey() {
		return jersey;
	}

	public void setJersey(String jersey) {
		this.jersey = jersey;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPlayercode() {
		return playercode;
	}

	public void setPlayercode(String playercode) {
		this.playercode = playercode;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public String getDraftYear() {
		return draftYear;
	}

	public void setDraftYear(String draftYear) {
		this.draftYear = draftYear;
	}

	public String getDraftRound() {
		return draftRound;
	}

	public void setDraftRound(String draftRound) {
		this.draftRound = draftRound;
	}

	public String getDraftNumber() {
		return draftNumber;
	}

	public void setDraftNumber(String draftNumber) {
		this.draftNumber = draftNumber;
	}

	@Override
	public String toString() {
		return "PlayerInfo{" +
				"personId='" + personId + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", name='" + name + '\'' +
				", birthdate='" + birthdate + '\'' +
				", age='" + age + '\'' +
				", country='" + country + '\'' +
				", height='" + height + '\'' +
				", weight='" + weight + '\'' +
				", jersey='" + jersey + '\'' +
				", position='" + position + '\'' +
				", teamId='" + teamId + '\'' +
				", playercode='" + playercode + '\'' +
				", draftYear='" + draftYear + '\'' +
				", draftRound='" + draftRound + '\'' +
				", draftNumber='" + draftNumber + '\'' +
				'}';
	}
}
