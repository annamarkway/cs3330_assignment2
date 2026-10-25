package cs3330.assignment2;

public class DeviceSetupRequest extends AbstractSupportRequest {
	
	private int deviceCount;

	public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
		super(id, title, basePoints);
		
		if (deviceCount <= 0) {
			throw new IllegalArgumentException("Affected devices must be greater than 0.");
		}
		
		this.deviceCount = deviceCount;
	}
	
	@Override
	public int getAwardedPoints() {
		return getBasePoints() * deviceCount;
	}
	
}
