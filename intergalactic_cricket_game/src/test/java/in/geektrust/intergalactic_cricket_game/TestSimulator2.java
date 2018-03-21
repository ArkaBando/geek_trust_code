package in.geektrust.intergalactic_cricket_game;

import in.geektrust.intergalactic_cricket_game.domain.BallingOver;
import in.geektrust.intergalactic_cricket_game.domain.Batsmen;
import in.geektrust.intergalactic_cricket_game.domain.PlayerScoreProbability;
import in.geektrust.intergalactic_cricket_game.domain.Team;
import in.geektrust.intergalactic_cricket_game.simulator.Simulator;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSimulator2 {
	private static Simulator simulator;
	private static BallingOver ballingOver;
	private static List<Batsmen> batsmenList;
	
	@BeforeClass
	public static void initialize(){
		 ballingOver = new BallingOver(4,Team.Enchai);
		batsmenList = Arrays.asList(new Batsmen("Kirat Boli", Team.Lengaburu, new PlayerScoreProbability(5, 5, 25, 10, 15, 1, 9, 30)),
				new Batsmen("NS Nodhi", Team.Lengaburu, new PlayerScoreProbability(10, 40, 20, 5, 10, 1, 4, 10)),
				new Batsmen("R Rumrah", Team.Lengaburu, new PlayerScoreProbability(20, 30, 15, 5, 5, 1, 4, 20))	,
				new Batsmen("Shashi Henra", Team.Lengaburu, new PlayerScoreProbability(30, 25, 5, 0, 5, 1, 4, 30)));
		
		 simulator = new Simulator(ballingOver, batsmenList,40);
	}
	
	@Test
	public void testPlay(){
		System.out.println("*****************************************************************************");
		System.out.println("simulator 2 running");
		simulator = new Simulator(ballingOver, batsmenList,40);
		simulator.play();
		System.out.println("*****************************************************************************");
	}
}
