package in.geektrust.twoPlanets.rules;

import in.geektrust.twoPlanets.domain.Army;

public abstract class BaseRule {
	
	protected Army exsistingFirstArmy;
	protected Army exsistingSecondArmy;

	public Army getExsitingFirstArmy() {
		return exsistingFirstArmy;
	}

	public void setExsitingFirstArmy(Army exsitingArmy) {
		this.exsistingFirstArmy = exsitingArmy;
	}
	
	protected abstract void setNextRule(BaseRule nextRule);
	
	protected abstract Army applyRule(Army firstArmy,Army secondArmy);

	public Army getExsistingFirstArmy() {
		return exsistingFirstArmy;
	}

	public void setExsistingFirstArmy(Army exsistingFirstArmy) {
		this.exsistingFirstArmy = exsistingFirstArmy;
	}

	public Army getExsistingSecondArmy() {
		return exsistingSecondArmy;
	}

	public void setExsistingSecondArmy(Army exsistingSecondArmy) {
		this.exsistingSecondArmy = exsistingSecondArmy;
	}
	
}
