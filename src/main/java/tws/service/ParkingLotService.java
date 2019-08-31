package tws.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingLotService {

	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
	public List<ParkingLot> getAll() {
	    return parkingLotMapper.selectAll();
	}
	
	public ParkingLot insertParkingLot(ParkingLot parkingLot) {
		String parkingLotID = UUID.randomUUID().toString();
		parkingLot.setParkingLotID(parkingLotID);
		parkingLotMapper.insertParkingLot(parkingLot);
	    return parkingLot;
	}
	
	
	
}
