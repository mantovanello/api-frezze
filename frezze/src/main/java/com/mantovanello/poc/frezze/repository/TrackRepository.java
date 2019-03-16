/**
 * 
 */
package com.mantovanello.poc.frezze.repository;

import org.springframework.data.repository.CrudRepository;

import com.mantovanello.poc.frezze.model.Track;
import com.mantovanello.poc.frezze.model.TrackId;

/**
 * @author Mantovanello
 *
 */
public interface TrackRepository extends CrudRepository<Track, TrackId> {
	
}
