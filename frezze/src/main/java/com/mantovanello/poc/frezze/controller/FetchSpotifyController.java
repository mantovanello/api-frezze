/**
 * 
 */
package com.mantovanello.poc.frezze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantovanello.poc.frezze.service.FetchSpotifyService;

/**
 * @author Mantovanello
 *
 */
@RestController
public class FetchSpotifyController {
	@Autowired
	FetchSpotifyService fetchSpotifyService;
	
	@RequestMapping(value = "/fetch-recommendations")
	public ResponseEntity<Object> getRecommendations() {
		return new ResponseEntity<>(fetchSpotifyService.getRecommendations(), HttpStatus.OK);
	}
}
