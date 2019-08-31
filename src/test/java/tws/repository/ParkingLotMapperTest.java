package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingLotMapperTest {
	
	    @Autowired
	    private ParkingLotMapper ParkingLotMapper;
	
	    JdbcTemplate jdbcTemplate;
	
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    @Before
	    public void clearDB() {
	     JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
	    }

		@After
		public void tearDown() throws Exception {
		    JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
		}
		
		@Test
		public void should_get_parkinglot_list_when_select_parkinglot() {
		    // given
			jdbcTemplate.execute("INSERT INTO parkinglot VALUES('1',2,1,'aaa')");
			// when
			List<ParkingLot> parkingLotList = ParkingLotMapper.selectAll();
			// then
			assertEquals("1", parkingLotList.get(0).getParkingLotID());
			assertEquals(2, parkingLotList.get(0).getCapacity());
			assertEquals(1, parkingLotList.get(0).getAvailablePositionCount());
			assertEquals("aaa", parkingLotList.get(0).getParkingBoyID());
		}
		
		@Test
		public void should_insert_parkinglot_when_insert_parkinglot() {
			// given
			ParkingLot parkinglot = new ParkingLot();
			parkinglot.setParkingLotID("123");
			parkinglot.setCapacity(3);
			parkinglot.setAvailablePositionCount(2);
			parkinglot.setParkingBoyID("456");
			// when
			ParkingLotMapper.insertParkingLot(parkinglot);
			List<ParkingLot> parkingLotList = ParkingLotMapper.selectAll();
			// then
			assertEquals("123", parkingLotList.get(0).getParkingLotID());
			assertEquals(3, parkingLotList.get(0).getCapacity());
			assertEquals(2, parkingLotList.get(0).getAvailablePositionCount());
			assertEquals("456", parkingLotList.get(0).getParkingBoyID());
		}
		
		@Test
		public void should_return_parkinglot_when_select_parkinglot_by_parkingboy_id() {
		    // given
			jdbcTemplate.execute("INSERT INTO parkinglot VALUES('1',2,1,'aaa')");
			// when
			List<ParkingLot> parkingLotList = ParkingLotMapper.selectByParkingBoyID("aaa");
			// then
			assertEquals("1", parkingLotList.get(0).getParkingLotID());
			assertEquals(2, parkingLotList.get(0).getCapacity());
			assertEquals(1, parkingLotList.get(0).getAvailablePositionCount());
			assertEquals("aaa", parkingLotList.get(0).getParkingBoyID());
		}
		    
    
}

