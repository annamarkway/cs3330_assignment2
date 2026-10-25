package cs3330.assignment2;

public class NetworkIssueRequest extends AbstractSupportRequest {
	
	private int affectedUsers;
	
	public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
		super(id, title, basePoints);
		if (affectedUsers <= 0) {
			throw new IllegalArgumentException("Affected users must be greater than 0.");
		}
		this.affectedUsers = affectedUsers;
	}

	@Override
	public int getAwardedPoints() {
		return getBasePoints() + affectedUsers; // linear rule
	}
	
	
}
