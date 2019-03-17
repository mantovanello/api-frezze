/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import java.util.List;

import com.mantovanello.poc.frezze.dto.TrackTO;

/**
 * @author Mantovanello
 *
 */
public interface TrackRecommendationsService {
	
	public abstract List<TrackTO> listRecommendations();
	
}
