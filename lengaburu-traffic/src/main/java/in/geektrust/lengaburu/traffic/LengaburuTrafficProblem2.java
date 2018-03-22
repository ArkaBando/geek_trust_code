package in.geektrust.lengaburu.traffic;

import in.geektrust.lengaburu.traffic.domain.Result;
import in.geektrust.lengaburu.traffic.domain.Orbit;
import in.geektrust.lengaburu.traffic.util.RoutesUtil;

import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author arka
 *
 */
public class LengaburuTrafficProblem2 {
	
	public static void main(String[] args) {
		
		
		System.out.println("weather is:");
		Scanner scanner = new Scanner(System.in);
		String weather = scanner.nextLine();
		System.out.println("Orbit 1 traffic speed is");
		String orbit1Input = scanner.nextLine();
		System.out.println("Orbit 2 traffic speed is");
		String orbit2Input = scanner.nextLine();
		System.out.println("Orbit 3 traffic speed is");
		String orbit3Input = scanner.nextLine();
		System.out.println("Orbit 4 traffic speed is");
		String orbit4Input = scanner.nextLine();
		
		String source =  "SilkDorb";
		String destination1 = "Hallitharam";
		String destination2 = "RKPuram";
		
		Orbit orbit1 = new Orbit("Orbit1", 18L, 20, Integer.parseInt(orbit1Input),source,destination1);
		Orbit orbit2 = new Orbit("Orbit2", 20L, 10, Integer.parseInt(orbit2Input),source,destination1);
		Orbit orbit3 = new Orbit("Orbit3", 30L, 15, Integer.parseInt(orbit3Input),source,destination2);
		Orbit orbit4 = new Orbit("Orbit4", 15L, 18, Integer.parseInt(orbit4Input),destination2,destination1);

		
		
		List<Result> results= RoutesUtil.calculateBestRouteForMultipleDestination(RoutesUtil.vehicles,new Orbit[]{orbit1,orbit2,orbit3,orbit4},weather);
		Result finalResult[] = results.stream().toArray(Result[]::new);
		System.out.println(Result.getFormattedOutput(finalResult));

	}
	
	

}
