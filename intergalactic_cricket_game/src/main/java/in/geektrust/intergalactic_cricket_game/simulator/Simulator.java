package in.geektrust.intergalactic_cricket_game.simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;
import in.geektrust.intergalactic_cricket_game.domain.Run;

/**
 * On demand constraint has been added to Simulator while batting and balling
 * 
 * @author arka
 *
 */
public class Simulator extends GameSimulatorContext {
	// can be delegated to other services but for simplicity I have kept here
	HashMap<String, Batsmen> batsmenRunsSummary = new HashMap<String, Batsmen>();
	List<Batsmen> batsmenList;
	int noOfOutBatsmen = 0;

	public Simulator(BallingOver ballingOver, List<Batsmen> batsmenList,
			int netRunRequired) {
		super(ballingOver, batsmenList.get(0), batsmenList.get(1));
		this.batsmenList = batsmenList;
		this.netRunRequiredForWinning = netRunRequired;
	}

	@Override
	public boolean isMatchWon() {
		if (run.getNetRunRequiredForWinning() < 0
				|| run.getTotalRunScored() > run.getNetRunRequiredForWinning()) {
			return true;
		} else if (run.getNetRunRequiredForWinning() == 0) {
			// tie
			return false;
		}
		return false;
	}

	public void play() {
		BallingOver ball = ballingOver;
		Run currentRun = run;
		do {
			ball = ball.nextBall(this);
			currentRun = currentRun.nextRun(this);
			if (isMatchWon()) {
				return;
			}
		} while (ball.getRemainingBalls() != 0);

		if (!isMatchWon()) {
			processMatchLoss();
		}
	}

	private void processMatchLoss() {
		System.out.printf(enchaiWinningMessage, run.getRequiredRun());
		System.exit(0);
	}

	/**
	 * Batsmen change strike end of every over. They also change strike when
	 * they score a 1,3 or 5
	 */
	@Override
	public void applyConstraintAfterTakingRun() {
		int balltaken = batsmenOnStrike.getBallTaken() + 1;
		String currentOver = ballingOver.getInitialOverCount()
				- (ballingOver.getRemainingOver() + 1) + "."
				+ (6 - ballingOver.getRemainingBalls() % 6);
		batsmenOnStrike.setBallTaken(balltaken);

		if (run.getCurrentlyScoredRun() >= 0) {
			processRun(currentOver);
		} else {
			processOutBatsmen(currentOver);
		}

		if (isMatchWon()) {
			processWin();
			System.exit(0);
		}

	}

	private void processRun(String currentOver) {
		batsmenOnStrike.setTotalRun(batsmenOnStrike.getTotalRun()
				+ run.getCurrentlyScoredRun());
		batsmenRunsSummary
				.put(batsmenOnStrike.getPlayerName(), batsmenOnStrike);

		System.out.println(String.format(currentPlayerStatus, currentOver,
				batsmenOnStrike.getPlayerName(), run.getCurrentlyScoredRun()));
		if (run.getCurrentlyScoredRun() == 1
				|| run.getCurrentlyScoredRun() == 3
				|| run.getCurrentlyScoredRun() == 5) {

			Batsmen temp = batsmenOnStrike;
			batsmenOnStrike = batsmenOffStrike;
			batsmenOffStrike = temp;
		}
		if (ballingOver.getRemainingBalls() % 6 == 0) {
			Batsmen temp = batsmenOnStrike;
			batsmenOnStrike = batsmenOffStrike;
			batsmenOffStrike = temp;
		}
	}

	private void processOutBatsmen(String currentOver) {
		// out
		batsmenRunsSummary
				.put(batsmenOnStrike.getPlayerName(), batsmenOnStrike);
		System.out.println(String.format(outPlayerStatus, currentOver,
				batsmenOnStrike.getPlayerName()));
		if (noOfOutBatsmen < (batsmenList.size() - 2)) {

			batsmenOnStrike = batsmenList.get(noOfOutBatsmen + 2);
		} else if (!isMatchWon()) {
			processMatchLoss();
		}
		noOfOutBatsmen += 1;
	}

	@Override
	public void applyConstraintBeforeTakingRun() {
		// TODO Auto-generated method stub
	}

	@Override
	public void applyConstraintBeforeBalling() {
		// TODO Auto-generated method stub
		if (ballingOver.getRemainingBalls() % 6 == 0) {
			System.out.println(String.format(overStatus,
					ballingOver.getRemainingBalls() / 6, run.getRequiredRun()));
		}
	}

	@Override
	public void applyConstraintAfterBalling() {
		// TODO Auto-generated method stub

	}

	private void processWin() {
		int remaingBalls = ballingOver.getRemainingBalls();
		int wicketInHand = 2 - noOfOutBatsmen;
		// batsmenList
		List<String> alreadyVisitedBatsmen = new ArrayList<String>();
		System.out.printf(winningMessage, wicketInHand, remaingBalls);
		for (Entry<String, Batsmen> entry : batsmenRunsSummary.entrySet()) {
			if (entry.getValue().getPlayerName()
					.equalsIgnoreCase(batsmenOnStrike.getPlayerName())
					|| entry.getValue().getPlayerName()
							.equalsIgnoreCase(batsmenOffStrike.getPlayerName())) {
				System.out.printf(playerStatus, entry.getValue()
						.getPlayerName(), entry.getValue().getTotalRun() + "*",
						entry.getValue().getBallTaken());
			} else {
				System.out.printf(playerStatus, entry.getValue()
						.getPlayerName(), entry.getValue().getTotalRun() + "",
						entry.getValue().getBallTaken());
			}
			alreadyVisitedBatsmen.add(entry.getValue().getPlayerName());
		}

		for (Batsmen batsmen : batsmenList) {
			if (!alreadyVisitedBatsmen.contains(batsmen.getPlayerName())) {
				System.out.printf(playerStatus, batsmen.getPlayerName(),
						batsmen.getTotalRun() + "", batsmen.getBallTaken());
			}
		}
	}

}
