package org.niit.model;

public class Song {

    private int songId ;
    private String songName;
    private String songDuation;
    private String songReleasDate;
    private Album album;
    private String genre;
    
    // Used To Store And retrieve the Values when Insert Operation is performed using JDBC

    public Song(int songId, String songName, String songDuation, String songReleasDate, Album album,String genre) {
        this.songId = songId;
        this.songName = songName;
        this.songDuation = songDuation;
        this.songReleasDate = songReleasDate;
        this.album = album;
        this.genre = genre;

    }

    public Song(int songId, String songName, String songDuation, String songReleasDate, String genre) {
        this.songId = songId;
        this.songName = songName;
        this.songDuation = songDuation;
        this.songReleasDate = songReleasDate;
        this.genre = genre;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuation() {
        return songDuation;
    }

    public void setSongDuation(String songDuation) {
        this.songDuation = songDuation;
    }

    public String getSongReleasDate() {
        return songReleasDate;
    }

    public void setSongReleasDate(String songReleasDate) {
        this.songReleasDate = songReleasDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songDuation='" + songDuation + '\'' +
                ", songReleasDate='" + songReleasDate + '\'' +
                ", album=" + album +
                ", genre=" + genre +
                '}';
    }




}
