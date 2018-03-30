package in.geektrust.cricket.domain;
/**
 * Not Modified as not required in current context
 * @author arka
 *
 */
public class Ball {

	private int totalNoBallsBowled;
	private int totalOverBowled;
	private int totalRunScoredOnBowling;
	
	public Ball(){
		this.totalNoBallsBowled = 0;
		this.totalOverBowled = 0;
		this.totalRunScoredOnBowling=0;
	}

	public int getTotalNoBallsBowled() {
		return totalNoBallsBowled;
	}
	
	public void addBall(){
		this.totalNoBallsBowled = totalNoBallsBowled+1;
		this.totalOverBowled = this.totalNoBallsBowled/6; 
	}

	public void setTotalNoBallsBowled(int totalNoBallsBowled) {
		this.totalNoBallsBowled = totalNoBallsBowled;
		this.totalOverBowled = this.totalNoBallsBowled/6; 
	}

	public int getTotalRunScoredOnBowling() {
		return totalRunScoredOnBowling;
	}

	public void setTotalRunScoredOnBowling(int totalRunScoredOnBowling) {
		this.totalRunScoredOnBowling = totalRunScoredOnBowling;
	}

	public int getTotalOverBowled() {
		return totalOverBowled;
	}

}
