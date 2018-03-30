package in.geektrust.twoPlanets.rules;

import in.geektrust.twoPlanets.domain.Army;
import in.geektrust.twoPlanets.domain.Weapon;

import java.util.List;

/**
 * here first army refers to Falicorno and 2nd army lengaburu
 * @author arka
 *
 */
public class PowerRule extends BaseRule {

	private BaseRule nextRule;
	
	@Override
	protected void setNextRule(BaseRule nextRule) {
		this.nextRule = nextRule;
	}

	@Override
	protected Army applyRule(Army firstArmy,Army secondArmy) {
		
		boolean isPowerRuleValid = true;

		isPowerRuleValid = validatePowerRule(isPowerRuleValid);
		
		if(isPowerRuleValid){
			nextRule.applyRule(firstArmy,secondArmy);
		} else {
			throw new IllegalStateException("Power Rule is not valid for given armies");
		}
		return firstArmy;
	}

	private boolean validatePowerRule(boolean IsPowerRuleValid) {
		List<Weapon> firstArmyWeapons = exsistingFirstArmy.getWeapons();
		List<Weapon> secondArmyWeapons = exsistingSecondArmy.getWeapons();
		
		for(int i = 0;i<firstArmyWeapons.size();i++){
			Weapon firstArmyWeapon = firstArmyWeapons.get(i);
			Weapon secondArmyWeapon = secondArmyWeapons.get(i);
			
			if(!(secondArmyWeapon.getWeaponAmount() * 2 == firstArmyWeapon.getWeaponAmount())){
				IsPowerRuleValid = true;
				break;
			}
		}
		return IsPowerRuleValid;
	}

}
