package in.geektrust.lengaburu.traffic.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import in.geektrust.lengaburu.traffic.context.ProblemContext;
import in.geektrust.lengaburu.traffic.utils.OutputMessageGenerator;

import org.junit.Before;
import org.junit.Test;

/**
 * For testing problem against give test cases
 * @author arka
 *
 */
public class TestProblem {
	private String source;
	private String destination;
	private Orbit orbit1;
	private Orbit orbit2;
	private Orbit orbit3;
	private Orbit orbit4;
	
	@Before
	public void init(){
		source =  "SilkDorb";
		destination = "Hallitharam";		
	}
	
	@Test
	public void testProblem1ForSunnyWeather(){
		Orbit orbit1 = new Orbit("Orbit1", 20L, 10, 12,source,destination);
		Orbit orbit2 = new Orbit("Orbit2", 18L, 20,10 ,source,destination);
		
		
		ProblemContext problemContext =  new ProblemContext("Problem1");
		OutputMessageGenerator outputMessageGenerator = problemContext.solveProblem(new Orbit[]{orbit1,orbit2}, "Sunny", source, new String[]{destination});
		assertNotNull(outputMessageGenerator);
		String outputMessage = outputMessageGenerator.getFormattedOutputString();
		assertEquals(outputMessage, "Vehicle tuktuk on Orbit1");
	}
	
	@Test
	public void testProblem1ForWindyWeather(){
		Orbit orbit1 = new Orbit("Orbit1", 20L, 10, 14,source,destination);
		Orbit orbit2 = new Orbit("Orbit2", 18L, 20, 20,source,destination);
		
		
		ProblemContext problemContext =  new ProblemContext("Problem1");
		OutputMessageGenerator outputMessageGenerator = problemContext.solveProblem(new Orbit[]{orbit1,orbit2}, "Sunny", source, new String[]{destination});
		assertNotNull(outputMessageGenerator);
		String outputMessage = outputMessageGenerator.getFormattedOutputString();
		assertEquals(outputMessage, "Vehicle Car on Orbit2");
	}
	
	
	@Test
	public void testProblem2ForSunnyWeather(){
		
		String destination1 = "Hallitharam";
		String destination2 = "RKPuram";
		
		 orbit1 = new Orbit("Orbit1", 18L, 20, 20,source,destination1);
		 orbit2 = new Orbit("Orbit2", 20L, 10, 12,source,destination1);
		 orbit3 = new Orbit("Orbit3", 30L, 15, 15,source,destination2);
		 orbit4 = new Orbit("Orbit4", 15L, 18, 12,destination2,destination1);

		
		ProblemContext problemContext =  new ProblemContext("Problem2");
		OutputMessageGenerator outputMessageGenerator = problemContext.solveProblem(new Orbit[]{orbit1,orbit2,orbit3,orbit4}, "Sunny", source, new String[]{destination1,destination2});
		assertNotNull(outputMessageGenerator);
		String outputMessage = outputMessageGenerator.getFormattedOutputString();
		assertEquals(outputMessage.trim(), "Vehicle tuktuk to Hallitharam via Orbit1 and RKPuram via Orbit4");
	}

	@Test
	public void testProblem2ForWindyWeather(){
		
		String destination1 = "Hallitharam";
		String destination2 = "RKPuram";
		
		 orbit1 = new Orbit("Orbit1", 18L, 20, 5,source,destination1);
		 orbit2 = new Orbit("Orbit2", 20L, 10, 10,source,destination1);
		 orbit3 = new Orbit("Orbit3", 30L, 15, 20,source,destination2);
		 orbit4 = new Orbit("Orbit4", 15L, 18, 20,destination2,destination1);

		
		ProblemContext problemContext =  new ProblemContext("Problem2");
		OutputMessageGenerator outputMessageGenerator = problemContext.solveProblem(new Orbit[]{orbit1,orbit2,orbit3,orbit4}, "Windy", source, new String[]{destination1,destination2});
	
		assertNotNull(outputMessageGenerator);
		String outputMessage = outputMessageGenerator.getFormattedOutputString();
		assertEquals(outputMessage.trim(), "Vehicle Car to RKPuram via Orbit3 and Hallitharam via Orbit4");
	}

}

