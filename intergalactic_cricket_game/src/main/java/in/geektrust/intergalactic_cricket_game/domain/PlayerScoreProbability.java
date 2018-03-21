package in.geektrust.intergalactic_cricket_game.domain;

/**
 * Class for storing Player Scoring Probability
 * @author arka
 *
 */
public class PlayerScoreProbability {
	
	private final float dotBall;
	private final float oneRun;
	private final float twoRun;
	private final float threeRun;
	private final float fiveRun;
	private final float fourRun;
	private final float sixRun;
	private final float out;
	
	public PlayerScoreProbability(float dotBall, float oneRun, float twoRun,
			float threeRun, float fourRun, float fiveRun, float sixRun, float out) {
		super();
		this.dotBall = dotBall;
		this.oneRun = oneRun;
		this.twoRun = twoRun;
		this.threeRun = threeRun;
		this.fourRun = fourRun;
		this.fiveRun = fiveRun;
		this.sixRun = sixRun;
		this.out = out;
	}

	public float getDotBall() {
		return dotBall;
	}

	public float getOneRun() {
		return oneRun;
	}

	public float getTwoRun() {
		return twoRun;
	}

	public float getThreeRun() {
		return threeRun;
	}

	public float getFourRun() {
		return fourRun;
	}

	public float getSixRun() {
		return sixRun;
	}

	public float getOut() {
		return out;
	}

	public float getFiveRun() {
		return fiveRun;
	}
	
}
