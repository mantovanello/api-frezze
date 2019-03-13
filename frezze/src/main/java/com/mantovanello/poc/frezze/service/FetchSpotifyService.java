/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import java.util.Collection;

/**
 * @author Mantovanello
 *
 */
public interface FetchSpotifyService {
	public abstract <T> Collection<T> getRecommendations();
}
