package in.geektrust.twoPlanets.rules;

import java.util.List;

import in.geektrust.twoPlanets.domain.Army;
import in.geektrust.twoPlanets.domain.Weapon;

public class Like_to_LikeRule extends BaseRule {

	private BaseRule nextRule;
	
	@Override
	protected void setNextRule(BaseRule nextRule) {
		this.nextRule = nextRule;
	}

	@Override
	protected Army applyRule(Army firstArmy,Army secondArmy) {
		
		List<Weapon> firstArmyWeaponsForAttack = firstArmy.getWeapons();
		List<Weapon> secondArmyWeaponsForDefence = secondArmy.getWeapons();
		List<Weapon> secondArmyWeapons = exsistingSecondArmy.getWeapons();
		boolean isDefenceUnitWeaponCountExahausted = false;
		
		for(int i = 0;i<firstArmyWeaponsForAttack.size();i++){
			Weapon firstArmyWeaponForAttack = firstArmyWeaponsForAttack.get(i);
			Weapon secondArmyWeaponForDefence = secondArmyWeaponsForDefence.get(i);
			Weapon secondArmyWeapon = secondArmyWeapons.get(i);
			
			secondArmyWeaponForDefence.setMaximumUnitOfWeapon(secondArmyWeapon.getWeaponAmount());
			int weaponAmount = firstArmyWeaponForAttack.getWeaponAmount()/2+
							   (firstArmyWeaponForAttack.getWeaponAmount()%2*2);
			secondArmyWeaponForDefence.addWeaponAmount(weaponAmount);
			secondArmyWeaponsForDefence.set(i, secondArmyWeaponForDefence);
			
			if(!isDefenceUnitWeaponCountExahausted){
				isDefenceUnitWeaponCountExahausted = secondArmyWeaponForDefence.isWeaponCountExahausted();
				}
			}
		
		if(isDefenceUnitWeaponCountExahausted){
		secondArmy.setWeapons(secondArmyWeaponsForDefence);
		nextRule.applyRule(firstArmy,secondArmy);
		}
		
		return secondArmy;
	}

}
