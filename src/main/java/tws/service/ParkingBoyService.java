package tws.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.dto.ParkingDto;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingBoyService {

	@Autowired
	private ParkingBoyMapper parkingBoyMapper;

	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
	
	public ParkingBoy insertParkingBoy(ParkingBoy parkingboy) {
    	String parkingBoyID = UUID.randomUUID().toString();
    	parkingboy.setParkingBoyID(parkingBoyID);;
    	parkingBoyMapper.insertParkingBoy(parkingboy);
        return parkingboy;
    }
	
	 public List<ParkingBoy> getAll() {
		 List<ParkingBoy> parkingBoy = parkingBoyMapper.selectAll();
	     return parkingBoy;
	 }
	 
	 public Map<String,Object> getInfoByParkingBoyId(String parkingBoyID) {
		 Map<String,Object> parkingBoy = new HashMap<String,Object>();
		 parkingBoy = parkingBoyMapper.selectByParkingBoyId(parkingBoyID);
	//	 parkingBoy = parkingBoyList.stream().collect(Collectors.toMap( ,Function.identity(), (key1, key2) -> key2));
	//	 parkingBoy = parkingBoyList.stream().collect(Collectors.toMap(ParkingBoy::getParkingBoyID, ParkingBoy::getParkingBoyName));
		 List<ParkingLot> parkingLot = parkingLotMapper.selectByParkingBoyID(parkingBoyID);
		 parkingBoy.put("parkingLot", parkingLot);
	     return parkingBoy;
	 }
	
}
