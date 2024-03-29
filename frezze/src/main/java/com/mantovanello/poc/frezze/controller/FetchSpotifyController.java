/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mantovanello.poc.frezze.service.FetchSpotifyService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Mantovanello
 *
 */
@RestController
public class FetchSpotifyController {

	@Autowired
	private FetchSpotifyService fetchSpotifyService;

	/**
	 * Call service layer to authenticate and retrieve data from Spotify's public
	 * API
	 */
	@RequestMapping(value = "/fetch-recommendations", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Retrieve track recommendations data from Spotify API with a set of fixed parameters.", response = String.class)
	public ResponseEntity<String> fetchRecommendations() {
		String token = fetchSpotifyService.getSimpleClientToken();
		return ResponseEntity.ok(fetchSpotifyService.fetchRecommendations(token));
	}

}
