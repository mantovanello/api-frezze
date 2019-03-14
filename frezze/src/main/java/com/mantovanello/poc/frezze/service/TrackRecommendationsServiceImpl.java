/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantovanello.poc.frezze.dto.TrackRecommendationsResponseTO;
import com.mantovanello.poc.frezze.dto.TrackTO;
import com.mantovanello.poc.frezze.repository.TrackRepository;

/**
 * @author Mantovanello
 *
 */
@Service
public class TrackRecommendationsServiceImpl implements TrackRecommendationsService {
	@Autowired
	private TrackRepository repository;

	@Override
	public TrackRecommendationsResponseTO listRecommendations() {
		List<TrackTO> trackRecommendationsList = new ArrayList<>();
		repository.findAll().forEach(track -> trackRecommendationsList.add(new TrackTO(track)));
		return new TrackRecommendationsResponseTO(trackRecommendationsList);
	}

}
