package in.geektrust.lengaburu.traffic.domain;

public final class Weather {
	
	private final String weatherName;
	private final Integer percentageChangeInNumberOfPathHoles;
	public static final String sunny = "Sunny";
	public static final String rainy = "Rainy";
	public static final String windy = "Windy";
	
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
