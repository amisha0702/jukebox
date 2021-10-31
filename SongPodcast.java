package org.niit.model;


import org.niit.dao.impl.MusicImplDao;
import org.niit.dao.playlistImpl;
import org.niit.service.searchservices.SongCatalog;
import org.niit.service.jukeboxservice.JukeBoxServiceImpl;
import org.niit.service.playservice.MusicPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SongPodcast implements playlistImpl {
	private int musicid;
	private String musicName;
	private String albumName;
	private String duration;
	private String path;
	
	// This class is used as implementing class for interface Playlist . Also this class is used creating the playlist
	// of songs or podcast which the user hae searched in the task 2
	public SongPodcast(int musicid, String musicName, String albumName, String duration, String path) {
		this.musicid = musicid;
		this.musicName= musicName;
		this.albumName = albumName;
		this.duration = duration;
		this.path = path;
		
	}
	
	public SongPodcast() {
	
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getMusicid() {
		return musicid;
	}
	
	public void setMusicid(int musicid) {
		this.musicid = musicid;
	}
	
	public String getMusicName() {
		return musicName;
	}
	
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	public static void display() {
		System.out.println(PlayList.playlist);
	}
	
	
	// Task 4 Retrieving the Music Location which is to be passed to the Music Player
	public static List<String> MusicPath(List<SongPodcast> songPodcasts) throws UnsupportedAudioFileException, LineUnavailableException, IOException
	{
		String musicpath = null;
		List<SongCatalog> songList = MusicImplDao.jukeBoxData();
		List<String> pathList = new ArrayList<>();
		MusicPlayer music = new MusicPlayer();
		for (SongPodcast songPodcast : songPodcasts)
		{
			pathList.add(songPodcast.getPath());

		}
		return pathList;
	}
	
	// Overiding ToString Method
	@Override
	public String toString()
	{
		return "SongPodcast{" +
				"musicid=" + musicid +
				", musicName='" + musicName + '\'' +
				", albumName='" + albumName + '\'' +
				", duration='" + duration + '\'' +
				",path='"+ path +'\''+
				'}';
	}
	
	// Task 3 Creating the playList
	@Override
	public void createPlayList() {
		List<String> usersearchSongPodList = new ArrayList<>();
	
		if (JukeBoxServiceImpl.songpodcastlist.isEmpty()) {
			System.out.println("No songs in the list");
			
		} else {
			for (int i = 0; i < JukeBoxServiceImpl.songpodcastlist.size(); i++)
				usersearchSongPodList.add(JukeBoxServiceImpl.songpodcastlist.get(i).getMusicName());
			
			SongPodcast songPodcast = new SongPodcast();
			songPodcast.viewPlayList(usersearchSongPodList);
			
		}
	}
	
	
	// Task 3 Viewing the Playlist
	@Override
	public void viewPlayList(List<String> userlist) {
		int j = 1;
		for (int i = 0; i < userlist.size(); i++) {
			System.out.println(j + ")" + userlist.get(i));
			j++;
		}
	}
}
