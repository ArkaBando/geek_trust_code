package in.geektrust.lengaburu.traffic.util;

import in.geektrust.lengaburu.traffic.domain.Result;
import in.geektrust.lengaburu.traffic.domain.Routes;
import in.geektrust.lengaburu.traffic.domain.Vehicles;
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
	
	public static final Vehicles superCar = new Vehicles(new Weather[]{sunnyWeather,rainyWeather,windyWeather},
			            "Car", 20, 3);
	public static final Vehicles tuktuk = new Vehicles(new Weather[]{sunnyWeather,rainyWeather},
            "tuktuk", 12, 1);
	public static final Vehicles bike = new Vehicles(new Weather[]{sunnyWeather,windyWeather},
            "bike", 10, 2);
	
	public final static Vehicles[] vehicles = new Vehicles[]{superCar,bike,tuktuk};
	
	
	
	//choose between orbit 1 or orbit2 , let orbit x = orbit1 or orbit2
	//choose between orbit3 + orbit4 or orbit x + orbit4
	public static final List<Result> calculateBestRouteForMultipleDestination(Vehicles [] vehicles,Routes [] routes,String todaysWeather){
			
			List<Result> resultList = new ArrayList<Result>(); 
			Map<String,Result> orbitX = new HashMap<>();
			Map<String,Result> orbit3 = new HashMap<>();
			Map<String,Result> orbit4 = new HashMap<>();

			Result finalResult1 = null;
			Result finalResult2 = null;
			for(Vehicles vehicle : vehicles){
				
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
					Routes route = routes[i];
					src = route.getSource();
					dest = route.getDestination();
					int maxPermissibleSpeed = route.getMaxPermissibleSpeed();
					long distance = route.getPathDistance(); 
					int vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
							maxPermissibleSpeed : vehicle.getVechileSpeed();
					long pothHolesCount = route.getPathHoles();
					
					int totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
							+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
									* timeTakenToTravelPothhole);
					
					if(minTravelTime == -1 || minTravelTime > totalTimeInMinutes){
						minTravelTime = totalTimeInMinutes;
						bestVehicleName = vehicleName;
						currentRoute = route.getPathName();
					}
				}
				Result result = new Result(minTravelTime, bestVehicleName, currentRoute);
				result.setSrc(src);
				result.setDest(dest);
				orbitX.put(vehicleName, result);
				
				Routes route = routes[2];
				src = route.getSource();
				dest = route.getDestination();
				int maxPermissibleSpeed = route.getMaxPermissibleSpeed();
				long distance = route.getPathDistance(); 
				int vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
						maxPermissibleSpeed : vehicle.getVechileSpeed();
				long pothHolesCount = route.getPathHoles();
				
				int totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
						+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
								* timeTakenToTravelPothhole);
				src = route.getSource();
				dest = route.getDestination();
				result = new Result(totalTimeInMinutes, vehicle.getVechileType(), route.getPathName());
				result.setSrc(src);
				result.setDest(dest);
				orbit3.put(vehicleName, result);
				
				route = routes[3];
				src = route.getSource();
				dest = route.getDestination();
				maxPermissibleSpeed = route.getMaxPermissibleSpeed();
				distance = route.getPathDistance(); 
				vehicleSpeed = vehicle.getVechileSpeed() > maxPermissibleSpeed ?
						maxPermissibleSpeed : vehicle.getVechileSpeed();
				pothHolesCount = route.getPathHoles();
				
				totalTimeInMinutes = (int) (((float)distance / (float)vehicleSpeed) * 60
						+ (pothHolesCount+ (pothHolesCount* changeInPothHoles / 100))
								* timeTakenToTravelPothhole);
				src = route.getSource();
				dest = route.getDestination();
				result = new Result(totalTimeInMinutes, vehicle.getVechileType(), route.getPathName());
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
			String todaysWeather, Vehicles vehicle) {
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
public static List<Result> calculateBestRoute(Vehicles [] vehicles,Routes [] routes,String todaysWeather,String source,String destination){
		
		List<Result> resultList = new ArrayList<Result>(); 
		
		for(Routes route : routes){
			
			if(!(route.getSource().equalsIgnoreCase(source) && route.getDestination().equalsIgnoreCase(destination)))  continue;
			
			int maxPermissibleSpeed = route.getMaxPermissibleSpeed();
			long distance = route.getPathDistance();
			long pothHolesCount = route.getPathHoles();
			int minTravelTime  = -1;
			String bestVehicleName = "";
			String currentRoute = "";
			
			for(Vehicles vehicle : vehicles){
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
						currentRoute = route.getPathName();
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
