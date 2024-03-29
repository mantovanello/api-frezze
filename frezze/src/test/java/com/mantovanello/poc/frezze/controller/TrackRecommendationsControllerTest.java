/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Mantovanello
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TrackRecommendationsControllerTest {

	@Autowired
	private MockMvc mvc;

	/**
	 * Verify if list-recommendations is successfully executed
	 */
	@Test
	public void shouldReturnTrackRecommendationsList() throws Exception {
		this.mvc.perform(get("/list-recommendations")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.length()", greaterThanOrEqualTo(100)));
	}

}
