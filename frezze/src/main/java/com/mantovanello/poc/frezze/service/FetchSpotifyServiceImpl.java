/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mantovanello.poc.frezze.model.Track;
import com.mantovanello.poc.frezze.model.TrackId;
import com.mantovanello.poc.frezze.repository.TrackRepository;

/**
 * @author Mantovanello
 *
 */

@Service
public class FetchSpotifyServiceImpl implements FetchSpotifyService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TrackRepository repository;

	private static final int LIMIT = 100;

	@Override
	public String fetchRecommendations() {
		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		authHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		authHeaders.setBasicAuth("143b789afb6548598e2df1d7494531ab", "c67ae18e2d1a4edba3cc8a31225726e5");

		HttpEntity<?> authEntity = new HttpEntity<>("grant_type=client_credentials", authHeaders);

		String authResponse = restTemplate
				.exchange("https://accounts.spotify.com/api/token", HttpMethod.POST, authEntity, String.class)
				.getBody();

		String token = authResponse.replaceAll("[{}\":,]", " ").split("\\s+")[2];
		System.out.println(token);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(token);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.spotify.com/v1/recommendations")
				.queryParam("limit", Integer.toString(LIMIT)).queryParam("market", "BR")
				.queryParam("seed_genres", "rock").queryParam("target_energy", "0.5")
				.queryParam("target_popularity", "90").queryParam("target_valence", "0.7");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj = mapper.readTree(response);

			for (int i = 0; i < LIMIT; i++) {
				repository.save(new Track(
						new TrackId(
								actualObj.path("tracks").path(i).path("album").path("name").asText(),
								actualObj.path("tracks").path(i).path("artists").path(0).path("name").asText(),
								actualObj.path("tracks").path(i).path("name").asText()),
						actualObj.path("tracks").path(i).path("album").path("external_urls").path("spotify").asText(),
						actualObj.path("tracks").path(i).path("album").path("images").path(2).path("url").asText(),
						actualObj.path("tracks").path(i).path("album").path("release_date").asText(),
						actualObj.path("tracks").path(i).path("album").path("release_date_precision").asText(),
						actualObj.path("tracks").path(i).path("artists").path(0).path("external_urls").path("spotify")
								.asText(),
						actualObj.path("tracks").path(i).path("duration_ms").asLong(),
						actualObj.path("tracks").path(i).path("external_urls").path("spotify").asText(),
						actualObj.path("tracks").path(i).path("track_number").asInt()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "{\"sucesso\" : \"Fetch de dados finalizado.\"}";
	}

}
