package in.geektrust.lengaburu.traffic.util;

import in.geektrust.lengaburu.traffic.domain.Result;
import in.geektrust.lengaburu.traffic.domain.Orbit;
import in.geektrust.lengaburu.traffic.domain.Vehicle;
import in.geektrust.lengaburu.traffic.domain.Weather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class RoutesUtil {
	
	public static final Weather sunnyWeather = new Weather(Weather.sunny,-10);
	public static final Weather rainyWeather = new Weather(Weather.rainy, 20);
	public static final Weather windyWeather = new Weather(Weather.windy, 0);
	
	public static final Vehicle superCar = new Vehicle(new Weather[]{sunnyWeather,rainyWeather,windyWeather},
			            "Car", 20, 3);
	public static final Vehicle tuktuk = new Vehicle(new Weather[]{sunnyWeather,rainyWeather},
            "tuktuk", 12, 1);
	public static final Vehicle bike = new Vehicle(new Weather[]{sunnyWeather,windyWeather},
            "bike", 10, 2);
	
	public final static Vehicle[] vehicles = new Vehicle[]{superCar,bike,tuktuk};
	
	
	
	//choose between orbit 1 or orbit2 , let orbit x = orbit1 or orbit2
	//choose between orbit3 + orbit4 or orbit x + orbit4
	public static final List<Result> calculateBestRouteForMultipleDestination(Vehicle [] vehicles,Orbit [] routes,String todaysWeather){
			
			List<Result> resultList = new ArrayList<Result>(); 
			Map<String,Result> orbitX = new HashMap<>();
			Map<String,Result> orbit3 = new HashMap<>();
			Map<String,Result> orbit4 = new HashMap<>();

			Result finalResult1 = null;
			Result finalResult2 = null;
			for(Vehicle vehicle : vehicles){
				
				Weather currentweather = evaluateCurrentWeatherForVehicle(
						todaysWeather, vehicle);
				
				if(currentweather == null) continue;
				
				int changeInPothHoles = currentweather.getPercentageChangeInNumberOfPathHoles();
				String vehicleName = vehicle.getVechileType();
				int timeTakenToTravelPothhole = vehicle.getVechilePathHoleTime();
				int minTravelTime  = -1;
				String bestVehicleName = "";
				String currentRoute = "";
				String src = "";
				String dest = "";
				for(int i=0;i<2;i++){
					Orbit route = routes[i];
					src = route.getOrbitStartingPoint();
					dest = route.getOrbitEndingPoint();
					int maxPermissibleSpeed = route.getTrafficSpeed();
					long distance = route.getOrbitLength(); 
					int vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
							maxPermissibleSpeed : vehicle.getVechileSpeed();
					long pothHolesCount = route.getCraterCount();
					
					int totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
							+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
									* timeTakenToTravelPothhole);
					
					if(minTravelTime == -1 || minTravelTime > totalTimeInMinutes){
						minTravelTime = totalTimeInMinutes;
						bestVehicleName = vehicleName;
						currentRoute = route.getOrbitName();
					}
				}
				Result result = new Result(minTravelTime, bestVehicleName, currentRoute);
				result.setSrc(src);
				result.setDest(dest);
				orbitX.put(vehicleName, result);
				
				Orbit route = routes[2];
				src = route.getOrbitStartingPoint();
				dest = route.getOrbitEndingPoint();
				int maxPermissibleSpeed = route.getTrafficSpeed();
				long distance = route.getOrbitLength(); 
				int vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
						maxPermissibleSpeed : vehicle.getVechileSpeed();
				long pothHolesCount = route.getCraterCount();
				
				int totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
						+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
								* timeTakenToTravelPothhole);
				src = route.getOrbitStartingPoint();
				dest = route.getOrbitEndingPoint();
				result = new Result(totalTimeInMinutes, vehicle.getVechileType(), route.getOrbitName());
				result.setSrc(src);
				result.setDest(dest);
				orbit3.put(vehicleName, result);
				
				route = routes[3];
				src = route.getOrbitStartingPoint();
				dest = route.getOrbitEndingPoint();
				maxPermissibleSpeed = route.getTrafficSpeed();
				distance = route.getOrbitLength(); 
				vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
						maxPermissibleSpeed : vehicle.getVechileSpeed();
				pothHolesCount = route.getCraterCount();
				
				totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
						+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
								* timeTakenToTravelPothhole);
				src = route.getOrbitStartingPoint();
				dest = route.getOrbitEndingPoint();
				result = new Result(totalTimeInMinutes, vehicle.getVechileType(), route.getOrbitName());
				result.setSrc(src);
				result.setDest(dest);
				orbit4.put(vehicleName, result);
				
				//Orbit 3 + Orbit 4

				Result result3=orbit3.get(vehicle.getVechileType());
				Result result4=orbit4.get(vehicle.getVechileType());
				Result resultX=orbitX.get(vehicle.getVechileType());
				if(result3.getTotalTimeTakenToTravel()+result4.getTotalTimeTakenToTravel()<resultX.getTotalTimeTakenToTravel()+result4.getTotalTimeTakenToTravel()){
					if(finalResult1 == null && finalResult2 == null ||
							result3.getTotalTimeTakenToTravel()+result4.getTotalTimeTakenToTravel()<finalResult1.getTotalTimeTakenToTravel()+finalResult2.getTotalTimeTakenToTravel()){
						finalResult1 = result3;
						finalResult2 = result4;
					} 
				} else if(finalResult1 == null && finalResult2 == null ||
						resultX.getTotalTimeTakenToTravel()+result4.getTotalTimeTakenToTravel()<finalResult1.getTotalTimeTakenToTravel()+finalResult2.getTotalTimeTakenToTravel()){
					finalResult1 = resultX;
					finalResult2 = result4;
				} 
			}

			resultList.add(finalResult1);
			resultList.add(finalResult2);
			return resultList;
		}

	private static Weather evaluateCurrentWeatherForVehicle(
			String todaysWeather, Vehicle vehicle) {
		Weather currentweather = null;
		for(Weather weather : vehicle.getWeather()){
			if(weather.getWeatherName().trim().equalsIgnoreCase(todaysWeather)){
				currentweather = weather;
				break;
			}
		}
		return currentweather;
	}
	
	/**
	 * Returns ordered list of routes based on totaltimeof travelling
	 * @param vehicles
	 * @param routes
	 * @param todaysWeather
	 * @param source
	 * @param destination
	 * @return
	 */
public static List<Result> calculateBestRoute(Vehicle [] vehicles,Orbit [] routes,String todaysWeather,String source,String destination){
		
		List<Result> resultList = new ArrayList<Result>(); 
		
		for(Orbit route : routes){
			
			if(!(route.getOrbitStartingPoint().equalsIgnoreCase(source) && route.getOrbitEndingPoint().equalsIgnoreCase(destination)))  continue;
			
			int maxPermissibleSpeed = route.getTrafficSpeed();
			long distance = route.getOrbitLength();
			long pothHolesCount = route.getCraterCount();
			int minTravelTime  = -1;
			String bestVehicleName = "";
			String currentRoute = "";
			
			for(Vehicle vehicle : vehicles){
				Weather currentweather = null;
				
				
				for(Weather weather : vehicle.getWeather()){
					if(weather.getWeatherName().trim().equalsIgnoreCase(todaysWeather)){
						currentweather = weather;
						break;
					}
				}
				if(currentweather != null){
					int changeInPothHoles = currentweather.getPercentageChangeInNumberOfPathHoles();
					int vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
							maxPermissibleSpeed : vehicle.getVechileSpeed();
					String vehicleName = vehicle.getVechileType();
					int timeTakenToTravelPothhole = vehicle.getVechilePathHoleTime();
					
					int totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
							+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
									* timeTakenToTravelPothhole);
					
					if(minTravelTime == -1 || minTravelTime > totalTimeInMinutes){
						minTravelTime = totalTimeInMinutes;
						bestVehicleName = vehicleName;
						currentRoute = route.getOrbitName();
					}
				}
			}
			
			Result resultRoute = new Result(minTravelTime, bestVehicleName, currentRoute);
			resultList.add(resultRoute);
		}
		
		Collections.sort(resultList);
		return resultList;
	}
}
