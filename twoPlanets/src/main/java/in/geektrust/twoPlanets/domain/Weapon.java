package in.geektrust.twoPlanets.domain;

import in.geektrust.twoPlanets.utils.ValidationUtils;

public class Weapon {

	private String weaponName;
	private int weaponAmount;
	private boolean isWeaponCountExahausted = false;
	private int remainingExahaustedWeaponAmount = 0;
	private int maximumUnitOfWeaponAvailable;
	
	private static ValidationUtils validator = ValidationUtils.getValidator();
	
	public Weapon(String weaponName, int weaponAmount) {
		super();
		
		validator.validateArgument(weaponName,"weaponName is invalid");
		validator.validateArgument(weaponAmount,"weaponAmount is invalid");
		
		this.weaponName = weaponName;
		this.weaponAmount = weaponAmount;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public int getWeaponAmount() {
		return weaponAmount;
	}	
	
	public void addWeaponAmount(int weaponAmount){
		validator.validateArgument(weaponAmount,"weaponAmount is invalid");
		
		if(weaponAmount <= maximumUnitOfWeaponAvailable){
		this.weaponAmount += weaponAmount;
		} else {
			this.remainingExahaustedWeaponAmount = 
					(this.weaponAmount+weaponAmount)-maximumUnitOfWeaponAvailable;
			this.isWeaponCountExahausted = true;
			this.weaponAmount = maximumUnitOfWeaponAvailable;
			
		}
	}
	
	public void useWeapon(int weaponAmount){
		validator.validateArgument(weaponAmount,"weaponAmount is invalid");
	
		if(this.weaponAmount-weaponAmount>0){
			this.weaponAmount -= weaponAmount;
		}
		
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public void setWeaponAmount(int weaponAmount) {
		this.weaponAmount = weaponAmount;
	}

	public boolean isWeaponCountExahausted() {
		return isWeaponCountExahausted;
	}

	public void setWeaponCountExahausted(boolean isWeaponCountExahausted) {
		this.isWeaponCountExahausted = isWeaponCountExahausted;
	}

	public int getRemainingExahaustedWeaponAmount() {
		return remainingExahaustedWeaponAmount;
	}

	public void setRemainingExahaustedWeaponAmount(
			int remainingExahaustedWeaponAmount) {
		this.remainingExahaustedWeaponAmount = remainingExahaustedWeaponAmount;
	}

	public int getMaximumUnitOfWeapon() {
		return maximumUnitOfWeaponAvailable;
	}

	public void setMaximumUnitOfWeapon(int maximumUnitOfWeapon) {
		this.maximumUnitOfWeaponAvailable = maximumUnitOfWeapon;
	}

	
}
