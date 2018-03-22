package in.geektrust.lengaburu.traffic.domain;



public final class Vehicle {
	
	
	private final Weather[] weather;
	private final String vechileType;
	private final Integer vechileSpeed;
	private final Integer vechilePathHoleTime;

	public Vehicle(Weather[] weather, String vechileType,
			Integer vechileSpeed, Integer vechilePathHoleTime) {
		super();
		this.weather = weather;
		this.vechileType = vechileType;
		this.vechileSpeed = vechileSpeed;
		this.vechilePathHoleTime = vechilePathHoleTime;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public String getVechileType() {
		return vechileType;
	}

	public Integer getVechileSpeed() {
		return vechileSpeed;
	}

	public Integer getVechilePathHoleTime() {
		return vechilePathHoleTime;
	}
	
	
}
