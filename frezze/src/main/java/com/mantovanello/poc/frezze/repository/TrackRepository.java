/**
 * 
 */
package com.mantovanello.poc.frezze.repository;

import org.springframework.data.repository.CrudRepository;

import com.mantovanello.poc.frezze.model.Track;

/**
 * @author Mantovanello
 *
 */
public interface TrackRepository extends CrudRepository<Track, Long> {
	public Iterable<Track> findByAlbumTitleLikeOrderByAlbumTitleAscTrackTitleAsc(String albumTitle);
	public Iterable<Track> findByAlbumReleaseDateLikeOrderByArtistNameAscAlbumTitleAscTrackTitleAsc(String albumReleaseDate);
	public Iterable<Track> findByArtistNameLikeOrderByArtistNameAscTrackTitleAsc(String artistName);
	public Iterable<Track> findByTrackTitleLikeOrderByTrackTitleAsc(String trackTitle);
	public Iterable<Track> findByTrackNumberOrderByArtistNameAscTrackTitleAsc(Integer trackNumber);
	public Iterable<Track> findAllByOrderByAlbumTitleAsc();
	public Iterable<Track> findAllByOrderByAlbumTitleDesc();
	public Iterable<Track> findAllByOrderByArtistNameAsc();
	public Iterable<Track> findAllByOrderByArtistNameDesc();
	public Iterable<Track> findAllByOrderByTrackDurationAsc();
	public Iterable<Track> findAllByOrderByTrackDurationDesc();
	public Iterable<Track> findAllByOrderByTrackTitleAsc();
	public Iterable<Track> findAllByOrderByTrackTitleDesc();
	public Iterable<Track> findAllByOrderByTrackNumberAsc();
	public Iterable<Track> findAllByOrderByTrackNumberDesc();
}
