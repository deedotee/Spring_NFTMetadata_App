package com.qa.springnftdata.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springnftdata.entities.NFTInstance;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class NFTControllerTest {

	@Autowired
	private MockMvc mvc; // used for sending mock requests
	
	@Autowired
	private ObjectMapper mapper; // used for converting objects to JSON
	
	@Test
	public void createTest() throws Exception {
		NFTInstance entry = new NFTInstance("a","b","c",1,"d");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		NFTInstance result = new NFTInstance(2L,"a", "b", "c", 1,"d");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(entryAsJSON))
					.andExpect(content().json(resultAsJSON));	
	}
	
	
	@Test
	public void readAllTest() throws Exception {
		// Setting up expected output object
		List<NFTInstance> output = new ArrayList<>();
		NFTInstance entry = new NFTInstance(1L,"Ringers#376", "blue", "Normal", 9,"Balanced");
		output.add(entry);
		//Convert expected output to JSON
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/readAll")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(content().json(outputAsJSON));			
	}
		
	@Test
	public void readByIdTest() throws Exception {
		NFTInstance entry = new NFTInstance(1L,"Ringers#376", "blue", "Normal", 9,"Balanced");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/readById/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(content().json(entryAsJSON));			
	}
	
	@Test
	public void updateTest() throws Exception {
			NFTInstance entry = new NFTInstance ("Ringers#376", "blue", "Normal", 9,"Balanced");
			NFTInstance result = new NFTInstance (1L,"Ringers#376", "blue", "Normal", 9,"Balanced");
			String entryAsJSON = this.mapper.writeValueAsString(entry);
			String resultAsJSON = this.mapper.writeValueAsString(result);

			mvc.perform(put("/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(content().json(resultAsJSON));	
	}
	
	@Test
	public void deleteTest() throws Exception {
			mvc.perform(delete("/delete/1")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(content().string("true"));
	}
	
	
	
}
