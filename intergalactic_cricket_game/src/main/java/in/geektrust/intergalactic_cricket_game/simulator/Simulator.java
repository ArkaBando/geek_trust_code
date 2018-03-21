package in.geektrust.intergalactic_cricket_game.simulator;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;

/**
 * On demand constraint has been added to Simulator while batting and balling
 * @author arka
 *
 */
public class Simulator extends GameSimulatorContext {

	public Simulator(BallingOver ballingOver, Batsmen batsmenOnStrike,
			Batsmen batsmenOffStrike) {
		super(ballingOver, batsmenOnStrike, batsmenOffStrike);
		
	}

	@Override
	public boolean isMatchWon() {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void applyConstraintAfterTakingRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyConstraintBeforeTakingRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyConstraintBeforeBalling() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyConstraintAfterBalling() {
		// TODO Auto-generated method stub
		
	}

}
