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
	private Integer minimumTimetakenByVehicleToTravelOrbit;
	
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
	
	public Integer getMinimumTimetakenByVehicleToTravelOrbit() {
		return minimumTimetakenByVehicleToTravelOrbit;
	}
	
	/**
	 * Checks whether a given vehicle is available for a given Weather
	 * @param inputWeather
	 * @return true given vehicle is available for a given Weather or else false
	 */
	public boolean isVehicleAvailable(Weather inputWeather) {
		Weather currentweather = null;
		
		if(inputWeather == null) {
			return false;
		}
		for(Weather weather : this.getWeather()){
			if(weather.getWeatherName().trim().equalsIgnoreCase(inputWeather.getWeatherName())){
				currentweather = weather;
				break;
			}
		}
		return (currentweather != null);
	}
	
	/**
	 * Fetch Weather object against weather String
	 * @param inputWeather
	 * @return
	 */
	public Weather fetchWeather(String inputWeather){
		Weather currentweather = null;
		for(Weather weather:this.weather){
			if(weather.getWeatherName().equalsIgnoreCase(inputWeather)){
				currentweather = weather;
				break;
			}
		}
		return currentweather;
	}
	
	/**
	 * 
	 * @param listOfAvailableOrbit
	 * @param inputWeather
	 * @return
	 */
	public Orbit[] fetchOrbitWhichTakesMinimumTimeToTravel(List<Orbit[]> listOfAvailableOrbit,Weather inputWeather){
		Orbit [] orbitTotravel = null;
		int minTimeToTravel = Integer.MAX_VALUE;
		if(isVehicleAvailable(inputWeather)){
			
			for(int i=0;i<listOfAvailableOrbit.size();i++){
				Orbit[] currentOrbits = listOfAvailableOrbit.get(i);
				int travellingTime = 0;
				for(Orbit currentOrbit : currentOrbits){
					travellingTime += getTimeToTravel(currentOrbit, inputWeather)!=-1?
							          getTimeToTravel(currentOrbit, inputWeather): 
							          (Integer.MAX_VALUE-travellingTime);
				}
				if(minTimeToTravel > travellingTime){
					minTimeToTravel = travellingTime;
					orbitTotravel = currentOrbits;
				}
			}
		}
		minimumTimetakenByVehicleToTravelOrbit = minTimeToTravel;
		return orbitTotravel;
	}
	
	/**
	 * Gets the total travelling time required for a vehicle to travel a given orbit , weather.
	 * @param orbit 
	 * @param inputWeather
	 * @return total travelling time
	 */
	public int getTimeToTravel(Orbit orbit,Weather inputWeather){
		
		//early fail strategy
		if(!this.isVehicleAvailable(inputWeather)) return -1;
		
		int changeInPothHoles = inputWeather.getPercentageChangeInNumberOfPathHoles();
		int vehicleSpeed = this.getVechileSpeed() > orbit.getTrafficSpeed() ?
							orbit.getTrafficSpeed() : this.getVechileSpeed();
		int timeTakenToTravelCrater = this.getVechilePathHoleTime();
		int cratersCount = (orbit.getCraterCount()+ (orbit.getCraterCount() * changeInPothHoles / 100));
		int totalTimeInMinutes = (int) (((float)orbit.getOrbitLength() / (float)vehicleSpeed) * 60
				+ cratersCount * timeTakenToTravelCrater);
		return totalTimeInMinutes;
	}
	
}
