package cs3330.assignment2;

public interface SupportRequest {

	public int getId();
	public String getTitle();
	public int getBasePoints();
	public boolean isResolved();
	public void resolve();
	public int resolveFor(Technician technician);
		
}
