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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingBoyMapperTest {

	    @Autowired
	    private ParkingBoyMapper parkingBoyMapper;

	    JdbcTemplate jdbcTemplate;

	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    @Before
	    public void clearDB() {
	     JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
	    }

	    @After
	    public void tearDown() throws Exception {
	        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
	    }

	    @Test
	    public void should_get_parkingboy_list_when_select_parkingboy() {
	        // given
	    	jdbcTemplate.execute("INSERT INTO parkingboy VALUES('11', 'aaa')");
	        // when
	        List<ParkingBoy> parkingBoyList = parkingBoyMapper.selectAll();
	        // then
	        assertEquals("11", parkingBoyList.get(0).getParkingBoyID());
	        assertEquals("aaa", parkingBoyList.get(0).getParkingBoyName());
	    }
	    
	    @Test
	    public void should_insert_parkingboy_when_insert_parkingboy() {
	        // given
	    	ParkingBoy parkingBoy = new ParkingBoy();
	    	parkingBoy.setParkingBoyID("123");
	    	parkingBoy.setParkingBoyName("aaa");
	        // when
	        parkingBoyMapper.insertParkingBoy(parkingBoy);
	        List<ParkingBoy> parkingBoyList = parkingBoyMapper.selectAll();
	        // then
	        assertEquals("123", parkingBoyList.get(0).getParkingBoyID());
	        assertEquals("aaa", parkingBoyList.get(0).getParkingBoyName());
	    }
	    
	    @Test
	    public void should_return_parkingboy_when_select_parkingboy_by_id() {
	        // given
	    	jdbcTemplate.execute("INSERT INTO parkingboy VALUES('11', 'aaa')");
	        // when
	    	Map<String,Object> parkingBoyMap = parkingBoyMapper.selectByParkingBoyId("11");
	        // then
	        assertEquals("11", parkingBoyMap.get("parkingBoyID"));
	        assertEquals("aaa", parkingBoyMap.get("parkingBoyName"));
	    }
	    
	    
	    
	    
	}
