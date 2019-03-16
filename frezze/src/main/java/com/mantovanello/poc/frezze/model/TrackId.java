/**
 * 
 */
package com.mantovanello.poc.frezze.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author Mantovanello
 *
 */
@Embeddable
public class TrackId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String albumTitle;
	private String artistName;
	private String trackTitle;

	protected TrackId() {

	}

	public TrackId(String albumTitle, String artistName, String trackTitle) {
		this.albumTitle = albumTitle;
		this.artistName = artistName;
		this.trackTitle = trackTitle;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

	@Override
	public String toString() {
		return String.format("TrackId [albumTitle=%s, artistName=%s, trackTitle=%s]", albumTitle, artistName,
				trackTitle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumTitle, artistName, trackTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TrackId)) {
			return false;
		}
		TrackId other = (TrackId) obj;
		return Objects.equals(albumTitle, other.albumTitle) && Objects.equals(artistName, other.artistName)
				&& Objects.equals(trackTitle, other.trackTitle);
	}

}
