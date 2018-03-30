package in.geektrust.twoPlanets.controller;

import in.geektrust.twoPlanets.dto.ArmyDTO;

public class ArmyControls extends BaseCommandController {

	public static final String INITIALIZE_ATTACKING_PLANET = "INITIALIZE_ATTACKING_PLANET";
	public static final String PREPARE_DEFENCE_ARMY = "PREPARE_DEFENCE_ARMY";
		
	@Override
	public void execute(String command) {
		
		switch(command){
		case INITIALIZE_ATTACKING_PLANET : 
			
			String inputString = "Falicornia attacks with 100 H, 101 E, 20 AT, 5 SG ";
			ArmyDTO armyForAttackDTO = new ArmyDTO();
			String planetName = "Falicornia";
			String planetKing = "Al Falcone";
			
			armyForAttackDTO.setPlanetKingName(planetKing);
			armyForAttackDTO.setPlanetName(planetName);
			armyForAttackDTO.generateWeapons(inputString);
			armyForAttack = armyForAttackDTO.toArmy();
			break;
			
		case PREPARE_DEFENCE_ARMY :
			//prepare army using chain of responsibiility design pattern
			break;
		default :
			break;
		}

	}

	@Override
	public boolean canHandle(String command) {
	
		if(command.equals(INITIALIZE_ATTACKING_PLANET) || command.equals(PREPARE_DEFENCE_ARMY)){
			return true;
		}
		return false;
	}

}
