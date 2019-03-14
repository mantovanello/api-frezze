/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantovanello.poc.frezze.service.TrackRecommendationsService;

/**
 * @author Mantovanello
 *
 */
@RestController
public class TrackRecommendationsController {
	@Autowired
	TrackRecommendationsService trackRecommendationsService;
	
	@RequestMapping(value = "/list-recommendations")
	public ResponseEntity<Object> listRecommendations(@RequestParam String orderBy) {
		String response = null;
		
		if(!orderBy.isEmpty() && orderBy != null)
			response = trackRecommendationsService.listRecommendations(orderBy);
		else
			response = trackRecommendationsService.listRecommendations(null);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
