package in.geektrust.lengaburu.traffic.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Rich Domain Object Orbit equivalent to Route
 * @author arka
 *
 */
public final class Orbit {

	private final String orbitName;
	private final Long orbitLength;
	private final int craterCount;
	private final Integer trafficSpeed;
	private final String orbitStartingPoint;
	private final String orbitEndingPoint;

	
	public Orbit(String orbitName, Long orbitLength, int craterCount,
			Integer trafficSpeed, String orbitStartingPoint, String orbitEndingPoint) {
		super();
		this.orbitName = orbitName;
		this.orbitLength = orbitLength;
		this.craterCount = craterCount;
		this.trafficSpeed = trafficSpeed;
		this.orbitStartingPoint = orbitStartingPoint;
		this.orbitEndingPoint = orbitEndingPoint;
	}

	public String getOrbitStartingPoint() {
		return orbitStartingPoint;
	}

	public String getOrbitEndingPoint() {
		return orbitEndingPoint;
	}

	public Integer getTrafficSpeed() {
		return trafficSpeed;
	}

	public String getOrbitName() {
		return orbitName;
	}

	public Long getOrbitLength() {
		return orbitLength;
	}

	public int getCraterCount() {
		return craterCount;
	}
	
	
	/**
	 * Gets the total travelling time required for a vehcile to travel a given orbit , weather.
	 * @param vehicle 
	 * @param inputWeather
	 * @return total travelling time
	 */
	public int getTimeToTravel(Vehicle vehicle,Weather inputWeather){
		int percentageChangeInCrater = inputWeather.getPercentageChangeInNumberOfPathHoles();
		int vehicleSpeed = vehicle.getVechileSpeed() > this.getTrafficSpeed() ?
				this.getTrafficSpeed() : vehicle.getVechileSpeed();
		int timeTakenToTravelCrater = vehicle.getVechilePathHoleTime();
		
		int totalTimeInMinutes = (int) (((float)this.getOrbitLength() / (float)vehicleSpeed) * 60
				+ (this.getCraterCount()+ (this.getCraterCount() * percentageChangeInCrater / 100))
						* timeTakenToTravelCrater);
		return totalTimeInMinutes;
	}

	
	/**
	 * 
	 * @param orbitsAvailable
	 * @param desiredPlacesToBeReached
	 * @param source
	 * @return
	 */
	public static List<Orbit[]> generateOrbitsforDesiredDestinations(Orbit[] orbitsAvailable,String[] desiredPlacesToBeReached,String source){
		//to store the ***set of orbit** for reaching a desired destination.
		Map<String,Set<Orbit>> destinationMap = new HashMap<>();
		
		prepareDestinationMap(orbitsAvailable, desiredPlacesToBeReached,
				destinationMap);
		
		
		List<Orbit[]> noOfWaysOrbitCanBeFormed = new ArrayList<>();
		fetchNoOfWaysOrbitsCanbeFormed(desiredPlacesToBeReached,
				destinationMap, noOfWaysOrbitCanBeFormed);
		
		return noOfWaysOrbitCanBeFormed;
	}
	
	/**
	 * Fetch ways of Orbits or Routes can be formed to reach our destinations
	 * @param desiredPlacesToBeReached
	 * @param destinationMap
	 * @param noOfWaysOrbitCanBeFormed
	 */
	private static void fetchNoOfWaysOrbitsCanbeFormed(
			String[] desiredPlacesToBeReached,
			Map<String, Set<Orbit>> destinationMap,
			List<Orbit[]> noOfWaysOrbitCanBeFormed) {
		for(int i=0;i<desiredPlacesToBeReached.length;i++){
			String desiredPlace = desiredPlacesToBeReached[i];
			
			Set<Orbit> orbitToReachDesiredPlace = destinationMap.get(desiredPlace);
			for(Orbit orbit : orbitToReachDesiredPlace){
				
				String destination = orbit.getOrbitEndingPoint();
				if(desiredPlace.equalsIgnoreCase(orbit.getOrbitStartingPoint())){
					destination = orbit.getOrbitStartingPoint();
				}
				
				Set<Orbit> orbitSet = destinationMap.get(destination);
				if(destinationMap.size() == 2){
					//for no of intermidiate destination to be 1
					for(Orbit destinationOrbit : orbitSet){
						if(!(orbit.getOrbitEndingPoint().equalsIgnoreCase(destinationOrbit.getOrbitEndingPoint())&&
							 orbit.getOrbitStartingPoint().equalsIgnoreCase(destinationOrbit.getOrbitStartingPoint())) &&
						   !noOfWaysOrbitCanBeFormed.contains(new Orbit[]{orbit,destinationOrbit}) &&
						   !noOfWaysOrbitCanBeFormed.contains(new Orbit[]{destinationOrbit,orbit}))
						noOfWaysOrbitCanBeFormed.add(new Orbit[]{orbit,destinationOrbit});
					}
				} else if(destinationMap.size() == 1){
					//if no intermidiate destination exsists
					noOfWaysOrbitCanBeFormed.add(new Orbit[]{orbit});
				}				
			}
		}
	}

	/**
	 * Used for preparing destination Map
	 * @param orbitsAvailable
	 * @param desiredPlacesToBeReached
	 * @param destinationMap
	 */
	public static void prepareDestinationMap(Orbit[] orbitsAvailable,
			String[] desiredPlacesToBeReached,
			Map<String, Set<Orbit>> destinationMap) {
		String destinationName;
		for(int i=0;i<desiredPlacesToBeReached.length;i++){
			String desiredPlace = desiredPlacesToBeReached[i];
			
			for(Orbit orbit : orbitsAvailable){
				
				if(orbit.getOrbitStartingPoint().equalsIgnoreCase(desiredPlace)){
					destinationName = orbit.getOrbitStartingPoint();
					
					processDestinationMap(destinationMap, destinationName,
							orbit);
				}
				
				if(orbit.getOrbitEndingPoint().equalsIgnoreCase(desiredPlace)){
					destinationName = orbit.getOrbitEndingPoint();
					processDestinationMap(destinationMap, destinationName,
							orbit);
				}
			}
		}
		System.out.println(destinationMap);
	}
	
	/**
	 * Set destination map
	 * @param destinationMap
	 * @param destinationName
	 * @param orbit
	 */
	private static void processDestinationMap(
			Map<String, Set<Orbit>> destinationMap, String destinationName,
			Orbit orbit) {
		if(!destinationMap.containsKey(destinationName)){
			Set<Orbit> set = new HashSet<Orbit>();					
			set.add(orbit);
			destinationMap.put(destinationName,set);
		} else {
			Set<Orbit> set = destinationMap.get(destinationName);
			set.add(orbit);
			destinationMap.put(destinationName, set);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((orbitEndingPoint == null) ? 0 : orbitEndingPoint.hashCode());
		result = prime * result
				+ ((orbitName == null) ? 0 : orbitName.hashCode());
		result = prime
				* result
				+ ((orbitStartingPoint == null) ? 0 : orbitStartingPoint
						.hashCode());
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
		Orbit other = (Orbit) obj;
		if (orbitEndingPoint == null) {
			if (other.orbitEndingPoint != null)
				return false;
		} else if (!orbitEndingPoint.equals(other.orbitEndingPoint))
			return false;
		if (orbitName == null) {
			if (other.orbitName != null)
				return false;
		} else if (!orbitName.equals(other.orbitName))
			return false;
		if (orbitStartingPoint == null) {
			if (other.orbitStartingPoint != null)
				return false;
		} else if (!orbitStartingPoint.equals(other.orbitStartingPoint))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orbit [orbitName=" + orbitName + ", orbitLength=" + orbitLength
				+ ", craterCount=" + craterCount + ", trafficSpeed="
				+ trafficSpeed + ", orbitStartingPoint=" + orbitStartingPoint
				+ ", orbitEndingPoint=" + orbitEndingPoint + "]";
	}
	
	
}
