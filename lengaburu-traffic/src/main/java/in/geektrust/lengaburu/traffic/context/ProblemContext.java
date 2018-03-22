package in.geektrust.lengaburu.traffic.context;

import in.geektrust.lengaburu.traffic.domain.Orbit;

public class ProblemContext implements AppContext{
	private String problemName;
	private String outputMessage;
	
	@Override
	public void solveProblem(Orbit[] routes, String weather, String source,
			String destination) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectOutputMessage(){
		
	}
	
	public ProblemContext(String problemName) {
		super();
		this.problemName = problemName;
		selectOutputMessage();
	}

}
