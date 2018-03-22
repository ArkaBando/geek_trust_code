package in.geektrust.lengaburu.traffic.domain;

public final class Route {

	private final String pathName;
	private final Long pathDistance;
	private final Long pathHoles;
	private final Integer maxPermissibleSpeed;
	private final String source;
	private final String destination;

	

	public Route(String pathName, Long pathDistance, Long pathHoles,
			Integer maxPermissibleSpeed, String source, String destination) {
		super();
		this.pathName = pathName;
		this.pathDistance = pathDistance;
		this.pathHoles = pathHoles;
		this.maxPermissibleSpeed = maxPermissibleSpeed;
		this.source = source;
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public Integer getMaxPermissibleSpeed() {
		return maxPermissibleSpeed;
	}

	public String getPathName() {
		return pathName;
	}

	public Long getPathDistance() {
		return pathDistance;
	}

	public Long getPathHoles() {
		return pathHoles;
	}
	
}
