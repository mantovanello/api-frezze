/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mantovanello.poc.frezze.dto.TrackRecommendationsResponseTO;
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

	@RequestMapping(value = "/api/list-recommendations", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "List previous fetched track recommendations saved in database.", response = TrackRecommendationsResponseTO.class)
	public ResponseEntity<TrackRecommendationsResponseTO> listRecommendations() {
		return ResponseEntity.ok(trackRecommendationsService.listRecommendations());
	}
}
