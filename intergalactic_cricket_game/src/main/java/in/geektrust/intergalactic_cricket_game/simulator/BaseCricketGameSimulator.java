package in.geektrust.intergalactic_cricket_game.simulator;

import in.geektrust.intergalactic_cricket_game.domain.Team;

import java.util.Arrays;
import java.util.List;

public interface BaseCricketGameSimulator {
	String winningMessage = "\n "+Team.Lengaburu.name()+" won by %d wicket and %d balls remaining \n";
	String playerStatus = "\n %s - %s (%d balls)";
	String currentPlayerStatus =" %s %s scores %d run";
	String outPlayerStatus =" %s %s got out";
	String overStatus = "\n%d overs left. %d runs to win  \n";
	String enchaiWinningMessage = "\n "+Team.Enchai.name()+" won by %d runs. \n";
	String chaseSideWinningMessage = "\n %s won with %d balls remaining";
	String scoringSideWinningMessage = "\n %s won with %d runs remaining";
	List<Integer> allocatedScoreList = (List<Integer>) Arrays.asList(0,1,2,3,4,5,6,-1);	

}
