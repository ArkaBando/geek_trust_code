package in.geektrust.cricket.domain;

import in.geektrust.intergalactic_cricket_game.util.RandomNumberGenerator;

public class Run implements IRun{

	private int totalRunScored;
	private int noOfBallsPlayed;
	private int lastScore;
	private RandomNumberGenerator runSimulator;
	
	public Run(){
		init();
	}

	private void init() {
		totalRunScored = 0;
		noOfBallsPlayed = 0;
		lastScore = 0;
	}

	
	public Run(RandomNumberGenerator runGenerator){
		init();
		this.runSimulator = runGenerator;
	}
	
	@Override
	public ScoredRun playDelivery(Match context) {
		//to be induced in context
		int runScored = runSimulator.generateWeightBasedRandomNumber();
		
		ScoredRun score = ScoredRun.getScore(runScored);
		this.noOfBallsPlayed += 1;
		
		if(isNotOut(score)){
			this.lastScore = score.getScoreValue();
			this.totalRunScored += this.lastScore; 
		} 
		
		return score;
	}

	private boolean isNotOut(ScoredRun score) {
		return score != ScoredRun.OUT;
	}

	public int getTotalRunScored() {
		return totalRunScored;
	}

	public void setTotalRunScored(int totalRunScored) {
		this.totalRunScored = totalRunScored;
	}

	public int getNoOfBallsPlayed() {
		return noOfBallsPlayed;
	}

	public int getLastScore() {
		return lastScore;
	}
	
}
