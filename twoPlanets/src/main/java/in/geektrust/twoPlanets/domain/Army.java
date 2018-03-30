package in.geektrust.twoPlanets.domain;

import java.util.ArrayList;
import java.util.List;


public class Army extends Planet{

	private List<Weapon> weapons;
	
	public Army(String planetName, String planetKing) {
		super(planetName, planetKing);
		weapons = new ArrayList<Weapon>();
	}
	
	public Army(String planetName, String planetKing,List<Weapon> weapons){
		super(planetName, planetKing);
		validator.validateArgument(weapons, "invalid weapons");
		this.weapons = weapons;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		validator.validateArgument(weapons,"invalid weapons");
	
		this.weapons = weapons;
	}

	public void addWeapon(Weapon weapon){
		validateWeapon(weapon);
		this.weapons.add(weapon);
	}

	public static void validateWeapon(Weapon weapon) {
		validator.validateArgument(weapon, "weapon to be added is invalid");
		validator.validateArgumentByCondition(weapon,
				weapon.getWeaponAmount()<0 && 
				null == weapon.getWeaponName() && 
				weapon.getWeaponName().isEmpty(),
				"Weapon name or amount is undefined");
	}
	
}
