/**
 * 
 */
package com.mantovanello.poc.frezze.dto;

import java.util.List;

/**
 * @author Mantovanello
 *
 */
public class TrackRecommendationsResponseTO {
	private List<TrackTO> trackRecommendationsList;
	
	public TrackRecommendationsResponseTO() {}

	public TrackRecommendationsResponseTO(List<TrackTO> trackRecommendationsList) {
		this.trackRecommendationsList = trackRecommendationsList;
	}

	public List<TrackTO> getTrackRecommendationsList() {
		return trackRecommendationsList;
	}

	public void setTrackRecommendationsList(List<TrackTO> trackRecommendationsList) {
		this.trackRecommendationsList = trackRecommendationsList;
	}
}
