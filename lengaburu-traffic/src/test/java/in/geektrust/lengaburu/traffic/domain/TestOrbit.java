package in.geektrust.lengaburu.traffic.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * For testing Orbit Class
 * @author arka
 *
 */
public class TestOrbit {
/*	public static final Weather sunnyWeather = new Weather(Weather.sunny,-10);
	public static final Weather rainyWeather = new Weather(Weather.rainy, 20);
	public static final Weather windyWeather = new Weather(Weather.windy, 0);
	
	public static final Vehicle superCar = new Vehicle(new Weather[]{sunnyWeather,rainyWeather,windyWeather},
			            "Car", 20, 3);
	public static final Vehicle tuktuk = new Vehicle(new Weather[]{sunnyWeather,rainyWeather},
            "tuktuk", 12, 1);
	public static final Vehicle bike = new Vehicle(new Weather[]{sunnyWeather,windyWeather},
            "bike", 10, 2);
	public final static Vehicle[] vehicles = new Vehicle[]{superCar,bike,tuktuk};*/
	
	public  static Orbit[] orbits  = null;
	public  static Orbit[] orbits2  = null;
	public  static String[] destinations  = null;
	public  static String[] destinations2  = null;

	public static String source;
	
	@BeforeClass
	public static void init(){
	 	source =  "SilkDorb";
		String destination1 = "Hallitharam";
		String destination2 = "RKPuram";
	 
	    Orbit orbit1 = new Orbit("Orbit1", 18L, 20, 20,source,destination1);
		Orbit orbit2 = new Orbit("Orbit2", 20L, 10, 12,source,destination1);
		Orbit orbit3 = new Orbit("Orbit3", 30L, 15, 15,source,destination2);
		Orbit orbit4 = new Orbit("Orbit4", 15L, 18, 12,destination2,destination1);
		
		orbits = new Orbit[]{orbit1,orbit2,orbit3,orbit4};
		destinations = new String[]{destination1,destination2};
		
		orbits2 = new Orbit[]{orbit1,orbit2};
		destinations2 = new String[]{destination1};
	}
	
	@Test
	public void testGenerateOrbitsforDesiredDestinations(){
		
		List<Orbit[]> orbitList = Orbit.generateOrbitsforDesiredDestinations(orbits, destinations , source);
		assertEquals(orbitList.size(), 6);
		
	}
	
	@Test
	public void testGenerateOrbitsforDesiredDestinationsForProblem1(){
		
		List<Orbit[]> orbitList = Orbit.generateOrbitsforDesiredDestinations(orbits2, destinations2 , source);
		assertEquals(orbitList.size(), 2);
	
	}
	
	@Test
	public void testPrepareDestinationMap(){
		Map<String,Set<Orbit>> destinationMap = new HashMap<>();
		Orbit.prepareDestinationMap(orbits, destinations,
				destinationMap);
		
		assertTrue(destinationMap.containsKey(destinations[0]));
		assertTrue(destinationMap.containsKey(destinations[1]));
	}
	
	@Test
	public void testPrepareDestinationMapProblem1(){
		Map<String,Set<Orbit>> destinationMap = new HashMap<>();
		Orbit.prepareDestinationMap(orbits2, destinations2,
				destinationMap);
		
		assertTrue(destinationMap.containsKey(destinations2[0]));
		
	}
	
	/*@After
	public void tearDown(){
		orbits  = null;
		orbits2  = null;
		destinations  = null;
		destinations2  = null;
	}*/
	
	
}
