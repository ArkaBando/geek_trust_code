package in.geektrust.cricket.domain;

import in.geektrust.cricket.domain.Match.TossResult;

public class Team{
	
	private String teamName;
	private String teamDescription;
	private Player [] players;
	private TossResult tossResult;
	
	public Team(String teamName, String teamDescription,Player[] players) {
		super();
		this.teamName = teamName;
		this.teamDescription = teamDescription;
		this.players = players;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamDescription() {
		return teamDescription;
	}
	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}

	public TossResult getTossResult() {
		return tossResult;
	}

	public void setTossResult(TossResult tossResult) {
		this.tossResult = tossResult;
	}
	
	
}