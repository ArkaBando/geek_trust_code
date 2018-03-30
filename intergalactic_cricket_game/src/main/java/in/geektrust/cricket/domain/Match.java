package in.geektrust.cricket.domain;

import java.util.Date;


public class Match {

	private Team teamPlayingFirstInnings;
	private Team teamPlayingSecondInnings;
	private String venue;
	private Date date;
	private String stadium;
	public static enum TossResult{Batting,Bowling};
	
	public Match(Team team1, Team team2) {
		super();
		this.teamPlayingFirstInnings = team1;
		this.teamPlayingSecondInnings = team2;
	}

	public Team getTeam1() {
		return teamPlayingFirstInnings;
	}

	public Team getTeam2() {
		return teamPlayingSecondInnings;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
	public void selectTossWinningTeam(Team inputTeam,TossResult result){
		
		if(inputTeam.getTeamName().equalsIgnoreCase(teamPlayingSecondInnings.getTeamName())){
			
			Team team = teamPlayingFirstInnings;
			teamPlayingFirstInnings = teamPlayingSecondInnings;
			teamPlayingSecondInnings = team;
		}
			
		teamPlayingFirstInnings.setTossResult(result);
		teamPlayingSecondInnings.setTossResult(result==TossResult.Batting?TossResult.Bowling:TossResult.Batting);
	
	}
	
	public void toss(){
		//code for toss
	}
}
