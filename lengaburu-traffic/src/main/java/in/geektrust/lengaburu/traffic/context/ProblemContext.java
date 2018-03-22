package in.geektrust.lengaburu.traffic.context;

import java.util.List;

import in.geektrust.lengaburu.traffic.domain.Orbit;
import in.geektrust.lengaburu.traffic.domain.Vehicle;
import in.geektrust.lengaburu.traffic.domain.Weather;

public class ProblemContext implements AppContext{
	private String problemName;
	private String outputMessage;
	private static final String problem1OutputMessage = "Vehicle %s on %s";
	private static final String problem2OutputMessage = "Vehicle %s to %s via %s and %s via %s";
	
	@Override
	public void solveProblem(Orbit[] orbits, String weather, String source,
			String[] desiredPlacesToBeReached) {
		
		Orbit[] optimalOrbit = null;
		Vehicle optimalVehicle = null;
		
		
		int minimalTimeTakenToTravel = Integer.MAX_VALUE;
		for(int i=0;i<vehicles.length;i++){
			Vehicle vehicle = vehicles[i];
			
			List<Orbit[]> possibleOrbit = Orbit.generatePossibleOrbitsforDesiredDestinations(orbits, desiredPlacesToBeReached, source);
			Weather weatherObject = vehicle.fetchWeather(weather);
			Orbit [] minimalCalculatedOrbit = vehicle.
					fetchOrbitWhichTakesMinimumTimeToTravel(possibleOrbit, weatherObject);
			if(minimalTimeTakenToTravel > vehicle.getMinimumTimetakenByVehicleToTravelOrbit()){
				minimalTimeTakenToTravel = vehicle.getMinimumTimetakenByVehicleToTravelOrbit();
				optimalOrbit = minimalCalculatedOrbit;
				optimalVehicle = vehicle;
			}
		}
		
		switch (problemName) {
		case "Problem1":
			System.out.printf(outputMessage, optimalVehicle.getVechileType(), optimalOrbit[0].getOrbitName());
			break;
		case "Problem2" :
			processProblem2Output(source, optimalOrbit, optimalVehicle);
			
			break;
		default:
			break;
		}
	}

	private void processProblem2Output(String source, Orbit[] optimalOrbit,
			Vehicle optimalVehicle) {
		Orbit sourceOrbit = optimalOrbit[0];
		Orbit destinationOrbit = optimalOrbit[1];
		
		//------------------------------ Orbit rearranged if required
		if(destinationOrbit.getOrbitStartingPoint().equalsIgnoreCase(source)){
			sourceOrbit = optimalOrbit[1];
			destinationOrbit = optimalOrbit[0];
		}
		
		if(destinationOrbit.getOrbitEndingPoint().equalsIgnoreCase(source)){
			sourceOrbit = optimalOrbit[1];
			String src = optimalOrbit[1].getOrbitStartingPoint();
			sourceOrbit.setOrbitEndingPoint(src);
			sourceOrbit.setOrbitStartingPoint(source);
			destinationOrbit = optimalOrbit[0];
		}
		//---------------------------------
		System.out.printf(outputMessage,
				optimalVehicle.getVechileType(),
				sourceOrbit.getOrbitEndingPoint(),
				sourceOrbit.getOrbitName(),
				destinationOrbit.getOrbitEndingPoint().equalsIgnoreCase(sourceOrbit.getOrbitEndingPoint())?
				destinationOrbit.getOrbitStartingPoint():destinationOrbit.getOrbitEndingPoint()	,
				destinationOrbit.getOrbitName());
	}
	
	public void selectOutputMessage(){
		
		switch(problemName){
		case "Problem1" : 
			outputMessage = problem1OutputMessage; 
			break;
		case "Problem2" :
			outputMessage = problem2OutputMessage;
			break;
			
		default : break;
		}
	}
	
	public ProblemContext(String problemName) {
		super();
		this.problemName = problemName;
		selectOutputMessage();
	}

}
