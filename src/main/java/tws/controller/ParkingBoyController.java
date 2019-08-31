package tws.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tws.dto.ParkingDto;
import tws.entity.ParkingBoy;
import tws.service.ParkingBoyService;

@RestController
@RequestMapping("/parkingboy")
public class ParkingBoyController {
	
	@Autowired
	private ParkingBoyService parkingBoyService;
	
	
    @PostMapping("/insert")
    public ResponseEntity<ParkingBoy> insertParkingBoy(@RequestBody ParkingBoy parkingBoy) {
    	parkingBoyService.insertParkingBoy(parkingBoy);
        return ResponseEntity.created(URI.create(URI.create("/employees")+parkingBoy.getParkingBoyID())).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ParkingBoy>> getAll() {
        return ResponseEntity.ok(parkingBoyService.getAll());
    }
    
    @GetMapping("/parkingboyId/{parkingBoyID}")
    public ResponseEntity<Map<String,Object>> getByParkingBoyId(@PathVariable String parkingBoyID) {
        return ResponseEntity.ok(parkingBoyService.getInfoByParkingBoyId(parkingBoyID));
    }
}
