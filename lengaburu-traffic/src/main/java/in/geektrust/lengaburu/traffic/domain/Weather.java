package in.geektrust.lengaburu.traffic.domain;

public final class Weather {
	
	private final String weatherName;
	private final Integer percentageChangeInNumberOfPathHoles;
	public static final String SUNNY = "Sunny";
	public static final String RAINY = "Rainy";
	public static final String WINDY = "Windy";
	
	public Weather(String weatherName,
			Integer percentageChangeInNumberOfPathHoles) {
		super();
		this.weatherName = weatherName;
		this.percentageChangeInNumberOfPathHoles = percentageChangeInNumberOfPathHoles;
	}
	
	public String getWeatherName() {
		return weatherName;
	}

	public Integer getPercentageChangeInNumberOfPathHoles() {
		return percentageChangeInNumberOfPathHoles;
	}
}
