package in.geektrust.lengaburu.traffic;

import in.geektrust.lengaburu.traffic.context.ProblemContext;
import in.geektrust.lengaburu.traffic.domain.Orbit;

import java.util.Scanner;
/**
 * 
 * @author arka
 *
 */
public class LengaburuTrafficProblem2 {
	
	public static void main(String[] args) {
		
		
		System.out.println("weather is:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String weather = scanner.nextLine();
		System.out.print("Orbit 1 traffic speed is ");
		int orbit1Input = scanner.nextInt();
		System.out.print("megamiles/hr \n Orbit 2 traffic speed is");
		int orbit2Input = scanner.nextInt();
		System.out.print(" megamiles/hr \n Orbit 3 traffic speed is");
		int orbit3Input = scanner.nextInt();
		System.out.print(" megamiles/hr \n Orbit 4 traffic speed is ");
		int orbit4Input = scanner.nextInt();
		System.out.print(" megamiles/hr \n");
		String source =  "SilkDorb";
		String destination1 = "Hallitharam";
		String destination2 = "RKPuram";
		
		Orbit orbit1 = new Orbit("Orbit1", 18L, 20, orbit1Input,source,destination1);
		Orbit orbit2 = new Orbit("Orbit2", 20L, 10, orbit2Input,source,destination1);
		Orbit orbit3 = new Orbit("Orbit3", 30L, 15, orbit3Input,source,destination2);
		Orbit orbit4 = new Orbit("Orbit4", 15L, 18, orbit4Input,destination2,destination1);

		
		ProblemContext problemContext =  new ProblemContext("Problem2");
		problemContext.
		solveProblem(new Orbit[]{orbit1,orbit2,orbit3,orbit4}, weather, source, new String[]{destination1,destination2})
		.print();

	}
	
	

}
