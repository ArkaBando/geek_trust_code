package in.geektrust.twoPlanets.controller;

import in.geektrust.twoPlanets.domain.Army;

public abstract class BaseCommandController {
	protected Army armyForDefence;
	protected Army armyForAttack;
	
	protected Army firstPlanetExsistingArmy;
	protected Army secondPlanentExsistingArmy;
	
	public abstract void execute(String command);
	public abstract boolean canHandle(String command);
	
	public Army getArmyForDefence() {
		return armyForDefence;
	}
	public void setArmyForDefence(Army armyForDefence) {
		this.armyForDefence = armyForDefence;
	}
	public Army getArmyForAttack() {
		return armyForAttack;
	}
	public void setArmyForAttack(Army armyForAttack) {
		this.armyForAttack = armyForAttack;
	}
	public Army getFirstPlanetExsistingArmy() {
		return firstPlanetExsistingArmy;
	}
	public void setFirstPlanetExsistingArmy(Army firstPlanetExsistingArmy) {
		this.firstPlanetExsistingArmy = firstPlanetExsistingArmy;
	}
	public Army getSecondPlanentExsistingArmy() {
		return secondPlanentExsistingArmy;
	}
	public void setSecondPlanentExsistingArmy(Army secondPlanentExsistingArmy) {
		this.secondPlanentExsistingArmy = secondPlanentExsistingArmy;
	}
	
	
}
