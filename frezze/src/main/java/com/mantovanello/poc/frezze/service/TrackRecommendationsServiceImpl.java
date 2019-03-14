/**
 * 
 */
package com.mantovanello.poc.frezze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mantovanello.poc.frezze.repository.TrackRepository;

/**
 * @author Mantovanello
 *
 */
@Service
public class TrackRecommendationsServiceImpl implements TrackRecommendationsService {
	@Autowired
	private TrackRepository repository;
	String response = null;
	
	@Override
	public String listRecommendations(String orderBy) {
		repository.findAll().forEach(track -> System.out.println(track.toString()));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(!orderBy.isEmpty() && orderBy != null) {
				response = mapper.writeValueAsString(repository.findByAlbumReleaseDateLikeOrderByArtistNameAscAlbumTitleAscTrackTitleAsc("%198%"));
			} else
				response = mapper.writeValueAsString(repository.findAll());
			System.out.println(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
