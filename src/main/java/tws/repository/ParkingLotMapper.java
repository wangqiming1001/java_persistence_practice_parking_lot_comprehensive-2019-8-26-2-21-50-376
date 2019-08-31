package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.dto.ParkingDto;
import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {

	List<ParkingLot> selectAll();

	void insertParkingLot(@Param(value="parkingLot") ParkingLot parkingLot);
	
	List<ParkingLot> selectByParkingBoyID(@Param(value="parkingBoyID") String parkingBoyID);
	
	
}
