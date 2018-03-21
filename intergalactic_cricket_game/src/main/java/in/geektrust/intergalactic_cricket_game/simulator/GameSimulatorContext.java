package in.geektrust.intergalactic_cricket_game.simulator;

import in.geektrust.intergalactic_cricket_game.CricketRule;
import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;
import in.geektrust.intergalactic_cricket_game.domain.Run;
import in.geektrust.intergalactic_cricket_game.util.DefaultRandomNumberGenerator;
import in.geektrust.intergalactic_cricket_game.util.ScoreCalculator;

/**
 * This call only contains contextual information about the game like scoring run and batsmen playing
 * @author arka
 *
 */
public abstract class GameSimulatorContext implements BaseCricketGameSimulator , CricketRule{
	
	protected BallingOver ballingOver;
	protected Batsmen batsmenOnStrike;
	protected Batsmen batsmenOffStrike;
	private ScoreCalculator scroreCalculator;
	protected static Run run;
	protected int netRunRequiredForWinning = 40;
	
	public GameSimulatorContext(BallingOver ballingOver,
			Batsmen batsmenOnStrike, Batsmen batsmenOffStrike) {
		super();
		this.ballingOver = ballingOver;
		this.batsmenOnStrike = batsmenOnStrike;
		this.batsmenOffStrike = batsmenOffStrike;
		scroreCalculator = new ScoreCalculator(new DefaultRandomNumberGenerator(allocatedScoreList,
				batsmenOnStrike.getScoringProbability()));
		run = new Run(0, netRunRequiredForWinning, netRunRequiredForWinning);
	}

	@Override
	public BallingOver nextBall() {
		applyConstraintBeforeBalling();
		int remainingBalls = ballingOver.getRemainingBalls();
		remainingBalls -= 1;
		ballingOver.setRemainingBalls(remainingBalls);
		ballingOver.setRemainingOver(remainingBalls/6);
		applyConstraintAfterBalling();
		return ballingOver;
	}

	@Override
	public Run nextRun() {
		applyConstraintBeforeTakingRun();
		int totalRunScored = run.getTotalRunScored();
		int currentScore = scroreCalculator.calculateScore();
		run.setCurrentlyScoredRun(currentScore);
		if(currentScore > 0){
		totalRunScored += currentScore;
		run.setTotalRunScored(totalRunScored);
		int requiredRun = run.getRequiredRun(); 
		run.setRequiredRun(requiredRun-currentScore);
		}
		applyConstraintAfterTakingRun();

		return run;
	}

	
}
