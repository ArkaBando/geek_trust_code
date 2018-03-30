package in.geektrust.twoPlanets.rules;

import java.util.List;

import in.geektrust.twoPlanets.domain.Army;
import in.geektrust.twoPlanets.domain.Weapon;

public class SubstitutionRule extends BaseRule {

	private BaseRule nextRule;
	
	@Override
	protected void setNextRule(BaseRule nextRule) {
		this.nextRule = nextRule;
	}

	@Override
	protected Army applyRule(Army firstArmy, Army secondArmy) {
		
		List<Weapon> firstArmyWeaponsForAttack = firstArmy.getWeapons();
		List<Weapon> secondArmyWeaponsForDefence = secondArmy.getWeapons();
		
		for(int i = 0;i<firstArmyWeaponsForAttack.size();i++){
			Weapon firstArmyWeaponForAttack = firstArmyWeaponsForAttack.get(i);
			Weapon secondArmyWeaponForDefence = secondArmyWeaponsForDefence.get(i);
			
			if(secondArmyWeaponForDefence.isWeaponCountExahausted()){
				
				if(i==0){
					//for first element order precedence not required
					if(!secondArmyWeaponsForDefence.get(i+1).isWeaponCountExahausted()){
						int remainingWeaponAmount = exsistingSecondArmy.getWeapons().get(i+1).getWeaponAmount()
													-secondArmyWeaponsForDefence.get(i+1).getWeaponAmount();
						if(remainingWeaponAmount*2 > secondArmyWeaponForDefence.getRemainingExahaustedWeaponAmount()){
							
						}
					}
				}
			}
		}
		
		this.nextRule.applyRule(firstArmy, secondArmy);
		return null;
	}

}
