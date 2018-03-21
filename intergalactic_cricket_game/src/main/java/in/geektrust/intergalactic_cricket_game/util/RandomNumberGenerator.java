package in.geektrust.intergalactic_cricket_game.util;

import java.util.List;
import java.util.Random;

/**
 * 
 * @author arka
 *
 */
public abstract class RandomNumberGenerator {

	public List<Float> weightedList;
	public List<Integer> actualValueList;
	protected final Random randomNumberGenerator = new Random();

	public Integer generateWeightBasedRandomNumber(int min, int max) {
		if(!validateWeightedList()){
			throw new IllegalStateException("Given weightedList is not a valid valued list");
		}
		Integer weightBasedRandomNumber = -1;
		

			float randomSelectedNumber = random(min, max);
			float weighted_sum = 0f;
			for (int i = 0; i < actualValueList.size(); i++) {
				weighted_sum += weightedList.get(i);
				if (randomSelectedNumber <= weighted_sum) {
					weightBasedRandomNumber = actualValueList.get(i);
					break;
				}
			}
		
		return weightBasedRandomNumber;
	}

	protected boolean validateWeightedList() {
		boolean isWeightedListValid = false;
		if (weightedList == null || weightedList.isEmpty()) {
			return isWeightedListValid;
		} else {
			float weightedSum = 0f;
			for (int i = 0; i < weightedList.size(); i++) {
				weightedSum += weightedList.get(i);
			}
			isWeightedListValid = weightedSum == 1f && weightedList.size() == actualValueList.size();
		}
		return isWeightedListValid;
	}

	public Integer generateWeightBasedRandomNumber() {
		return generateWeightBasedRandomNumber(0, 1);
	}

	protected Float random(final Integer min, final Integer max) {
		return randomNumberGenerator.nextFloat() * (max - min) + min;
	}
}
