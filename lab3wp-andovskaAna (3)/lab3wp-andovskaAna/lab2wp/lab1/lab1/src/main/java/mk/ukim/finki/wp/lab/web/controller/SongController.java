package mk.ukim.finki.wp.lab.web.controller;

//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
//import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
//import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;
   // private final ArtistService artistService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
      //  this.artistService=artistService;
    }

    // Display all songs
    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("error", error);
        return "listSongs"; // Points to listSongs.html
    }

    // Show form to add a new song
    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("formAction", "/songs/add"); // Set action for adding a new song
        model.addAttribute("song", null);
        model.addAttribute("albums", albumService.findAll());
      //  model.addAttribute("artists", DataHolder.artists); // Assuming artists are stored in DataHolder
        return "add-song"; // Points to add-song.html
    }

    // Save a new song
    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        Album album = albumService.findById(albumId);
        if (album != null) {
            Song song = new Song();
            song.setTitle(title);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            song.setAlbum(album);
            songService.save(song); // Track ID will be generated here
        }
        return "redirect:/songs";
    }


    // Show form to edit an existing song
    @GetMapping("/edit/{songId}")
    public String getEditSongForm(@PathVariable Long songId, Model model) {
        Song song = songService.findById(songId);
        if (song == null) {
            return "redirect:/songs?error=SongNotFound";
        }
        model.addAttribute("formAction", "/songs/edit/" + songId); // Set action for editing the song
        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
       // model.addAttribute("artists", DataHolder.artists);
        return "add-song"; // Points to add-song.html
    }

    @PostMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
//        // Fetch the existing song
          Song existingSong = songService.findById(songId);
//        if (existingSong == null) {
//            return "redirect:/songs?error=SongNotFound";
//        }
//
//        // Fetch the album
          Album album = albumService.findById(albumId);
//        if (album == null) {
//            return "redirect:/songs?error=AlbumNotFound";
//        }

        // Update the existing song
        existingSong.setTitle(title);
        existingSong.setGenre(genre);
        existingSong.setReleaseYear(releaseYear);
        existingSong.setAlbum(album);

        // Save the updated song
        songService.save(existingSong);

        return "redirect:/songs";
    }


    // Delete a song by ID
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/songs";
    }






}
