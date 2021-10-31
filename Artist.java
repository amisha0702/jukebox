package org.niit.model;

import java.util.List;

// Used To Store the Values when Insert Operation is performed using JDBC
public class Artist {
	private int artistId;
	private String artistName;
	private int artistRating;
	private List<Song> songList;
	
	public Artist(int artistId, String artistName, int artistRating, List<Song> songList) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistRating = artistRating;
		this.songList = songList;
	}
	
	public Artist(int artistId, String artistName, int artistRating) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistRating = artistRating;
	}
	
	public int getArtistId() {
		return artistId;
	}
	
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	
	public String getArtistName() {
		return artistName;
	}
	
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public int getArtistRating() {
		return artistRating;
	}
	
	public void setArtistRating(int artistRating) {
		this.artistRating = artistRating;
	}
	
	public List<Song> getSongList() {
		return songList;
	}
	
	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	
	@Override
	public String toString() {
		return "Artist{" +
				"artistId=" + artistId +
				", artistName='" + artistName + '\'' +
				", artistRating=" + artistRating +
				", songList=" + songList +
				'}';
	}
}
