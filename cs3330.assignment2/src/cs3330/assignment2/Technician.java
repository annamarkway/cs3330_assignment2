package cs3330.assignment2;

public class Technician {
	private String name;
	private int servicePoints;
	
	public Technician(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be blank or null.");
		}
		this.name = name;
		this.servicePoints = 0;
	}
	
	public void addPoints(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot award negative service points.");
		}
		this.servicePoints += amount;
	}
	
	public int getServicePoints() {
		return this.servicePoints;
	}
	
	public String toString() {
		return String.format("Name: %s. Service points: %d", this.name, this.servicePoints);
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
	
		if (!(object instanceof Technician)) {
			return false;
		}
		
		Technician other = (Technician) object;
		return this.name.equals(other.name);
	
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
}
