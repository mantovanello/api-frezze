/**
 * 
 */
package com.mantovanello.poc.frezze.service;

/**
 * @author Mantovanello
 *
 */
public interface FetchSpotifyService {
	
	public abstract String fetchRecommendations(String token);
	public abstract String getSimpleClientToken();
	
}
