//package mk.ukim.finki.wp.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Album;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DataHolder {
//    public static List<Artist> artists = new ArrayList<>();
//    public static List<Song> songs = new ArrayList<>();
//    public static List<Album> albums = new ArrayList<>();
//
//    @PostConstruct
//    public void init() {
//        // Initialize artists list with sample data
//        //artists = new ArrayList<>();
//        artists.add(new Artist(1L, "John", "Lennon", "Member of The Beatles"));
//        artists.add(new Artist(2L, "Paul", "McCartney", "Singer, songwriter, and composer"));
//        artists.add(new Artist(3L, "Freddie", "Mercury", "Lead vocalist of Queen"));
//        artists.add(new Artist(4L, "Elton", "John", "Singer, pianist, and composer"));
//        artists.add(new Artist(5L, "David", "Bowie", "Iconic singer and actor"));
//
//        // Initialize albums list
//        albums.add(new Album(1L, "Imagine", "Rock", "1971"));
//        albums.add(new Album(2L, "Abbey Road", "Rock", "1969"));
//        albums.add(new Album(3L, "A Night at the Opera", "Rock", "1975"));
//        albums.add(new Album(4L, "Goodbye Yellow Brick Road", "Pop", "1973"));
//        albums.add(new Album(5L, "The Rise and Fall of Ziggy Stardust", "Rock", "1972"));
//
//        // Initialize songs list
//        songs.add(new Song("T1", "Imagine", "Rock", 1971, albums.get(0), List.of(artists.get(0))));
//        songs.add(new Song("T2", "Hey Jude", "Rock", 1968, albums.get(1), List.of(artists.get(1))));
//        songs.add(new Song("T3", "Bohemian Rhapsody", "Rock", 1975, albums.get(2), List.of(artists.get(2))));
//        songs.add(new Song("T4", "Rocket Man", "Pop", 1972, albums.get(3), List.of(artists.get(3))));
//        songs.add(new Song("T5", "Space Oddity", "Rock", 1969, albums.get(4), List.of(artists.get(4))));
//
//    }
//}
