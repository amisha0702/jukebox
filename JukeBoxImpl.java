package org.niit.dao;

import org.niit.service.searchservices.SongCatalog;

import java.util.List;

public interface JukeBoxImpl {

    // Task 2 to Search the Songs By Genre
     List<SongCatalog> searchGenre(String value);

     // Task 2 to Search the Songs By Artist
     List<SongCatalog> searchArtist(String value);

     // Task 2 to Search the Songs By Album
     List<SongCatalog> searchAlbum(String value);






}
