package in.geektrust.intergalactic_cricket_game.util;

import java.util.List;

public class DefaultRandomNumberGenerator extends RandomNumberGenerator{

	public  DefaultRandomNumberGenerator(final List<Integer> actualList,final List<Float> weightedList) {
		this.actualValueList = actualList;
		this.weightedList = weightedList;
	}
	
}
