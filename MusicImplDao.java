package org.niit.dao.impl;

import org.niit.model.*;
import org.niit.service.searchservices.SongCatalog;
import org.niit.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  This Class is used for All the MYSQL operation like Inserting the data inside the table and retrieving the data from the tables
public class MusicImplDao
{


	public static Connection connection = DBConnection.getConnection();
	public static List<Song> songlist = new ArrayList<>();
	public static List<Album> albumlist = new ArrayList<>();
	public static List<Podcast> podcastList = new ArrayList<>();
	public static List<Artist> artistList = new ArrayList<>();

	 // Inserting the data into the Song Table , Album Table ,Podcast Table And Artist Table
	public static void insertSongsData()
    {
		List<Song> songlist = new ArrayList<>();
		List<Album> albumlist = new ArrayList<>();
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		int result5 = 0;
		int result6 = 0;
		int result7 = 0;
		int result8 = 0;
		int result9 = 0;
		Song song1 = new Song(1, "21Guns", "5:22", "2009-05-25", "Classic");
		Song song2 = new Song(2, "Before the Lobotomy", "4:37", "2009-05-25", "Rock");
		Song song3 = new Song(3, "Fix You", "4:45", "2005-08-05", "Alternative");
		Song song4 = new Song(4, "Swallowed in the sea", "3:56", "2005-08-05", "Rock");
		Song song5 = new Song(5, "Til kingdom Come", "4:11", "2005-06-06", "Pop");
		Song song6 = new Song(6, "Die In Your Arms", "4:45", "2005-06-13", "Classic");
		Song song7 = new Song(7, "Boyfriend", "2:51", "2012-03-26", "pop");
		Song song8 = new Song(8, "As Long As You ove Me", "03:49", "2010-07-10", "Alternative");
		Song song9 = new Song(9, "Zombie", "5:06", "1994-07-19", "Alternative");
		Song song[] = new Song[]{song1, song2, song3, song4, song5, song6, song7, song8, song9};
		songlist = Arrays.asList(song);

		for (int i = 0; i < songlist.size(); i++)
		{

			try
            {
				PreparedStatement prepare = connection.prepareStatement("insert into SongTable (SongId,SongTitle,SongDuration,SongReleaseDate,Genre )values (?,?,?,?,?)");
				int songid = songlist.get(i).getSongId();
				String Songname = songlist.get(i).getSongName();
				String songTime = songlist.get(i).getSongDuation();
				String date = songlist.get(i).getSongReleasDate();
				String Genre = songlist.get(i).getGenre();

				prepare.setInt(1, songid);
				prepare.setString(2, Songname);
				prepare.setString(3, songTime);
				prepare.setString(4, date);
				prepare.setString(5, Genre);
				result1 = prepare.executeUpdate();

			} catch (SQLException throwables)
            {
				throwables.printStackTrace();
			}
		}


		Album album1 = new Album(1, 4.5, "21 Century Breakdown");
		Album album2 = new Album(2, 4, "Believe");
		Album album3 = new Album(3, 5, "X&Y");
		Album album4 = new Album(4, 4.7, "No Need to argue");
		Album album[] = new Album[]{album1, album2, album3, album4};
		albumlist = Arrays.asList(album);
		for (int j = 0; j < albumlist.size(); j++)
		{

			try
            {
				PreparedStatement prepare1 = connection.prepareStatement("insert into AlbumTable (AlbumId,Rating,AlbumName)values (?,?,?)");

				int AlbumId = albumlist.get(j).getAlbumId();
				Double Rating = albumlist.get(j).getRating();
				String albumName = albumlist.get(j).getAlbumName();

				prepare1.setInt(1, AlbumId);
				prepare1.setDouble(2, Rating);
				prepare1.setString(3, albumName);

				result2 = prepare1.executeUpdate();


			} catch (SQLException throwables)
            {
				throwables.printStackTrace();
			}
		}


		Podcast podcast1 = new Podcast(1, "Office Ladies", "Jenna Fisher", "2019-07-12", "1:30", "src/main/java/org.Niit/Resources/The Office - The Pilot (T1 - E1) - Office Ladies Podcast #1  (También en español).wav");
		Podcast podcast2 = new Podcast(2, "Need A Friend", "Connan O Brian", "2018-10-23", "0:50", "src/main/java/org.Niit/Resources/David Letterman · Conan O’Brien Needs A Friend.wav");
		Podcast podcast3 = new Podcast(3, "What's the tee", "RuPual", "2019-04-28", "1:20", "src/main/java/org.Niit/Resources/RuPaul - Whats the Tee with Michelle Visage, Ep 70 - Aubrey Plaza.wav");
		Podcast podcast4 = new Podcast(4, "The Last Laugh", "Mindy Kaling", "2018-04-13", "1:00", "src/main/java/org.Niit/Resources/Coldplay_-_Fix_You_Qoret.com.wav");
		Podcast podcast[] = new Podcast[]{podcast1, podcast2, podcast3, podcast4};
		podcastList = Arrays.asList(podcast);

		for (int i = 0; i < podcastList.size(); i++)
		{

			try
            {
				PreparedStatement prepare2 = connection.prepareStatement("insert into podcastTable values (?,?,?,?,?)");

				int PoddcastId = podcastList.get(i).getPodcastId();
				String podcastName = podcastList.get(i).getPodcastName();
				String Celebrity = podcastList.get(i).getCelebrity();
				String podcastdate = podcastList.get(i).getReleaseDate();
				String podcastduration = podcastList.get(i).getPodcastDuration();

				prepare2.setInt(1, PoddcastId);
				prepare2.setString(2, podcastName);
				prepare2.setString(3, Celebrity);
				prepare2.setString(4, podcastdate);
				prepare2.setString(5, podcastduration);

				result3 = prepare2.executeUpdate();
			}
			catch (SQLException throwables)
            {
				throwables.printStackTrace();
			}
		}

		Artist artist1 = new Artist(1, "Chris Martin", 10);
		Artist artist2 = new Artist(2, "Billie Joe Armstrong", 9);
		Artist artist3 = new Artist(3, "Justin Beiber", 8);
		Artist artist4 = new Artist(4, "Sinead O Connor", 9);
		Artist artist[] = new Artist[]{artist1, artist3, artist2, artist4};
		artistList = Arrays.asList(artist);

		for (int j = 0; j < artistList.size(); j++)
		{

			try
            {
				PreparedStatement prepare1 = connection.prepareStatement("insert into ArtistTable (ArtistId,ArtistName,ArtistRating)values (?,?,?)");

				int ArtistId = artistList.get(j).getArtistId();
				String ArtistName = artistList.get(j).getArtistName();
				int Artistrating = artistList.get(j).getArtistRating();

				prepare1.setInt(1, ArtistId);
				prepare1.setString(2, ArtistName);
				prepare1.setInt(3, Artistrating);

				result4 = prepare1.executeUpdate();


			} catch (SQLException throwables)
            {
				throwables.printStackTrace();
			}
		}
		Statement statement1 = null;
		Statement statement2 = null;
		Statement statement3 = null;
		Statement statement4 = null;
		Statement statement5 = null;
		try
        {
			statement1 = connection.createStatement();
			result5 = statement1.executeUpdate("Insert into Artist_Song_Table (Artist_SongId, Artist_id, song_id) " +
					"values(1,2,1),(2,2,2),(3,1,3),(4,1,4),(5,1,5),(6,3,6),(7,3,7),(8,3,8),(9,4,9)");
			statement2 = connection.createStatement();
			result6 = statement2.executeUpdate("update SongTable set AlbumId = 3 where  songId in (3,4,5)");
			statement3 = connection.createStatement();
			result7 = statement3.executeUpdate("update SongTable set AlbumId = 1 where  songId in (1,2)");
			statement4 = connection.createStatement();
			result8 = statement4.executeUpdate("update SongTable set AlbumId = 2 where  songId in (6,7,8)");
			statement5 = connection.createStatement();
			result9 = statement5.executeUpdate("update SongTable set AlbumId = 4 where  songId =  9");


		} catch (SQLException throwables)
        {
			throwables.printStackTrace();
		}
	}

	public static List<SongCatalog> jukeBoxData()
    {
		List<SongCatalog> songCatalogs = new ArrayList<>();
		try
        {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select A.songId, B.AlbumName,A.songTitle,A.SongDuration, A.Genre ,A.path ,t.ArtistName\n" +
					"from SongTable A\n" +
					"join AlbumTable B \n" +
					"on A.AlbumId = B.AlbumId\n" +
					"join( select C.ArtistName ,D.Song_id\n" +
					"from ArtistTable C\n" +
					"join Artist_Song_Table D\n" +
					"on D.artist_id = C.ArtistId )t\n" +
					"on t.Song_id = A.SongId");
			while (resultSet.next()) {
				int songid = resultSet.getInt(1);
				String album = resultSet.getString(2);
				String song = resultSet.getString(3);
				String duration = resultSet.getString(4);
				String genre = resultSet.getString(5);
				String artist = resultSet.getString(7);
				String path = resultSet.getString(6);
				SongCatalog songCatalog = new SongCatalog(songid, album, song, duration, path, genre, artist);
				songCatalogs.add(songCatalog);
			}
		} catch (SQLException throwables)
        {
			throwables.printStackTrace();


		}


		return songCatalogs;
	}

	public static List<Podcast> jukeBoxpodcast()
    {
		List<Podcast> podcastList = new ArrayList<>();
		try
        {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from  podcastTable ");

			while (resultSet.next())
			{
				int pid = resultSet.getInt(1);
				String pname = resultSet.getString(2);
				String pcelebrity = resultSet.getString(3);
				String pdate = resultSet.getString(4);
				String pduration = resultSet.getString(5);

				Podcast podcast = new Podcast(pid, pname, pcelebrity, pdate, pduration);
				podcastList.add(podcast);
			}
		} catch (SQLException throwables)
        {
			throwables.printStackTrace();
		}

		return podcastList;
	}

	// Retriving the SongData from the SongTable
	public static List<Song> SongData()
    {
		int i = 0;
		List<Song> songList = new ArrayList<>();
		List<Album> albumlist = new ArrayList<>();
		List<PlayList> playList = new ArrayList<>();
		try
        {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from SongTable");

			while (resultSet.next())
			{
				int songId = resultSet.getInt(1);
				String songTitle = resultSet.getString(2);
				String songDuration = resultSet.getString(3);
				String songReleaseDate = resultSet.getString(4);
				int albumId = resultSet.getInt(5);
				String genre = resultSet.getString(6);
				Song song = new Song(songId, songTitle, songDuration, songReleaseDate, new Album(albumId), genre);
				songList.add(song);
			}
		} catch (SQLException throwables)
        {
			throwables.printStackTrace();


		}
		return songList;
	}

	public static List<Album> Albumdata()
    {
		List<Song> songsList = MusicImplDao.SongData();

		try
        {
			Statement statement = connection.createStatement();
			ResultSet resultSet1 = statement.executeQuery("select * from AlbumTable");
			while (resultSet1.next())
			{
				int Albumid = resultSet1.getInt(1);
				double rating = resultSet1.getDouble(2);
				String albumName = resultSet1.getString(3);


				Album album = new Album(Albumid, rating, albumName, songsList);
				albumlist.add(album);
			}
		} catch (SQLException throwables)
        {
			throwables.printStackTrace();
		}

		return albumlist;
	}


}









