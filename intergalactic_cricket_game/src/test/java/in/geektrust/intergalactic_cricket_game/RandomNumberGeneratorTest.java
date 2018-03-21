package in.geektrust.intergalactic_cricket_game;

import in.geektrust.intergalactic_cricket_game.util.DefaultRandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumberGeneratorTest {
	 static List<Integer> actualList;
	 static List<Float> weightedList;
	 
	@BeforeClass
	public static void initialize(){
		  actualList =  (List<Integer>) Arrays.asList(20,30,40,50);
	      weightedList =  (List<Float>) Arrays.asList(0.5F,0.2F,0.1F,0.2F);
	}
	
	@Test
	public void testGenerateRandomNumber(){
		 DefaultRandomNumberGenerator defaultRandomNumberGenerator = new DefaultRandomNumberGenerator(actualList, weightedList);
	     int value = defaultRandomNumberGenerator.generateWeightBasedRandomNumber();
	     assertTrue(value>0);
	     assertTrue(actualList.contains(value));
	}
	
	@Test(expected=IllegalStateException.class)
	public void testValidWeightedList(){
		weightedList.set(0, 1F);
		DefaultRandomNumberGenerator defaultRandomNumberGenerator = new DefaultRandomNumberGenerator(actualList, weightedList);
		int value = defaultRandomNumberGenerator.generateWeightBasedRandomNumber();
	    
	}
}
