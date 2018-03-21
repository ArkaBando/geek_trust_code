package in.geektrust.intergalactic_cricket_game.simulator;

import java.util.Arrays;
import java.util.List;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Run;

public interface BaseCricketGameSimulator {
	String winningMessage = "Lengaburu won by %d wicket and %d balls remaining";
	
	String playerStatus = "%s - %s (%d balls)";
	
	List<Integer> allocatedScoreList = (List<Integer>) Arrays.asList(0,1,2,3,4,5,6,-1);
	
	int netRunRequiredForWinning = 40;
	
	public BallingOver nextBall();
	
	public Run nextRun();
	
	public boolean isMatchWon();
	public void applyConstraintAfterTakingRun();
	public void applyConstraintBeforeTakingRun();
	public void applyConstraintBeforeBalling();
	public void applyConstraintAfterBalling();
}
