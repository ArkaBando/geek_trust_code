package in.geektrust.intergalactic_cricket_game.domain;

import in.geektrust.intergalactic_cricket_game.simulator.GameSimulatorContext;

/**
 * I have not bowler as a single entity as not required in the problem
 * @author arka
 *
 */
public class BallingOver {
	private int remainingOver;
	private int remainingBalls;
	private int initialOverCount;
	private Team ballingTeam;
	
	public BallingOver(int remainingOver, Team bowlingTeam) {
		super();
		this.initialOverCount = remainingOver;
		this.remainingOver = remainingOver;
		this.ballingTeam = bowlingTeam;
		this.remainingBalls = 6 * remainingOver;
	}

	public int getRemainingOver() {
		return remainingOver;
	}

	public Team getBowlingTeam() {
		return ballingTeam;
	}
	
	public BallingOver nextBall(GameSimulatorContext gameContext){		
		if(remainingBalls%6 == 0){
			//log error message from gameContext
		}
		BallingOver ballingOver = gameContext.nextBall();
		return ballingOver;
	}

	public void setRemainingOver(int remainingOver) {
		this.remainingOver = remainingOver;
	}

	public void setRemainingBalls(int remainingBalls) {
		if(remainingBalls > this.remainingBalls){
			throw new IllegalArgumentException("Remaining Balls count Must always be lesser than previous balls count");
		}
		this.remainingBalls = remainingBalls;
	}

	public void setBallingTeam(Team ballingTeam) {
		this.ballingTeam = ballingTeam;
	}

	public int getRemainingBalls() {
		return remainingBalls;
	}

	public int getInitialOverCount() {
		return initialOverCount;
	}

	public Team getBallingTeam() {
		return ballingTeam;
	}
	
}
