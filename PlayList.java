package org.niit.model;

import org.niit.dao.impl.MusicImplDao;
import org.niit.dao.playlistImpl;
import org.niit.service.searchservices.SongCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayList implements playlistImpl {

		public static List<SongPodcast> playlist = new ArrayList<>();

		static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

		static List<String> userlist = new ArrayList<>();

		public void createPlayList() {

			PlayList playList = new PlayList();
			List<SongCatalog> Songlist = MusicImplDao.jukeBoxData();
			List<Podcast> podcastList = MusicImplDao.jukeBoxpodcast();
			System.out.println("Enter the Choice of playlist You want to create  ");
			System.out.println("1 Songs");
			System.out.println("2 Podcast");
			System.out.println("3 Combination Of Both");
			int userchoice = scanner.nextInt();
			scanner.nextLine();


			switch (userchoice) {
				case 1: {

					System.out.println("Here are the list Of Songs ");
					List<SongCatalog> SongList = MusicImplDao.jukeBoxData();
					System.out.format("%5s %30s %20s %20s %15s", "SongId", "Song Name", "Genre", "Artist", "Album Name\n");
					for (SongCatalog songs : SongList) {
						System.out.printf("%5s %30s %20s %20s %15s", songs.getSongId(), songs.getSongTitle(), songs.getGenre(), songs.getArtistName(), songs.getAlbumName());
						System.out.println();
					}

					System.out.println("enter the number of songs to be added");

					int noOfsongs = scanner.nextInt();

					System.out.println("enter the Songid's to be added to the play List");

					for (int i = 0; i < noOfsongs; i++) {
						int songid = scanner.nextInt();

						for (SongCatalog songs : Songlist) {

							if (songid == songs.getSongId()) {
								System.out.println(songs);
  								userlist.add(songs.getSongTitle());
								SongPodcast songPodcast = new SongPodcast(songs.getSongId(),songs.getSongTitle(),songs.getAlbumName(), songs.getDuration(), songs.getPath());
								playlist.add(songPodcast);
							}
						}

					}
					viewPlayList(userlist);
					break;
				}
				case 2: {
					System.out.println("Enter the number of podcast to be added");
					int noOfPodcast = scanner.nextInt();
					System.out.println("enter the Podcast's to be added to the play List");
					for (int i = 0; i < noOfPodcast; i++) {
						int podid = scanner.nextInt();
						for (Podcast podcast : podcastList) {
							if (podid == podcast.getPodcastId()) {
								userlist.add(podcast.getPodcastName());
								SongPodcast songPodcast = new SongPodcast(podcast.getPodcastId(), podcast.getPodcastName(), null, podcast.getPodcastDuration(), podcast.getPodcastpath());
								playlist.add(songPodcast);
							}
						}
					}
					viewPlayList(userlist);
					break;

				}
				case 3: {
					System.out.println("Enter the number of songs to be added");
					int noOfsongs = scanner.nextInt();
					System.out.println("Enter the number of podcast to be added");
					int noOfPodcast = scanner.nextInt();
					System.out.println("enter the Songid's to be added to the play List");
					for (int i = 0; i < noOfsongs; i++) {
						int songid = scanner.nextInt();
						for (SongCatalog songs : Songlist) {
							if (songid == songs.getSongId()) {
								userlist.add(songs.getSongTitle());
								SongPodcast songPodcast = new SongPodcast(songs.getSongId(), songs.getSongTitle(), songs.getAlbumName(), songs.getDuration(), songs.getPath());
								playlist.add(songPodcast);
							}


						}

					}
					System.out.println("enter the Podcast's to be added to the play List");
					for (int i = 0; i < noOfPodcast; i++) {
						int podid = scanner.nextInt();
						for (Podcast podcast : podcastList) {
							if (podid == podcast.getPodcastId()) {
								userlist.add(podcast.getPodcastName());
								SongPodcast songPodcast = new SongPodcast(podcast.getPodcastId(), podcast.getPodcastName(), null, podcast.getPodcastDuration(), podcast.getPodcastpath());
								playlist.add(songPodcast);
							}
						}
					}
					viewPlayList(userlist);
					break;
				}
				default:
					System.out.println("Sorry !! Wrong Choice");


			}
		}

		@Override
		public void viewPlayList(List<String> userlist) {
			System.out.println();
			int j = 1;
			System.out.println("The songs/Podcast in the playlist are as follows");
			for (int i = 0; i < userlist.size(); i++) {

				System.out.println(j + ")" + userlist.get(i));
				j++;
			}

		}

	}




