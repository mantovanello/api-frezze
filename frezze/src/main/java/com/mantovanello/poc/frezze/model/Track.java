/**
 * 
 */
package com.mantovanello.poc.frezze.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Mantovanello
 *
 */
@Entity
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String albumURL;
	private String albumThumbnailURL;
	private String albumTitle;
	private String albumReleaseDate;
	private String albumReleaseDatePrecision;
	private String artistURL;
	private String artistName;
	private Long trackDuration;
	private String trackURL;
	private String trackTitle;
	private Integer trackNumber;

	protected Track() {
	}

	public Track(String albumURL, String albumThumbnailURL, String albumTitle, String albumReleaseDate,
			String albumReleaseDatePrecision, String artistURL, String artistName, Long trackDuration, String trackURL,
			String trackTitle, Integer trackNumber) {

		this.albumURL = albumURL;
		this.albumThumbnailURL = albumThumbnailURL;
		this.albumTitle = albumTitle;
		this.albumReleaseDate = albumReleaseDate;
		this.albumReleaseDatePrecision = albumReleaseDatePrecision;
		this.artistURL = artistURL;
		this.artistName = artistName;
		this.trackDuration = trackDuration;
		this.trackURL = trackURL;
		this.trackTitle = trackTitle;
		this.trackNumber = trackNumber;
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

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
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

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
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

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
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
				"Track [id=%s, albumURL=%s, albumThumbnailURL=%s, albumTitle=%s, albumReleaseDate=%s, albumReleaseDatePrecision=%s, artistURL=%s, artistName=%s, trackDuration=%s, trackURL=%s, trackTitle=%s, trackNumber=%s]",
				id, albumURL, albumThumbnailURL, albumTitle, albumReleaseDate, albumReleaseDatePrecision, artistURL,
				artistName, trackDuration, trackURL, trackTitle, trackNumber);
	}

}
