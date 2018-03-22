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
public class LengaburuTrafficProblem1 {

	public static void main(String[] args) {		
		
		System.out.println("weather is:");
		Scanner scanner = new Scanner(System.in);
		String weather = scanner.nextLine();
		System.out.println("Orbit 1 traffic speed is");
		String mangalrokaSpeed = scanner.nextLine();

		System.out.println("Orbit 2 traffic speed is");
		String dellanburuSpeed = scanner.nextLine();
		
		String source =  "SilkDorb";
		String destination = "Hallitharam";
		
		Orbit orbit1 = new Orbit("Orbit1", 20L, 10, Integer.parseInt(mangalrokaSpeed),source,destination);
		Orbit orbit2 = new Orbit("Orbit2", 18L, 20, Integer.parseInt(dellanburuSpeed),source,destination);
		
		List<Result> resultList = RoutesUtil.calculateBestRoute(RoutesUtil.vehicles,new Orbit[]{orbit1,orbit2},weather,source,destination);
		System.out.println(resultList.get(0));
	}
	
	

}
