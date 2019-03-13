/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mantovanello
 *
 */

@Service
public class FetchSpotifyServiceImpl implements FetchSpotifyService {
	@Autowired
	RestTemplate restTemplate;
	private static final int LIMIT = 5;

	@Override
	public <T> Collection<T> getRecommendations() {
		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		authHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		authHeaders.setBasicAuth("143b789afb6548598e2df1d7494531ab", "c67ae18e2d1a4edba3cc8a31225726e5");

		HttpEntity<?> authEntity = new HttpEntity<>("grant_type=client_credentials", authHeaders);

		String authResponse = restTemplate
				.exchange("https://accounts.spotify.com/api/token", HttpMethod.POST, authEntity, String.class)
				.getBody();

		System.out.println(authResponse);
		String token = authResponse.replaceAll("[{}\":,]", " ").split("\\s+")[2];
		System.out.println(token);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(token);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/recommendations")
				.queryParam("limit", Integer.toString(LIMIT)).queryParam("market", "BR").queryParam("seed_genres", "rock")
				.queryParam("target_energy", "0.5").queryParam("target_popularity", "90")
				.queryParam("target_valence", "0.7");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj = mapper.readTree(response);

			for (int i = 0; i < LIMIT; i++) {
				String albumURL = actualObj.path("tracks").path(i).path("album").path("external_urls").path("spotify").asText();
				String albumThumbnailURL = actualObj.path("tracks").path(i).path("album").path("images").path(2)
						.path("url").asText();
				String albumTitle = actualObj.path("tracks").path(i).path("album").path("name").asText();
				String albumReleaseDate = actualObj.path("tracks").path(i).path("album").path("release_date").asText();
				String albumReleaseDatePrecision = actualObj.path("tracks").path(i).path("album").path("release_date_precision")
						.asText();
				String artistURL = actualObj.path("tracks").path(i).path("artists").path(0).path("external_urls").path("spotify")
						.asText();
				String artistName = actualObj.path("tracks").path(i).path("artists").path(0).path("name").asText();
				long trackDuration = actualObj.path("tracks").path(i).path("duration_ms").asLong();
				String trackURL = actualObj.path("tracks").path(i).path("external_urls").path("spotify").asText();
				String trackTitle = actualObj.path("tracks").path(i).path("name").asText();
				String trackNumber = actualObj.path("tracks").path(i).path("track_number").asText();
				
				System.out.println("teste");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(response);

		return null;
	}

}
