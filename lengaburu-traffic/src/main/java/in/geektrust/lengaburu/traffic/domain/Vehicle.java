package in.geektrust.lengaburu.traffic.domain;

import java.util.List;


/**
 * 
 * @author arka
 *
 */
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
	
	/**
	 * Checks whether a given vehicle is available for a given Weather
	 * @param inputWeather
	 * @return true given vehicle is available for a given Weather or else false
	 */
	public boolean isVehicleAvailable(Weather inputWeather) {
		Weather currentweather = null;
		for(Weather weather : this.getWeather()){
			if(weather.getWeatherName().trim().equalsIgnoreCase(inputWeather.getWeatherName())){
				currentweather = weather;
				break;
			}
		}
		return (currentweather != null);
	}
	
	/**
	 * 
	 * @param listOfAvailableOrbit
	 * @param inputWeather
	 * @return
	 */
	public Orbit[] fetchOrbitWhichTakesMinimumTimeToTravel(List<Orbit[]> listOfAvailableOrbit,Weather inputWeather){
		Orbit [] orbitTotravel = null;
		
		if(isVehicleAvailable(inputWeather)){
			int minTimeToTravel = Integer.MAX_VALUE;
			for(int i=0;i<listOfAvailableOrbit.size();i++){
				Orbit[] currentOrbits = listOfAvailableOrbit.get(i);
				int travellingTime = 0;
				for(Orbit currentOrbit : currentOrbits){
					travellingTime += getTimeToTravel(currentOrbit, inputWeather);
				}
				if(minTimeToTravel > travellingTime){
					orbitTotravel = currentOrbits;
				}
			}
		}
		return orbitTotravel;
	}
	
	/**
	 * Gets the total travelling time required for a vehcile to travel a given orbit , weather.
	 * @param orbit 
	 * @param inputWeather
	 * @return total travelling time
	 */
	public int getTimeToTravel(Orbit orbit,Weather inputWeather){
		int changeInPothHoles = inputWeather.getPercentageChangeInNumberOfPathHoles();
		int vehicleSpeed = this.getVechileSpeed() > orbit.getTrafficSpeed() ?
				orbit.getTrafficSpeed() : this.getVechileSpeed();
		int timeTakenToTravelCrater = this.getVechilePathHoleTime();
		
		int totalTimeInMinutes = (int) (((float)orbit.getOrbitLength() / (float)vehicleSpeed) * 60
				+ (orbit.getCraterCount()+ (orbit.getCraterCount() * changeInPothHoles / 100))
						* timeTakenToTravelCrater);
		return totalTimeInMinutes;
	}
	
}
