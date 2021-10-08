package com.jenkins.SpringbootwithJenkins;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class SpringbootwithJenkinsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllRides() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/rides")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

	}

	@Test
	public void getSingleRide() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	@Test
	public  void resultNotFoundForSingleRide() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/ride/9")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andReturn();
	}

	@Test
	public void createRide() throws Exception{
		String newRide = "{\"name\":\"Porsche\",\"description\":\"Tycon and Performace.\",\"speed\":200,\"review\":5}";
		mockMvc.perform(MockMvcRequestBuilders.post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newRide)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

}
