package in.geektrust.intergalactic_cricket_game;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Run;

/**
 * rule specific to cricket 
 * @author arka
 *
 */
public interface CricketRule {
	
	public BallingOver nextBall();
	public Run nextRun();
	
	public boolean isMatchWon();
	public void applyConstraintAfterTakingRun();
	public void applyConstraintBeforeTakingRun();
	public void applyConstraintBeforeBalling();
	public void applyConstraintAfterBalling();
}
