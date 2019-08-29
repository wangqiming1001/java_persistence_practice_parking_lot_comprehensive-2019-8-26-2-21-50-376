package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
public class ParkingBoyControllerTest {

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
	    public void shouldGetParkingBoyWhenCallInsertParkingBoy() {
	        // given
	    	jdbcTemplate.execute("INSERT INTO parkingboy VALUES('11', 'aaa')");
	        // when
	        List<ParkingBoy> parkingBoyList = parkingBoyMapper.selectAll();
	        // then
	        assertEquals("11", parkingBoyList.get(0).getParkingBoyID());
	        assertEquals("aaa", parkingBoyList.get(0).getParkingBoyName());
	    }
	}
