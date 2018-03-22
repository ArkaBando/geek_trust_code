package in.geektrust.lengaburu.traffic;

import in.geektrust.lengaburu.traffic.domain.Result;
import in.geektrust.lengaburu.traffic.domain.Route;
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
		
		Route orbit1 = new Route("Orbit1", 18L, 20L, Integer.parseInt(orbit1Input),source,destination1);
		Route orbit2 = new Route("Orbit2", 20L, 10L, Integer.parseInt(orbit2Input),source,destination1);
		Route orbit3 = new Route("Orbit3", 30L, 15L, Integer.parseInt(orbit3Input),source,destination2);
		Route orbit4 = new Route("Orbit4", 15L, 18L, Integer.parseInt(orbit4Input),destination2,destination1);

		
		
		List<Result> results= RoutesUtil.calculateBestRouteForMultipleDestination(RoutesUtil.vehicles,new Route[]{orbit1,orbit2,orbit3,orbit4},weather);
		Result finalResult[] = results.stream().toArray(Result[]::new);
		System.out.println(Result.getFormattedOutput(finalResult));

	}
	
	

}
