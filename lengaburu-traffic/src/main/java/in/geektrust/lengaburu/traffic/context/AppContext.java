package in.geektrust.lengaburu.traffic.context;

import in.geektrust.lengaburu.traffic.domain.Orbit;
import in.geektrust.lengaburu.traffic.domain.Vehicle;
import in.geektrust.lengaburu.traffic.domain.Weather;

/**
 * Contains information specifically in context with current problems
 * @author arka
 *
 */
public interface AppContext {

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
	
	public void solveProblem(Orbit [] routes,String weather,String source,String destination);
	
}
