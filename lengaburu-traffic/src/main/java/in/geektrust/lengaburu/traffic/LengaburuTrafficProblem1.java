package in.geektrust.lengaburu.traffic;

import in.geektrust.lengaburu.traffic.domain.Result;
import in.geektrust.lengaburu.traffic.domain.Routes;
import in.geektrust.lengaburu.traffic.domain.Vehicles;
import in.geektrust.lengaburu.traffic.domain.Weather;
import in.geektrust.lengaburu.traffic.util.RoutesUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
		
		Routes orbit1 = new Routes("Orbit1", 20L, 10L, Integer.parseInt(mangalrokaSpeed),source,destination);
		Routes orbit2 = new Routes("Orbit2", 18L, 20L, Integer.parseInt(dellanburuSpeed),source,destination);
		
		List<Result> resultList = RoutesUtil.calculateBestRoute(RoutesUtil.vehicles,new Routes[]{orbit1,orbit2},weather,source,destination);
		System.out.println(resultList.get(0));
	}
	
	

}
