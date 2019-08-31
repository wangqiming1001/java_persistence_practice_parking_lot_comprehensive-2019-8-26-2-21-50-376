package tws.dto;

public class ParkingDto {
	private String parkingBoyID;
	private String parkingBoyName;
	private String parkingLotID;
	private int capacity;
	private int availablePositionCount;
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
	public String getParkingLotID() {
		return parkingLotID;
	}
	public void setParkingLotID(String parkingLotID) {
		this.parkingLotID = parkingLotID;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailablePositionCount() {
		return availablePositionCount;
	}
	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}
	
}
