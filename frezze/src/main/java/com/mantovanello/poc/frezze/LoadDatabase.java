/**
 * 
 */
package com.mantovanello.poc.frezze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.mantovanello.poc.frezze.controller.FetchSpotifyController;

/**
 * @author Mantovanello
 *
 *         Load new track recommendations retrieved from Spotify's public API
 *         into database
 */
@Component
public class LoadDatabase {

	@Autowired
	private FetchSpotifyController fetchSpotifyController;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		fetchSpotifyController.fetchRecommendations();
	}

}
