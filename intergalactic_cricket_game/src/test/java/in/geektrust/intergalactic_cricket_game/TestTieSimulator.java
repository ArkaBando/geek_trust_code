package in.geektrust.intergalactic_cricket_game;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;
import in.geektrust.intergalactic_cricket_game.domain.PlayerScoreProbability;
import in.geektrust.intergalactic_cricket_game.domain.Run;
import in.geektrust.intergalactic_cricket_game.domain.Team;
import in.geektrust.intergalactic_cricket_game.simulator.TieSimulator;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTieSimulator {
	private static TieSimulator simulator;
	private static BallingOver ballingOver;
	private static List<Batsmen> batsmenList;
	
	@BeforeClass
	public static void initialize(){
		 ballingOver = new BallingOver(1,Team.Enchai);
		batsmenList = Arrays.asList(new Batsmen("Kirat Boli", Team.Lengaburu, new PlayerScoreProbability(5, 10, 25, 10, 25, 1, 14, 10)),
				new Batsmen("NS Nodhi", Team.Lengaburu, new PlayerScoreProbability(5, 15, 15, 10, 20, 1, 19, 15)));
		
		simulator = new TieSimulator(ballingOver, batsmenList);
		Run run = simulator.play();
		int netRunTobeChased = run.getTotalRunScored();
		ballingOver = new BallingOver(1,Team.Lengaburu);
		batsmenList = Arrays.asList(new Batsmen("DB Velleyers", Team.Enchai, new PlayerScoreProbability(5, 10, 25, 10, 25, 1, 14, 10)),
				new Batsmen("H Mamla", Team.Enchai, new PlayerScoreProbability(10, 15, 15, 10, 20, 1, 19, 10)));
		simulator = new TieSimulator(ballingOver, batsmenList,netRunTobeChased);
		
	}
	
	@Test
	public void testTieMatch(){
		simulator.chase();
	}
}
