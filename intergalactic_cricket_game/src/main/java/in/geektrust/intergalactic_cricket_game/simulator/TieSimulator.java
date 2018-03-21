package in.geektrust.intergalactic_cricket_game.simulator;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;
import in.geektrust.intergalactic_cricket_game.domain.Run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TieSimulator extends GameSimulatorContext {
	List<Batsmen> batsmenList;
	private boolean IsSimulatorProcessComplete = false;
	HashMap<String, Batsmen> batsmenRunsSummary = new HashMap<String, Batsmen>();
	
	public TieSimulator(BallingOver ballingOver, List<Batsmen> batsmenList) {
		super(ballingOver, batsmenList.get(0), batsmenList.get(1));
		this.batsmenList = batsmenList;
		// TODO Auto-generated constructor stub
	}
	
	public TieSimulator(BallingOver ballingOver, List<Batsmen> batsmenList, int chaseScore) {
		super(ballingOver, batsmenList.get(0), batsmenList.get(1));
		this.batsmenList = batsmenList;
		run.setNetRunRequiredForWinning(chaseScore);
		// TODO Auto-generated constructor stub
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
	
	public Run play(){
		BallingOver ball = ballingOver;
		Run currentRun = run;
		do {
			ball = ball.nextBall(this);
			currentRun = currentRun.nextRun(this);
		} while (ball.getRemainingBalls() != 0 && !IsSimulatorProcessComplete);

		printInningsSummary();
		return run;
	}
	
	private void processMatchLoss() {
		
		System.out.printf(scoringSideWinningMessage,ballingOver.getBallingTeam().name(),run.getRequiredRun());
		//throw new IllegalStateException("Process Complete : "+Team.Lengaburu+" lost");
	}
	
	public void chase(){
		BallingOver ball = ballingOver;
		Run currentRun = run;
		do {
			ball = ball.nextBall(this);
			currentRun = currentRun.nextRun(this);
			if (isMatchWon()) {
				System.out.printf(chaseSideWinningMessage,batsmenList.get(0).getTeam().name(),ball.getRemainingBalls());
				printInningsSummary();
				return;
			}
		} while (ball.getRemainingBalls() != 0 && !IsSimulatorProcessComplete);

		if (!isMatchWon()) {
			processMatchLoss();
			printInningsSummary();
		}
	}

	private void printInningsSummary() {		
		List<String> alreadyVisitedBatsmen = new ArrayList<String>();
		System.out.println("\n\n"+batsmenList.get(0).getTeam().name()+"");
		for (Entry<String, Batsmen> entry : batsmenRunsSummary.entrySet()) {
			if (run.getCurrentlyScoredRun() != -1) {
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

	@Override
	public void applyConstraintAfterTakingRun() {
		int balltaken = batsmenOnStrike.getBallTaken() + 1;
		String currentOver = ballingOver.getInitialOverCount()
				- (ballingOver.getRemainingOver() + 1) + "."
				+ (6 - ballingOver.getRemainingBalls() % 6);
		batsmenOnStrike.setBallTaken(balltaken);
		
		if(run.getCurrentlyScoredRun() == -1){
			System.out.println(String.format(outPlayerStatus, currentOver,
					batsmenOnStrike.getPlayerName())+"! "+batsmenList.get(0).getTeam().name()+" all out");
			IsSimulatorProcessComplete = true;
			return;
		}
		
		batsmenOnStrike.setTotalRun(batsmenOnStrike.getTotalRun()
				+ run.getCurrentlyScoredRun());
		batsmenRunsSummary
				.put(batsmenOnStrike.getPlayerName(), batsmenOnStrike);
		
		System.out.println(String.format(currentPlayerStatus, currentOver,
				batsmenOnStrike.getPlayerName(), run.getCurrentlyScoredRun())+(run.getCurrentlyScoredRun()>1?"s":""));
		if (run.getCurrentlyScoredRun() == 1
				|| run.getCurrentlyScoredRun() == 3
				|| run.getCurrentlyScoredRun() == 5) {

			Batsmen temp = batsmenOnStrike;
			batsmenOnStrike = batsmenOffStrike;
			batsmenOffStrike = temp;
		}
		
		if (ballingOver.getRemainingBalls() % 6 == 0 && ballingOver.getRemainingBalls()>6) {
			Batsmen temp = batsmenOnStrike;
			batsmenOnStrike = batsmenOffStrike;
			batsmenOffStrike = temp;
		}

	}

	@Override
	public void applyConstraintBeforeTakingRun() {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyConstraintBeforeBalling() {
		if (ballingOver.getRemainingBalls() % 6 == 0) {
			System.out.println("\n\n"+batsmenList.get(0).getTeam().name()+" Innings : \n");
		}
	}

	@Override
	public void applyConstraintAfterBalling() {
		// TODO Auto-generated method stub

	}

}
