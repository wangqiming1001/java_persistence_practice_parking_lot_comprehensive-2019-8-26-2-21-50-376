package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.ParkingBoy;

@Mapper
public interface ParkingBoyMapper {

	void insertParkingBoy(@Param(value="parkingBoy") ParkingBoy parkingBoy);

	List<ParkingBoy> selectAll();
}
