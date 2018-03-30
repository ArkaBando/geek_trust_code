package in.geektrust.twoPlanets.controller;

import in.geektrust.twoPlanets.domain.Army;

import java.util.Iterator;
import java.util.List;

public class WarControls extends BaseCommandController{
	
	public static final String START_NEW_WAR = "START_NEW_WAR";
	public static final String STOP_WAR = "STOP_WAR";
	
	
	private List<BaseCommandController> commandControls;
	
	public WarControls(List<BaseCommandController> commandControls,
			Army firstPlanetArmy, 
			Army secondPlanentArmy){
		
		commandControls.add(this);
		this.commandControls = commandControls;
		this.firstPlanetExsistingArmy = firstPlanetArmy;
		this.secondPlanentExsistingArmy = secondPlanentArmy;
	}
	
	@Override
	public void execute(String command) {
		Iterator<BaseCommandController> commandIterator = this.commandControls.iterator();
		while(commandIterator.hasNext()){
			BaseCommandController commandController = commandIterator.next();
			if(commandController instanceof WarControls){
				switch (command) {
				case WarControls.START_NEW_WAR:
					this.startWar();
					break;
				case WarControls.STOP_WAR:
					System.exit(1);
				}
			}else if(commandController.canHandle(command)){
				commandController.execute(command);
			}
		
		}
	}

	private void startWar() {
		this.execute(ArmyControls.INITIALIZE_ATTACKING_PLANET);
		this.execute(ArmyControls.PREPARE_DEFENCE_ARMY);
	}

	@Override
	public boolean canHandle(String command) {
		
		if(command.equals(START_NEW_WAR) || command.equals(STOP_WAR)){
			return true;
		} else {
			return false;
		}
	}

}
