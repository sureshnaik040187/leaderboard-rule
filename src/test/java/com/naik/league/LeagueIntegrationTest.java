package com.naik.league;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naik.league.controller.model.LeagueModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = {LeagueApplication.class})
public class LeagueIntegrationTest {

	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
	    objectMapper = new ObjectMapper();
	}

	@Test
	public void whenDataNotFoundForTheValidRequest_shouldReturn204() throws Exception {
		LeagueModel leagueModel = new LeagueModel();
		leagueModel.setCountry_name("Germany");
		leagueModel.setTeam_name("Leicester");
		leagueModel.setLeague_name("Premier League");

		this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/league")
			.contentType(MediaType.APPLICATION_JSON)
			.content(this.objectMapper.writeValueAsString(leagueModel)))
			.andExpect(MockMvcResultMatchers.status().isNoContent())
			.andReturn();
	}

	@Test
	public void whenDataFoundForTheValidRequest_shouldReturn200() throws Exception {
		LeagueModel leagueModel = new LeagueModel();
		leagueModel.setCountry_name("England");
		leagueModel.setTeam_name("Leeds");
		leagueModel.setLeague_name("Championship");

		this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/league")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.objectMapper.writeValueAsString(leagueModel)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	@Test
	public void whenCountryName_isEmpty_shouldReturn400() throws Exception {
		LeagueModel leagueModel = new LeagueModel();
		leagueModel.setCountry_name("");
		leagueModel.setTeam_name("Leeds");
		leagueModel.setLeague_name("Championship");

		this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/league")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.objectMapper.writeValueAsString(leagueModel)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andReturn();
	}
}
