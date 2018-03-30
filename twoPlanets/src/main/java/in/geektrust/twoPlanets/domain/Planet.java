package in.geektrust.twoPlanets.domain;

import in.geektrust.twoPlanets.utils.ValidationUtils;

public abstract class Planet {

	private String name;
	private String kingName;
	protected static final ValidationUtils validator = ValidationUtils.getValidator();
	
	public Planet(String planetName, String planetKing) {
		super();
		
		validator.validateArgument(planetName,"planet name is invalid");
		validator.validateArgument(planetKing,"king  name is invalid");
		
		this.name = planetName;
		this.kingName = planetKing;
	}

	public String getPlanetName() {
		return name;
	}

	public String getPlanetKing() {
		return kingName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kingName == null) ? 0 : kingName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (kingName == null) {
			if (other.kingName != null)
				return false;
		} else if (!kingName.equals(other.kingName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}


	public String getKingName() {
		return kingName;
	}
}
