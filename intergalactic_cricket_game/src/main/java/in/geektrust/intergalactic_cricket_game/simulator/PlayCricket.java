package in.geektrust.intergalactic_cricket_game.simulator;

import java.util.Arrays;
import java.util.List;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;
import in.geektrust.intergalactic_cricket_game.domain.PlayerScoreProbability;
import in.geektrust.intergalactic_cricket_game.domain.Run;
import in.geektrust.intergalactic_cricket_game.domain.Team;

public class PlayCricket {

	public static void play(){
		BallingOver ballingOver = new BallingOver(4,Team.Enchai);
		List<Batsmen> batsmenList = Arrays.asList(new Batsmen("Kirat Boli", Team.Lengaburu, new PlayerScoreProbability(5, 30, 25, 10, 15, 1, 9, 5)),
				new Batsmen("NS Nodhi", Team.Lengaburu, new PlayerScoreProbability(10, 40, 20, 5, 10, 1, 4, 10)),
				new Batsmen("R Rumrah", Team.Lengaburu, new PlayerScoreProbability(20, 30, 15, 5, 5, 1, 4, 20))	,
				new Batsmen("Shashi Henra", Team.Lengaburu, new PlayerScoreProbability(30, 25, 5, 0, 5, 1, 4, 30)));
		
		Simulator simulator = new Simulator(ballingOver, batsmenList,40);
		simulator.play();
	}
	
	
	public static void tieBreaker(){
		BallingOver ballingOver = new BallingOver(1,Team.Enchai);
		List<Batsmen> batsmenList = Arrays.asList(new Batsmen("Kirat Boli", Team.Lengaburu, new PlayerScoreProbability(5, 10, 25, 10, 25, 1, 14, 10)),
				new Batsmen("NS Nodhi", Team.Lengaburu, new PlayerScoreProbability(5, 15, 15, 10, 20, 1, 19, 15)));
		
		TieSimulator simulator = new TieSimulator(ballingOver, batsmenList);
		Run run = simulator.play();
		int netRunTobeChased = run.getTotalRunScored();
		ballingOver = new BallingOver(1,Team.Lengaburu);
		batsmenList = Arrays.asList(new Batsmen("DB Velleyers", Team.Enchai, new PlayerScoreProbability(5, 10, 25, 10, 25, 1, 14, 10)),
				new Batsmen("H Mamla", Team.Enchai, new PlayerScoreProbability(10, 15, 15, 10, 20, 1, 19, 10)));
		simulator = new TieSimulator(ballingOver, batsmenList,netRunTobeChased);
		simulator.chase();
	}
}
