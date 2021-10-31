package org.niit.model;


import org.niit.dao.impl.MusicImplDao;
import org.niit.exception.CelebrityEmptyException;
import org.niit.exception.DateEmptyException;

import java.util.ArrayList;
import java.util.List;

// This class  is used for searching the podcast by Date as well as Celebrity Names
public class Podcast {
	private int podcastId;
	private String podcastName;
	private String celebrity;
	private String releaseDate;
	private String podcastDuration;
	private String podcastpath;
	
	public Podcast(int podcastId, String podcastName, String celebrity, String releaseDate, String podcastDuration, String podcastpath) {
		this.podcastId = podcastId;
		this.podcastName = podcastName;
		this.celebrity = celebrity;
		this.releaseDate = releaseDate;
		this.podcastDuration = podcastDuration;
		this.podcastpath = podcastpath;
	}

	public Podcast(int podcastId, String podcastName, String celebrity, String releaseDate, String podcastDuration) {
		this.podcastId = podcastId;
		this.podcastName = podcastName;
		this.celebrity = celebrity;
		this.releaseDate = releaseDate;
		this.podcastDuration = podcastDuration;
	}

	public int getPodcastId() {
		return podcastId;
	}
	
	public void setPodcastId(int podcastId) {
		this.podcastId = podcastId;
	}
	
	public String getPodcastName() {
		return podcastName;
	}
	
	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}
	
	public String getCelebrity() {
		return celebrity;
	}
	
	public void setCelebrity(String celebrity) {
		this.celebrity = celebrity;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getPodcastDuration() {
		return podcastDuration;
	}
	
	public void setPodcastDuration(String podcastDuration) {
		this.podcastDuration = podcastDuration;
	}
	
	public String getPodcastpath() {
		return podcastpath;
	}
	
	public void setPodcastpath(String podcastpath) {
		this.podcastpath = podcastpath;
	}
	
	@Override
	public String toString() {
		return "Podcast{" +
				"podcastId=" + podcastId +
				", podcastName='" + podcastName + '\'' +
				", celebrity='" + celebrity + '\'' +
				", releaseDate='" + releaseDate + '\'' +
				", podcastDuration='" + podcastDuration + '\'' +
				", podcastpath='" + podcastpath + '\'' +
				'}';
	}
	
	public Podcast() {
	
	}
	
	// Task 2 Search Podcast by date
	public List<Podcast> searchbyDate(String Date)
	{
		
		List<Podcast> plist = MusicImplDao.jukeBoxpodcast();
	 try{
		 if(plist.isEmpty())
		 {
		 	throw  new DateEmptyException("Incorrct Date");
		 }
	 }
	 catch (DateEmptyException e)
	 {
		 System.out.println(e);
	 }
	 
		
		
		List<Podcast> podcastListBydate = new ArrayList<>();
		
		for (int i = 0; i < plist.size(); i++)
		{
			if (plist.get(i).getReleaseDate().equals(Date))
			{
				
				podcastListBydate.add(plist.get(i));
				
			}
			
		}
		return podcastListBydate;
	}
	
	// Task 2 Search Podcast by Celebrity
	public List<Podcast> searchbyCelebrity(String celebrity)
	{
		List<Podcast> plist = MusicImplDao.jukeBoxpodcast();
		List<Podcast> podcastListBycelebrity = new ArrayList<>();
		try{
			if(plist.isEmpty())
			{
				throw  new CelebrityEmptyException("Incorrect Data");
			}
		}
		catch (CelebrityEmptyException e)
		{
			System.out.println(e);
		}
		
		for (int i = 0; i < plist.size(); i++)
		{
			if (plist.get(i).getCelebrity().equals(celebrity))
			{
				
				podcastListBycelebrity.add(plist.get(i));
				
			}
			
		}
		return podcastListBycelebrity;
	}
}
