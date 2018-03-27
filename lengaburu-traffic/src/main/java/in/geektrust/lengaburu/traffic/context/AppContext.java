package in.geektrust.lengaburu.traffic.context;

import in.geektrust.lengaburu.traffic.domain.Orbit;
import in.geektrust.lengaburu.traffic.domain.Vehicle;
import in.geektrust.lengaburu.traffic.domain.Weather;
import in.geektrust.lengaburu.traffic.utils.OutputMessageGenerator;

/**
 * Contains information specifically in context with current problems
 * @author arka
 *
 */
public interface AppContext {

	public static final Weather SUNNYWEATHER = new Weather(Weather.SUNNY,-10);
	public static final Weather RAINYWEATHER = new Weather(Weather.RAINY, 20);
	public static final Weather WINDYWEATHER = new Weather(Weather.WINDY, 0);
	
	public static final Vehicle superCar = new Vehicle(new Weather[]{SUNNYWEATHER,RAINYWEATHER,WINDYWEATHER},
			            "Car", 20, 3);
	public static final Vehicle tuktuk = new Vehicle(new Weather[]{SUNNYWEATHER,RAINYWEATHER},
            "tuktuk", 12, 1);
	public static final Vehicle bike = new Vehicle(new Weather[]{SUNNYWEATHER,WINDYWEATHER},
            "bike", 10, 2);
	
	public final static Vehicle[] vehicles = new Vehicle[]{superCar,bike,tuktuk};
	
	public OutputMessageGenerator solveProblem(Orbit [] routes,String weather,String source,String[] desiredPlacesToBeReached);
	
}
