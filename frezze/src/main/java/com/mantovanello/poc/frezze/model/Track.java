/**
 * 
 */
package com.mantovanello.poc.frezze.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Mantovanello
 *
 */
@Entity
public class Track {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@EmbeddedId
	private TrackId trackId;
	private String albumURL;
	private String albumThumbnailURL;
	private String albumReleaseDate;
	private String albumReleaseDatePrecision;
	private String artistURL;
	private Long trackDuration;
	private String trackURL;
	private Integer trackNumber;

	protected Track() {

	}

	public Track(TrackId trackId, String albumURL, String albumThumbnailURL, String albumReleaseDate,
			String albumReleaseDatePrecision, String artistURL, Long trackDuration, String trackURL,
			Integer trackNumber) {
		this.trackId = trackId;
		this.albumURL = albumURL;
		this.albumThumbnailURL = albumThumbnailURL;
		this.albumReleaseDate = albumReleaseDate;
		this.albumReleaseDatePrecision = albumReleaseDatePrecision;
		this.artistURL = artistURL;
		this.trackDuration = trackDuration;
		this.trackURL = trackURL;
		this.trackNumber = trackNumber;
	}

	public TrackId getTrackId() {
		return trackId;
	}

	public void setTrackId(TrackId trackId) {
		this.trackId = trackId;
	}

	public String getAlbumURL() {
		return albumURL;
	}

	public void setAlbumURL(String albumURL) {
		this.albumURL = albumURL;
	}

	public String getAlbumThumbnailURL() {
		return albumThumbnailURL;
	}

	public void setAlbumThumbnailURL(String albumThumbnailURL) {
		this.albumThumbnailURL = albumThumbnailURL;
	}

	public String getAlbumReleaseDate() {
		return albumReleaseDate;
	}

	public void setAlbumReleaseDate(String albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public String getAlbumReleaseDatePrecision() {
		return albumReleaseDatePrecision;
	}

	public void setAlbumReleaseDatePrecision(String albumReleaseDatePrecision) {
		this.albumReleaseDatePrecision = albumReleaseDatePrecision;
	}

	public String getArtistURL() {
		return artistURL;
	}

	public void setArtistURL(String artistURL) {
		this.artistURL = artistURL;
	}

	public Long getTrackDuration() {
		return trackDuration;
	}

	public void setTrackDuration(Long trackDuration) {
		this.trackDuration = trackDuration;
	}

	public String getTrackURL() {
		return trackURL;
	}

	public void setTrackURL(String trackURL) {
		this.trackURL = trackURL;
	}

	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	@Override
	public String toString() {
		return String.format(
				"Track [id=%s, trackId=%s, albumURL=%s, albumThumbnailURL=%s, albumReleaseDate=%s, albumReleaseDatePrecision=%s, artistURL=%s, trackDuration=%s, trackURL=%s, trackNumber=%s]",
				id, trackId, albumURL, albumThumbnailURL, albumReleaseDate, albumReleaseDatePrecision, artistURL,
				trackDuration, trackURL, trackNumber);
	}

}
