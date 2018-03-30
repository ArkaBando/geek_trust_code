package in.geektrust.cricket.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class RunTest {
	
	@Test
	public void testPlayDelivery(){
		Run run = new Run();
		run.playDelivery();
		assertThat(run.getNoOfBallsPlayed(),equalTo(1));
		run.getLastScore();
	}
}
