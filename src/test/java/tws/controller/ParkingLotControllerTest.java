package tws.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void should_return_201_status_when_create_parkingboy() throws Exception {
		//Given
		MockHttpServletRequestBuilder input = post("/parkingboy/insert").content("{\"parkingBoyID\":\"123\",\"parkingBoyName\":\"aaa\"}").contentType(MediaType.APPLICATION_JSON);
		//When
		ResultActions result = mockMvc.perform(input);
		//Then
		result
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isCreated());
	}

	@Test
	public void should_return_ok_and_content_when_query_all_parkingboy() throws Exception {
		//Given
		MockHttpServletRequestBuilder input = post("/parkingboy/insert").content("{\"parkingBoyName\":\"aaa\"}").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(input);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/parkingboy/getAll");
		//When
		ResultActions performResult = mockMvc.perform(requestBuilder);
		//Then
		performResult
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(
		          MockMvcResultMatchers.jsonPath(
		            "$.size()", 
		            CoreMatchers.is(1)
		          )
		   );
	}
	
	
}
