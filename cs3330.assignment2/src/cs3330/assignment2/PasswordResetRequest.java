package cs3330.assignment2;

public class PasswordResetRequest extends AbstractSupportRequest {
	
	private String accountName;
	
	public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
		super(id, title, basePoints);
		
		if (accountName == null || accountName.isBlank()) {
			throw new IllegalArgumentException("The account name cannot be blank or null.");
		}
		
		this.accountName = accountName;
	}
}
