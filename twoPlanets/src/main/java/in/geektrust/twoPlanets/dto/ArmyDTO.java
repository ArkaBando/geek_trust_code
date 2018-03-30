package in.geektrust.twoPlanets.dto;

import in.geektrust.twoPlanets.domain.Army;
import in.geektrust.twoPlanets.domain.Weapon;
import in.geektrust.twoPlanets.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArmyDTO {
	
	private List<Weapon> weapons;
	private String planetName;
	private String planetKingName;
	
	protected static final ValidationUtils validator = ValidationUtils.getValidator();
	
	
	public static enum WeaponNameShortCodeMapping{
		HORSES("H"),ELEPHANT("E"), ARMOURED_TANKS("AT"),SLINGGUNS("SG");
		
		private final String shortCode;
		
		private WeaponNameShortCodeMapping(String code){
			shortCode = code;
		}

		public String getShortCode() {
			return shortCode;
		}
		
		public static String getName(String code){
			String name = null;
			
			switch(code){
			case "H" : name = WeaponNameShortCodeMapping.HORSES.name(); break;
			case "E" : name = WeaponNameShortCodeMapping.ELEPHANT.name(); break;
			case "AT" : name = WeaponNameShortCodeMapping.ARMOURED_TANKS.name(); break;
			case "SG" : name = WeaponNameShortCodeMapping.SLINGGUNS.name(); break;
			}
			
			return name;
		}
	};
	
	public List<Weapon> generateWeapons(String stringContainingWeapons){
		StringTokenizer st = new StringTokenizer(stringContainingWeapons,",");
		
		weapons = new ArrayList<Weapon>();
		
		while(st.hasMoreTokens()){
			String tokenizedValue = st.nextToken().trim().toUpperCase();
			String code = tokenizedValue.substring(tokenizedValue.length()-3);
			
			if(WeaponNameShortCodeMapping.getName(code.trim().toUpperCase()) != null){
				String shortCode = code.trim().toUpperCase();
				tokenizedValue = tokenizedValue.replaceAll("^[0-9]+"," ");
				int weaponAmount = Integer.parseInt(tokenizedValue.trim());
				weapons.add(new Weapon(shortCode, weaponAmount));
			}
		}
		
		return weapons;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public String getPlanetKingName() {
		return planetKingName;
	}

	public void setPlanetKingName(String planetKingName) {
		this.planetKingName = planetKingName;
	}
	
	/**
	 * to convert army dto to army
	 * @return
	 */
	public Army toArmy(){
		
		validator.validateArgument(planetName, "planetName is invalid");
		validator.validateArgument(planetKingName, "planetKingName is invalid");
		validator.validateArgument(weapons, "Weapons is not defined");
		
		Army army = new Army(planetName,planetKingName,weapons);
		
		return army;
	}
}
