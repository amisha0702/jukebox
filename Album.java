package org.niit.model;

import java.util.List;


// Pojo Class For Album. Used to store the value when insert operation is Performed Using JDBC
public class Album {
	private int albumId;
	private double rating;
	private String albumName;
	private List<Song> songList;
	
	
	public Album(int albumId) {
		this.albumId = albumId;
	}
	
	public Album(int albumId, double rating, String albumName) {
		this.albumId = albumId;
		this.rating = rating;
		this.albumName = albumName;
	}
	
	public Album(int albumId, double rating, String albumName, List<Song> songList) {
		this.albumId = albumId;
		this.rating = rating;
		this.albumName = albumName;
		this.songList = songList;
	}
	
	
	public List<Song> getSongList() {
		return songList;
	}
	
	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	
	public int getAlbumId() {
		return albumId;
	}
	
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	@Override
	public String toString() {
		return "Album{" +
				"albumId=" + albumId +
				", rating=" + rating +
				", songList=" + songList +
				", AlbumName = " + albumName +
				'}';
	}
}
