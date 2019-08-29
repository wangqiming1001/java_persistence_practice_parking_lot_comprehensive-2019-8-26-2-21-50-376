package tws.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {

	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
	 @GetMapping("")
	    public ResponseEntity<List<ParkingLot>> getAll() {
	        return ResponseEntity.ok(parkingLotMapper.selectAll());
	    }
	 
	 @PostMapping("/insert")
	    public ResponseEntity<ParkingLot> insertEmployee(@RequestBody ParkingLot parkingLot) {
	    	String parkingboyID = UUID.randomUUID().toString();
	    	parkingLot.setParkingBoyID(parkingboyID);;
	    	parkingLotMapper.insertParkingLot(parkingLot);
	        return ResponseEntity.created(URI.create(URI.create("/parkinglot")+parkingLot.getParkingLotID())).build();
	    }
}
