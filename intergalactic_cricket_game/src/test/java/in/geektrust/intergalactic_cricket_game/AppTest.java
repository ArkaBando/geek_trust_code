package in.geektrust.intergalactic_cricket_game;

import in.geektrust.intergalactic_cricket_game.util.DefaultRandomNumberGenerator;

import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        List<Integer> actualList =  (List<Integer>) Arrays.asList(20,30,40,50);
        List<Float> weightedList =  (List<Float>) Arrays.asList(0.5F,0.2F,0.1F,0.2F);
        DefaultRandomNumberGenerator defaultRandomNumberGenerator = new DefaultRandomNumberGenerator(actualList, weightedList);
        int value = defaultRandomNumberGenerator.generateWeightBasedRandomNumber();
        assertTrue(value>0);
    }
}
