package cs3330.assignment2;

public abstract class AbstractSupportRequest implements SupportRequest {

	private int id;
	private String title;
	private int basePoints;
	private boolean resolved;
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getBasePoints() {
		return basePoints;
	}
	
	public boolean isResolved() {
		return resolved;
	}
	
	public int getAwardedPoints() {
		return getBasePoints();
	}
	
	public String toString() {
		return String.format("Request %d, %s. Base points: %d. Resolved: %s", id, title, basePoints, resolved);
	}
	
	public AbstractSupportRequest(int id, String title, int basePoints) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or negative.");
		}
		if (title == null || title.isBlank()) {
			throw new IllegalArgumentException("The title cannot be blank or null.");
		}
		if (basePoints <= 0) {
			throw new IllegalArgumentException("Awarded service points cannot be 0 or negative.");
		}
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
	}
	
	public int resolveFor(Technician technician) {
		if (technician == null) {
			throw new IllegalArgumentException("Must pass a valid technician.");
		}
		if (isResolved() == true) {
			throw new IllegalStateException("Could not resolve: request has already been resolved.");
		}
		this.resolved = true;
		technician.addPoints(getAwardedPoints());
		return getAwardedPoints();
	}
	
}
	
