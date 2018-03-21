package in.geektrust.intergalactic_cricket_game.domain;

import in.geektrust.intergalactic_cricket_game.simulator.GameSimulatorContext;

public class Run {
	private Integer totalRunScored;
	private Integer requiredRun;
	private Integer netRunRequiredForWinning;
	
	public Run(Integer totalRunScored, Integer requiredRun,
			Integer netRunRequiredForWinning) {
		super();
		this.totalRunScored = totalRunScored;
		this.requiredRun = requiredRun;
		this.netRunRequiredForWinning = netRunRequiredForWinning;
	}
	
	public Integer getTotalRunScored() {
		return totalRunScored;
	}
	public void setTotalRunScored(Integer totalRunScored) {
		this.totalRunScored = totalRunScored;
	}
	public Integer getRequiredRun() {
		return requiredRun;
	}
	public void setRequiredRun(Integer requiredRun) {
		this.requiredRun = requiredRun;
	}
	public Integer getNetRunRequiredForWinning() {
		return netRunRequiredForWinning;
	}
	public void setNetRunRequiredForWinning(Integer netRunRequiredForWinning) {
		this.netRunRequiredForWinning = netRunRequiredForWinning;
	}
	
	public Run nextRun(GameSimulatorContext gameContext){
		return gameContext.nextRun();
	}
}
