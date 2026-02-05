package org.lessons.java.best_of_the_year.controllers;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Alessandro");
        return "home";
    }

    private Movie[] getBestMovies() {
        return new Movie[] {
                new Movie(1, "Harry Potter"),
                new Movie(2, "La città incantata"),
                new Movie(3, "Star Wars"),
                new Movie(4, "Pulp Fiction"),
                new Movie(5, "Parasite")
        };
    }

    private Song[] getBestSongs() {
        return new Song[] {
                new Song(1, "Rosenrot"),
                new Song(2, "Toxicity"),
                new Song(3, "Radio"),
                new Song(4, "Adieu"),
                new Song(5, "Hunting Soul")
        };
    }

    @GetMapping("/movies")
    public String movies(Model model) {

        Movie[] movies = getBestMovies();
      
        model.addAttribute("movies", movies);

        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        Song[] songs = getBestSongs();
    
        model.addAttribute("songs", songs);

        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String moviesId(Model model, @PathVariable("id") int id) {

        Movie[] movies = getBestMovies();
        Movie movieFound = null;

        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() == id) {
                movieFound = movies[i];
                break;
            }
        }
        model.addAttribute("movieFound", movieFound);
        return "movie-detail";
    }

    @GetMapping("/songs/{id}")
    public String songsId(Model model, @PathVariable("id") int id) {

        Song[] songs = getBestSongs();
        Song songFound = null;

        for (int i = 0; i < songs.length; i++) {
            if (songs[i].getId() == id) {
                songFound = songs[i];
                break;
            }
        }
        model.addAttribute("songFound", songFound);
        return "song-detail";
    }

}
