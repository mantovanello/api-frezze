/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantovanello.poc.frezze.dto.TrackRecommendationsResponseTO;
import com.mantovanello.poc.frezze.service.TrackRecommendationsService;

/**
 * @author Mantovanello
 *
 */
@RestController
public class TrackRecommendationsController {
	@Autowired
	private TrackRecommendationsService trackRecommendationsService;

	@RequestMapping(value = "/list-recommendations")
	public ResponseEntity<TrackRecommendationsResponseTO> listRecommendations() {
		return new ResponseEntity<>(trackRecommendationsService.listRecommendations(), HttpStatus.OK);
	}
}
