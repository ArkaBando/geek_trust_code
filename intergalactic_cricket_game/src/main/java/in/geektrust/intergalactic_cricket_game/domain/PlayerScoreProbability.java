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
		this.dotBall = dotBall/100;
		this.oneRun = oneRun/100;
		this.twoRun = twoRun/100;
		this.threeRun = threeRun/100;
		this.fourRun = fourRun/100;
		this.fiveRun = fiveRun/100;
		this.sixRun = sixRun/100;
		this.out = out/100;
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
