package in.geektrust.intergalactic_cricket_game.util;

import in.geektrust.intergalactic_cricket_game.domain.Run;


public class ScoreCalculator {
	private RandomNumberGenerator randomNumberGenerator;
	
	
	
	public ScoreCalculator(RandomNumberGenerator randomNumberGenerator){
		this.randomNumberGenerator = randomNumberGenerator;
		
	}
	
	public Integer calculateScore(){
		return randomNumberGenerator.generateWeightBasedRandomNumber();
	}

	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}
	
	
}
