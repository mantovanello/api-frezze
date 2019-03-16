/**
 * 
 */
package com.mantovanello.poc.frezze.dto;

import com.mantovanello.poc.frezze.model.Track;

/**
 * @author Mantovanello
 *
 */
public class TrackTO {

	private String albumURL;
	private String albumThumbnailURL;
	private String albumTitle;
	private String albumReleaseDate;
	private String artistURL;
	private String artistName;
	private Long trackDuration;
	private String trackURL;
	private String trackTitle;
	private Integer trackNumber;

	public TrackTO(Track track) {
		this.albumURL = track.getAlbumURL();
		this.albumThumbnailURL = track.getAlbumThumbnailURL();
		this.albumTitle = track.getTrackId().getAlbumTitle();
		this.albumReleaseDate = track.getAlbumReleaseDate();
		this.artistURL = track.getArtistURL();
		this.artistName = track.getTrackId().getArtistName();
		this.trackDuration = track.getTrackDuration();
		this.trackURL = track.getTrackURL();
		this.trackTitle = track.getTrackId().getTrackTitle();
		this.trackNumber = track.getTrackNumber();
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

}
