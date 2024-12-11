package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Song findById(Long id);
    void save(Song song);
    void update(Long id, Song updatedSong);
    void delete(Long id);
    List<Song> findAllByAlbumId(Long albumId);
}
