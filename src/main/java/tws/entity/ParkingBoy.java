package tws.entity;

public class ParkingBoy {

	private String parkingBoyID;
	private String parkingBoyName;
	public String parkingBoyID() {
		return parkingBoyID;
	}

	public String getParkingBoyID() {
		return parkingBoyID;
	}

	public void setParkingBoyID(String parkingBoyID) {
		this.parkingBoyID = parkingBoyID;
	}

	public String getParkingBoyName() {
		return parkingBoyName;
	}

	public void setParkingBoyName(String parkingBoyName) {
		this.parkingBoyName = parkingBoyName;
	}

	public ParkingBoy(String parkingBoyID, String parkingBoyName) {
		super();
		this.parkingBoyID = parkingBoyID;
		this.parkingBoyName = parkingBoyName;
	}
	
	
	
}
