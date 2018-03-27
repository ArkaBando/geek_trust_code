package in.geektrust.lengaburu.traffic;

import in.geektrust.lengaburu.traffic.context.ProblemContext;
import in.geektrust.lengaburu.traffic.domain.Orbit;

import java.util.Scanner;
/**
 * 
 * @author arka
 *
 */
public class LengaburuTrafficProblem1 {

	public static void main(String[] args) {		
		
		System.out.println("weather is:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String weather = scanner.nextLine();
		System.out.print("Orbit 1 traffic speed is ");
		String mangalrokaSpeed = scanner.nextLine();

		System.out.print("megamiles/hr \n Orbit 2 traffic speed is");
		String dellanburuSpeed = scanner.nextLine();
		System.out.println("megamiles/hr");
		String source =  "SilkDorb";
		String destination = "Hallitharam";
		
		Orbit orbit1 = new Orbit("Orbit1", 20L, 10, Integer.parseInt(mangalrokaSpeed),source,destination);
		Orbit orbit2 = new Orbit("Orbit2", 18L, 20, Integer.parseInt(dellanburuSpeed),source,destination);
		
		
		ProblemContext problemContext =  new ProblemContext("Problem1");
		problemContext.
		solveProblem(new Orbit[]{orbit1,orbit2}, weather, source, new String[]{destination})
		.print();
	
	}
	
	

}
