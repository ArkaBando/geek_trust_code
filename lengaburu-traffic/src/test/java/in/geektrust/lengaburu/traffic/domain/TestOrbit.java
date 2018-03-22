package in.geektrust.lengaburu.traffic.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * For testing Orbit Class
 * @author arka
 *
 */
public class TestOrbit {
	
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
		
		List<Orbit[]> orbitList = Orbit.generatePossibleOrbitsforDesiredDestinations(orbits, destinations , source);
		assertEquals(orbitList.size(), 6);
		
	}
	
	@Test
	public void testGenerateOrbitsforDesiredDestinationsForProblem1(){
		
		List<Orbit[]> orbitList = Orbit.generatePossibleOrbitsforDesiredDestinations(orbits2, destinations2 , source);
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
	
}
