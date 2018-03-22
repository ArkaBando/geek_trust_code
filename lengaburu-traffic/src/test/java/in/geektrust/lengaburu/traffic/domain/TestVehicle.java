package in.geektrust.lengaburu.traffic.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestVehicle {

	public static  Weather sunnyWeather;
	public static  Weather rainyWeather;
	public static  Weather windyWeather;
	
	public static Vehicle superCar;
	public static Vehicle tuktuk;
	public static Vehicle bike;
	
	public final static Vehicle[] vehicles = new Vehicle[]{superCar,bike,tuktuk};

	@BeforeClass
	public static void init(){
		sunnyWeather = new Weather(Weather.SUNNY,-10);
		rainyWeather = new Weather(Weather.RAINY, 20);
		windyWeather = new Weather(Weather.WINDY, 0);
		
		superCar = new Vehicle(new Weather[]{sunnyWeather,rainyWeather,windyWeather},
	            "Car", 20, 3);
		tuktuk = new Vehicle(new Weather[]{sunnyWeather,rainyWeather},
		            "tuktuk", 12, 1);
		bike = new Vehicle(new Weather[]{sunnyWeather,windyWeather},
	            "bike", 10, 2);
	}
	
	@Test
	public void testFetchWeather(){
		String inputWeather = Weather.RAINY;
		
		Weather nonSupportiveForBikeWeather = bike.fetchWeather(inputWeather);
		assertNull(nonSupportiveForBikeWeather);
		
		inputWeather = Weather.WINDY;
		Weather supportiveWeatherForBike = bike.fetchWeather(inputWeather);
		assertNotNull(supportiveWeatherForBike);
		assertTrue(supportiveWeatherForBike.getWeatherName().equalsIgnoreCase(inputWeather));
		
		Weather nonSupportiveWeatherForTukTuk = tuktuk.fetchWeather(inputWeather);
		assertNull(nonSupportiveWeatherForTukTuk);
		
		Weather supportiveWeatherForCar = superCar.fetchWeather(inputWeather);
		assertNotNull(supportiveWeatherForCar);
		assertTrue(supportiveWeatherForCar.getWeatherName().equalsIgnoreCase(inputWeather));
				
	}
	
	@Test
	public void testIsVehicleAvailable(){
		
		assertTrue(superCar.isVehicleAvailable(sunnyWeather));
		assertTrue(!bike.isVehicleAvailable(rainyWeather));
		assertTrue(!tuktuk.isVehicleAvailable(windyWeather));
	}
	
	@Test
	public void testGetTimeToTravel(){
		String source =  "SilkDorb";
		String destination1 = "Hallitharam";
		Orbit orbit1 = new Orbit("Orbit1", 18L, 20, 20,source,destination1);
		int totalTimeTaken  = superCar.getTimeToTravel(orbit1, sunnyWeather);
		
		assertTrue(108 == totalTimeTaken);
		
		//bike not support for rainyWeather
		totalTimeTaken  = bike.getTimeToTravel(orbit1, rainyWeather);
		assertTrue(-1 == totalTimeTaken);
	}
	
	@Test
	public void testFetchOrbitWhichTakesMinimumTimeToTravel(){
		String source =  "SilkDorb";
		String destination1 = "Hallitharam";
		String destination2 = "RKPuram";
	 
	    Orbit orbit1 = new Orbit("Orbit1", 18L, 20, 20,source,destination1);
		Orbit orbit2 = new Orbit("Orbit2", 20L, 10, 12,source,destination1);
		Orbit orbit3 = new Orbit("Orbit3", 30L, 15, 15,source,destination2);
		Orbit orbit4 = new Orbit("Orbit4", 15L, 18, 12,destination2,destination1);
		
		List<Orbit[]> orbitList = Arrays.asList(new Orbit[]{orbit1,orbit2},new Orbit[]{orbit3,orbit4});
		
		Orbit[] orbits = tuktuk.fetchOrbitWhichTakesMinimumTimeToTravel(orbitList, rainyWeather);
		assertNotNull(orbits);
		assertTrue(orbits == orbitList.get(0));
		assertTrue(orbits.length == 2);
		
	}
}
