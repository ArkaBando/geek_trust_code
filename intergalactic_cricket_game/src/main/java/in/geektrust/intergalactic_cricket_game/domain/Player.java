package in.geektrust.intergalactic_cricket_game.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Player Details
 * @author arka
 *
 */
public class Player {
	
	private final String playerName;
	private final Team team;
	private final PlayerScoreProbability playerScoreProbability;
	
	public Player(String playerName, Team team,
			PlayerScoreProbability playerScoreProbility) {
		super();
		this.playerName = playerName;
		this.team = team;
		this.playerScoreProbability = playerScoreProbility;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Team getTeam() {
		return team;
	}

	public PlayerScoreProbability getPlayerScoreProbility() {
		return playerScoreProbability;
	}
	
	public List<Float> getScoringProbability(){
		return Arrays.asList(playerScoreProbability.getDotBall(),
				playerScoreProbability.getOneRun(), playerScoreProbability.getTwoRun(),
				playerScoreProbability.getThreeRun(),playerScoreProbability.getFourRun(),
				playerScoreProbability.getFiveRun(),playerScoreProbability.getSixRun(),
				playerScoreProbability.getOut());
	}
	
	
}
