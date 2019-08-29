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

import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

@RestController
@RequestMapping("/parkingboy")
public class ParkingBoyController {
	
	@Autowired
	private ParkingBoyMapper parkingboyMapper;
	
	
    @PostMapping("/insert")
    public ResponseEntity<ParkingBoy> insertEmployee(@RequestBody ParkingBoy parkingboy) {
    	String parkingboyID = UUID.randomUUID().toString();
    	parkingboy.setParkingBoyID(parkingboyID);;
    	parkingboyMapper.insertParkingBoy(parkingboy);
        return ResponseEntity.created(URI.create(URI.create("/employees")+parkingboy.getParkingBoyID())).build();
    }

    @GetMapping("")
    public ResponseEntity<List<ParkingBoy>> getAll() {
        return ResponseEntity.ok(parkingboyMapper.selectAll());
    }
    
}
