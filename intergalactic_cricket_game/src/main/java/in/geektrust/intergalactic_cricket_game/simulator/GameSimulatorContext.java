package in.geektrust.intergalactic_cricket_game.simulator;

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
public abstract class GameSimulatorContext implements BaseCricketGameSimulator{
	private BallingOver ballingOver;
	protected Batsmen batsmenOnStrike;
	protected Batsmen batsmenOffStrike;
	private ScoreCalculator scroreCalculator;
	protected static Run run;
	
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
		
		totalRunScored += currentScore;
		run.setTotalRunScored(totalRunScored);
		//apply rules
		applyConstraintAfterTakingRun();
		int requiredRun = run.getRequiredRun(); 
		run.setRequiredRun(requiredRun-currentScore);
		// TODO Auto-generated method stub
		return null;
	}

	
}
