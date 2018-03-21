package in.geektrust.intergalactic_cricket_game.domain;

public class Batsmen extends Player{
	
	private int totalRun;
	private int ballTaken;
	
	
	public Batsmen(String playerName, Team team,
			PlayerScoreProbability playerScoreProbility) {
		super(playerName,team,playerScoreProbility);
		this.totalRun = 0;
		this.ballTaken = 0;
	}

	public int getTotalRun() {
		return totalRun;
	}
	public void setTotalRun(int totalRun) {
		this.totalRun = totalRun;
	}
	public int getBallTaken() {
		return ballTaken;
	}
	public void setBallTaken(int ballTaken) {
		this.ballTaken = ballTaken;
	}
	
	/*public void changeSide(Batsmen batsmenOnStrike , Batsmen batsmenOffStrike){
		Batsmen temp = batsmenOnStrike;
		batsmenOnStrike = batsmenOffStrike;
		batsmenOffStrike = temp;
	}
*/}
