/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mantovanello.poc.frezze.dto.TrackTO;
import com.mantovanello.poc.frezze.service.TrackRecommendationsService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Mantovanello
 *
 */
@RestController
public class TrackRecommendationsController {

	@Autowired
	private TrackRecommendationsService trackRecommendationsService;

	/**
	 * Call service layer to retrieve Spotify's fixed track recommendations
	 * previously saved in database
	 * 
	 * CORS properties added to work with requests from specific domains
	 */
	@RequestMapping(value = "/list-recommendations", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = { "http://179.159.58.65:4200", "https://frezze-app-poc.firebaseapp.com" })
	@ApiOperation(value = "List previous fetched track recommendations saved in database.", response = TrackTO.class)
	public ResponseEntity<List<TrackTO>> listRecommendations() {
		return ResponseEntity.ok(trackRecommendationsService.listRecommendations());
	}

}
