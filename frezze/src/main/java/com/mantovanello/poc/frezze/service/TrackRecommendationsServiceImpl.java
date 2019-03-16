/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantovanello.poc.frezze.dto.TrackRecommendationsResponseTO;
import com.mantovanello.poc.frezze.dto.TrackTO;
import com.mantovanello.poc.frezze.exception.TrackRecommendationsNoContentException;
import com.mantovanello.poc.frezze.model.Track;
import com.mantovanello.poc.frezze.repository.TrackRepository;

/**
 * @author Mantovanello
 *
 */
@Service
public class TrackRecommendationsServiceImpl implements TrackRecommendationsService {

	private static final Logger logger = LoggerFactory.getLogger(TrackRecommendationsServiceImpl.class);
	
	@Autowired
	private TrackRepository repository;

	@Override
	public TrackRecommendationsResponseTO listRecommendations() {
		List<TrackTO> trackRecommendationsList = new ArrayList<>();
		Iterable<Track> allTrackRecommendations = repository.findAll();

		if (!allTrackRecommendations.iterator().hasNext()) {
			logger.error("No records found in database for track recommendations.");
			throw new TrackRecommendationsNoContentException();
		}

		logger.info("Track recommendations retrieved from database: ");
		allTrackRecommendations.forEach(track -> {
			logger.info(track.toString());
			trackRecommendationsList.add(new TrackTO(track));
		});

		return new TrackRecommendationsResponseTO(trackRecommendationsList);
	}

}
